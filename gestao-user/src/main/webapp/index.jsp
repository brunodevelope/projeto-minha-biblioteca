<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Login Do Usuario</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-xxl position-relative bg-white d-flex p-0">



		<div class="container-fluid">
			<div class="row h-100 align-items-center justify-content-center"	style="min-height: 100vh;">
			  
					<form id="formLogin"	class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4" method="post"	action="<%=request.getContextPath()%>/login">
					   <c:if test="${msg != null}">
						 <div class="alert alert-secondary alert-dismissible fade show" role="alert">
                                <i class="fa fa-exclamation-circle me-2"></i><font _mstmutation="1" _msttexthash="1794832" _msthash="53">${msg}! </font><button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Fechar" _mstaria-label="59709" _msthash="52"></button>
                         </div>
					   </c:if>
                         
						<div
							class="d-flex align-items-center justify-content-between mb-3">
							<h3>Faça Seu Login</h3>
						</div>

						<div class="form-floating mb-3">
							<input name="login" type="text" class="form-control" id="login"
								placeholder="Entre Com Seu Login"> <label for="login">Seu
								Login</label>
						</div>
						<div class="form-floating mb-4">
							<input name="senha" type="password" class="form-control"	id="senha" placeholder="Entre Com Sua Senha"> 
							<label	for="senha">Sua Senha</label>
						</div>
						
						<a href="">Recuperar Senha ...</a>
						
						<button id="bt-enviar" type="submit"	class="btn btn-primary py-3 w-100 mb-4">Acessar</button>
						<p class="text-center mb-0">
							cadastre-se ? <a href="">Cadastrar Conta </a>
						</p>
					</form>
					</div>
				</div>
			</div>



	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- Template Javascript -->
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/chart/chart.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/tempusdominus/js/moment.min.js"></script>
<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
<script src="js/main.js"></script>

</html>
