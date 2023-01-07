<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<jsp:include page="header.jsp"></jsp:include>
<body>

	<div class="containe-fluid">
		<jsp:include page="nav-bar.jsp"></jsp:include>

		<main style="margin-top: 40px; height: 1200px;">
			<div style="margin: 80px auto; text-align: center; font-size: 24px;">Cadastrar
				Livros</div>
			<form style="width: 1000px; margin: auto;" class="row" method="post"	enctype="multipart/form-data">
				<div class="md-3">
					<img alt="" src="images/livro.jpg" id="previw" width="140px"	height="135px" style="border-radius: 50% 50%;"> <br> <br>
					<label for="fotoLivro">Foto Do Livro</label> 
					<input	accept="image/*" name="fotoLivro" onchange="carregarFoto()"	style="width: 300px;" id="fotoLivro" class="form-control"
						type="file" id="foto">
				</div>

				<div class="col-md-2">
					<label for="id" class="form-label">Cod</label> <input value=""
						type="text" name="id" class="form-control" id="id">
				</div>

				<div class="col-md-5">
					<label for="id" class="form-label">Nome Do Livro</label> <input
						value="" type="text" name="id" class="form-control" id="id">
				</div>
				<br> <br> <br> <br>

				<div class="input-group mb-5">
					<div class="col-md-5">
						<select class="form-select" id="inputGroupSelect01">
							<option selected>[Categoria]</option>
							<option value="TECNOLOGIA">Tecnologia</option>
							<option value="HISTORIA">historia</option>
							<option value="MATEMATICA">matematica</option>
							<option value="FISICA">fisica</option>
							<option value="QUIMICA">quimica</option>

						</select>
					</div>
				</div>


				<div class="col-md-5">
					<label for="dococumento">Escolha Seu Livro Em Pdf</label> <input
						accept="application/pdf " value="" type="file" name="documento"
						class="form-control" id="documento">
				</div>
				<br> <br> <br> <br> <label for="id"
					class="form-label">Descricao Do Livro</label>
				<textarea placeholder="Desecreva Sobre Esse Livro" class="col-md-12"
					rows="10" cols="50"></textarea>

				<div style="margin-top: 30px;" class="content">
					<button type="button" class="btn btn-primary">Enviar</button>
					<button type="button" class="btn btn-secondary">Cancelar</button>
				</div>

			</form>



		</main>

	</div>



	<jsp:include page="script.jsp"></jsp:include>

</body>
</html>