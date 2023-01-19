<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="header.jsp"></jsp:include>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<main style="margin-top: 40px; width: 100%; height: 100%;  position: absolute;">
		<div class="container pt-4">


			<c:if test="${msg != null}">
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>Menssagem !</strong> ${msg}.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>


			<div style="text-align: center; font-size: 24px;"><h1>Cadastra Usuario</h1></div>
			<form class="row" method="post" enctype="multipart/form-data"	action="<%=request.getContextPath()%>/salvar">

				<br>
				<div class="mb-3">
					<c:if test="${user.foto == null }">
						<img alt="" src="images/logo-perfil.jpg" id="previw" width="140px"
							height="135px" style="border-radius: 50% 50%;">
					</c:if>

					<c:if test="${user.foto != null }">
						<img alt="" src="${user.foto}" id="previw" width="140px"
							height="135px" style="border-radius: 50% 50%;">
					</c:if>
					<br> <br> <input accept="image/*" name="foto"
						onchange="carregarFoto()" style="width: 300px;"
						class="form-control" type="file" id="foto">
				</div>


				<div class="col-md-2">
					<label for="id" class="form-label">Id</label> <input
						readonly="true" value="${user.id }" type="text" name="id"
						class="form-control" id="id">
				</div>
				<div class="col-md-8">
					<label for="nome" class="form-label">Nome</label>
					<c:if test="${user.nome == null }">
						<input type="text" name="nome" value="${user.nome }"
							class="form-control" id="nome">
					</c:if>


					<c:if test="${user.nome != null }">
						<input type="text" name="nome" value="${user.nome }"
							readonly="readonly" class="form-control" id="nome">
					</c:if>

				</div>


				<div class="col-md-6">
					<label for="email" class="form-label">Email</label> <input
						type="email" name="email" value="${user.email }"
						class="form-control" id="email">
				</div>


				<div class="col-md-6">
					<label for="data-nascimento" class="form-label">Data
						Nscimento</label>
					<c:if test="${user.dataNascimento != null }">
						<input type="date" value="${user.dataNascimento }"
							readonly="readonly" name="data-nascimento" class="form-control"
							id="data-nascimento">
					</c:if>
					<c:if test="${user.dataNascimento == null }">
						<input type="date" value="${user.dataNascimento }"
							name="data-nascimento" class="form-control" id="data-nascimento">
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

				<div style="margin-top: 30px;" class="col-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<c:if test="${dados.administrador  }">
						<button type="button" id="bt-limpar" class="btn btn-danger">Limpar</button>
						<button type="button" id="bt-deletar" class="btn btn-success">Deletar</button>
						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#exampleModal">Pesquisar</button>
					</c:if>

				</div>


				<br>
			</form>
		</div>


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
	</main>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script type="text/javascript">
		function voltarMenu() {
			var btmenu = document.getElementById(" ul li > bt-home")
			{
				window.history.back();
			}
		}

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

		$("#bt-limpar").click(function() {
			limpar()
		});
		function limpar() {
			$("#id").val(null);
			$("#nome").val(null);
			$("#email").val(null);
			$("#login").val(null);
			$("#senha").val(null);
			$("#data-nascimento").val(null);
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