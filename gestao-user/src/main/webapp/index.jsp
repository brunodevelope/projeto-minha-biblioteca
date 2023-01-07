<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Seu Login</title>
</head>
<body style="overflow: hidden;">

	<style>
form {
	width: 600px;
	margin: 10% auto;
}
</style>

	<form method="post" action="<%=request.getContextPath()%>/login">

		<div>
			<h5>Realize  Seu Login...</h5>
		</div>
		<div class="mb-6">
			<label for="inputEmail4" class="form-label">Login </label> 
			<input name="login" type="text" class="form-control" id="inputEmail4">
		</div>

		<div class="mb-6">
			<label for="inputPassword4" class="form-label">Senha</label>
			 <input	name="senha" type="password" class="form-control"	id="inputPassword4">
		</div>
		<br>
		
		<div>
			<button title="ACESSAR" style="width: 100%" type="submit"	class="btn btn-primary">Acessar</button>
		</div>
		
         <br>
         <c:if test="${msg !=null }">
			<div
				style="color: #842029; background-color: #f8d7da; border-color: #f5c2c7; text-align: center; padding: 10px;"><h6>${msg }</h6>
				
			</div>
		</c:if>
	</form>


</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
</html>