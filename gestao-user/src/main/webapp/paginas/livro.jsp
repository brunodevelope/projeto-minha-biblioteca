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
			                   <h3 style="color: #808080; text-align: center;" class="title">Cadastrar Livro</h3>
			      </div>
			      
				<div class="body-form"  style="margin-top: 50px;" >
					<div class="col">					
						<form enctype="multipart/form-data"  id="formlivro" class="row g-3"	action="<%=request.getContextPath() %>/salvarlivro" method="post">
						
							<div class="col-md-2">
								<label for="codigolivro" class="form-label">Cod: Do  Livro</label>
								 <input type="text"	class="form-control" name="codigolivro" id="codigolivro">
							</div>
							
							<div class="col-md-4">
								<label for="titulolivro" class="form-label">Titulo Do Livro </label>
								 <input type="text"	name="titulolivro" class="form-control" id="titulolivro">
							</div>
							
							<div class="col-md-4">
								<label for="subtitulo" class="form-label">Sub-Titulo Do Livro</label>
								 <input type="text" name="subtitulo"	class="form-control" id="subtitulo">
							</div>
							
							
							<div class="col-md-4">
								<label for="autorlivro" class="form-label">Autor Do  Livro</label>
								 <input type="text" name="autorlivro"	class="form-control" id="autorlivro">
							</div>
							
							
							<div class="col-md-4">
								<label for="quantidadepaginas" class="form-label">Quant Paginas Do Livro</label>
								 <input type="number" name="quantidadepaginas"	class="form-control" id="quantidadepaginas">
							</div>
							
							<div class="col-md-4">
								<label for="anexo" class="form-label">Anexe Aqui Seu Livro</label>
								 <input type="file" name="anexo" accept="application/pdf"	class="form-control" id="anexo">
							</div>

						

							<div class="col-md-8" >
							   <label for="descricaolivro">Descricao Do Livro</label>
								<textarea id="descricaolivro" name="descricaolivro"  rows="3" maxlength="300" class="form-control" placeholder="Maximo 300 Caracteres" id="floatingTextarea"></textarea>
							</div>

                               <div class="col-12">
								<button type="submit" class="btn btn-primary">Salvar Livro</button>
								
							</div>

						</form>

                       
					
				</div>
			</div>


		</div>
	</div>
	
	<jsp:include page="script.jsp"></jsp:include>


</body>

</html>