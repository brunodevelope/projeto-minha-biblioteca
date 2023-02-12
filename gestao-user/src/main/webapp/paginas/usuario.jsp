<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="container-xxl position-relative bg-white d-flex p-0">
		<jsp:include page="sider-bar.jsp"></jsp:include>
		<div class="content">
			<jsp:include page="nav-bar.jsp"></jsp:include>
			<div class="container" style="height: 100%;">
			   
			      <div class="title-page" style="height: 50px; margin-top: 30px;">
			                   <h3 style="color: #808080; text-align: center;" class="title">Cadastrar Usuarios</h3>
			      </div>
			      
				<div class="body-form"  style="margin-top: 50px;" >

					<c:if test="${msg != null}">
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							<i class="fa fa-exclamation-circle me-2"></i><font
								_mstmutation="1" _msttexthash="1590017" _msthash="57">${msg}!
							</font>
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Fechar" _mstaria-label="59709" _msthash="56"></button>
						</div>
					</c:if>

					<div>
						<div class="body-file">
							<div class="content-file ">
								<c:if test="${user.foto == null }">
									<img alt="" id="previw" src="img/perfil2.jpg">
								</c:if>

								<c:if test="${user.foto != null }">
									<img alt="" id="previw" src="${user.foto }">
								</c:if>
							</div>
						</div>
					</div>

					<div class="col">

						<form enctype="multipart/form-data" class="row g-3"
							action="<%=request.getContextPath()%>/salvar" method="post">
							<div class="row-md-3">
								<div class="col-8">
									<label for="foto" class="form-label">Coleque Sua Foto
										Aqui</label> <input type="file" name="foto" onchange="carregarFoto();"
										accept="image/*" class="form-control" id="foto">
								</div>

							</div>

							<div class="col-md-1">
								<label for="id" class="form-label">Id</label>
								<c:if test="${user.id!= null }">
									<input type="text" readonly="readonly" value="${user.id }"
										name="id" class="form-control" id="id">
								</c:if>
								<c:if test="${user.id== null }">
									<input type="text" value="${user.id }" name="id"
										class="form-control" id="id">
								</c:if>
							</div>

							<div class="col-md-6">
								<label for="nome" class="form-label">Nome</label>
								     <input  type="text" value="${user.nome }" name="nome"	class="form-control" id="nome">
							
							</div>

							<div class="col-md-6">
								<label for="email" class="form-label">E-mail</label> <input
									type="email" value="${user.email }" name="email"
									class="form-control" id="email">
							</div>

							<div class="col-md-6">
								<label for="dataNascimento" class="form-label">Data
									Nascimento</label> 
									<c:if test="${user.dataNascimento  !=null}">
									      <input readonly="readonly" type="date" value="${user.dataNascimento }"	name="dataNascimento" class="form-control" id="dataNascimento">
									</c:if>
									
									<c:if test="${user.dataNascimento  ==null}">
									      <input  type="date" value="${user.dataNascimento }"	name="dataNascimento" class="form-control" id="dataNascimento">
									</c:if>
							</div>

							<div class="col-md-6">
								<label for="login" class="form-label">Login</label> <input
									type="text" value="${user.login }" name="login"
									class="form-control" id="login">
							</div>

							<div class="col-md-6">
								<label for="senha" class="form-label">Senha</label> <input
									type="password" value="${user.senha }" name="senha"
									class="form-control" id="senha">
							</div>


							<div class="col-12">
								<button type="submit" class="btn btn-primary">Salvar Usuario</button>
								<button type="button" class="btn btn-primary" id="btn-limpar">Limpar</button>
								<button type="button" id="bt-deletar" class="btn btn-primary">Deletar	Usuario</button>
								<button type="button" class="btn btn-primary"		data-bs-toggle="modal" data-bs-target="#exampleModal">Pesquisar Usuario</button>

							</div>
						</form>

					</div>
					<!-- modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Pesquisar
										Usuario Por Nome</h5>

								</div>
								<div class="modal-body">
									<div class="input-group mb-3">
										<input type="text" id="nome-pesquisado" class="form-control"
											placeholder="digite o nome do usuario  "
											aria-label="Recipient's username"
											aria-describedby="button-addon2">
										<button class="btn btn-success" type="button" id="bt-buscar">Buscar
										</button>
									</div>
									<div class="container" style="height: 300px; overflow: scroll;">
										<table id="tabela" class="table">
											<thead>
												<tr>
													<th scope="col">ID</th>
													<th scope="col">NOME</th>
													<th scope="col">EMAIL</th>
													<th scope="col">VER</th>
												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
								</div>
								<div style="text-align: center; color: blue;">
									<p id="total"></p>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-bs-dismiss="modal">Feichar</button>

								</div>
							</div>
						</div>
					</div>

				</div>
			</div>


		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<script type="text/javascript">
		function carregarFoto() {
			var foto = document.getElementById("foto").files[0];
			var previw = document.getElementById("previw")
			var reader = new FileReader();
			reader.onloadend = function() {
				previw.src = reader.result
				window.console.log(reader.result);
			};

			if (foto) {
				reader.readAsDataURL(foto);
			} else {
				previw.src = "";
			}

		}

		$("#bt-deletar").click(function() {
			var campoId = $("#id").val();
			if (campoId === '' || campoId === null) {
				alert("O Id Do Usuario E Obrigatorio")
			} else {
				if (window.confirm("deseja deletar esse usuario ")) {
					$.ajax({
						type : "get",
						url : "deletarusuario?idUser=" + campoId,
						success : function(resposta) {
							limpar();
							alert(resposta)
						},
						error : function() {
							alert("erro")
						}
					});

				} else {
					alert("Operacao cancelada")
				}
			}
		});

		$("#btn-limpar").click(function() {
			limpar()
		});
		function limpar() {
			$("#id").val(null);
			$("#nome").val(null);
			$("#email").val(null);
			$("#login").val(null);
			$("#senha").val(null);
			$("#dataNascimento").val(null);

		}

		function voltarInicio() {
			window.local.history;
		}

		$("#bt-buscar").click(function() {
			pesquisarUsuario();

		});

		function pesquisarUsuario() {
			var nome = $("#nome-pesquisado").val()
			if (nome === null || nome === '') {
				alert("O campo nao pode esta vazio")
			} else {
				$
						.ajax({
							type : "get",
							url : "pesquisar?nomeUser=" + nome,
							success : function(resposta) {
								var objeto = JSON.parse(resposta);
								if (objeto.length > 0) {
									$("#tabela > tbody  tr").remove();

									for (var index = 0; index < objeto.length; index++) {
										$("#nome-pesquisado").val("")
										var montarTabela = "<tr><td>"
												+ objeto[index].id
												+ "</td><td>"
												+ objeto[index].nome
												+ "</td><td>"
												+ objeto[index].email
												+ "</td><td><button id='ver' type='button' onclick='verDados("
												+ objeto[index].id
												+ ")' class='btn btn-primary'>Ver</button></td></tr>"
										$("#tabela > tbody").prepend(
												montarTabela)
										document.getElementById("total").textContent = "Total De Registros Encontrado  :"
												+ objeto.length
									}
								} else {
									$("#nome-pesquisado").val("")
									alert("NADA ENCONTRADO")
								}

							},
							error : function(request, status, error) {
								alert(
										"UM ERRO OCORREU "
												+ request.responseText, status);
							}

						});

			}
		}

		function verDados(login) {
			if (login !== null && login !== '') {
				window.location.href = "detalhes?idUsuario=" + login
			}
		}
	</script>
	<jsp:include page="script.jsp"></jsp:include>

	



</body>

</html>