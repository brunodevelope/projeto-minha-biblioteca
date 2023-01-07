<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <div class="wrapper d-flex align-items-stretch">
 
			<nav id="sidebar" class="active" >
			<div class="p-4 pt-5">
			 <div class="content-" style="display:  flex; align-items: center;  flex-direction: column;   text-align: center;">
			   
			     <div class="content-background-image" style="height: 50px ; width: 50px; ">
					<c:if test="${dados.foto != null }">
						<img title=" minha foto" class="img logo rounded-circle mb-5"
							height="100% ;" width="100%" src="${dados.foto }"></img>
					</c:if>

					<c:if test="${dados.foto == null }">
						<img class="img logo rounded-circle mb-5" height="100% ;"
							width="100%" src="images/logo-perfil.jpg"></img>
					</c:if>
				</div>			  
			          
			     <br>
			       <h6>Seja Bem Vindo : ${dados.nome}<br></h6>
			 </div>
			  <br>
			 <br>

				<c:if test="${dados.administrador }">
					<div>Area Administrativa</div>
					<ul class="list-unstyled components mb-5">
						<li><a href="#">Cadastrar Livros</a></li>
						<li><a href="<%=request.getContextPath()%>/novousuario">Cadastrar Novo Usuario</a></li>
						<li><a href="<%=request.getContextPath()%>/novousuario">Lsta De Usuarios</a></li>
						<li><a href="#">Cadastra Cidades </a></li>
						<li><a href="#">Relatorios</a></li>
					</ul>
				</c:if>

				<ul class="list-unstyled components mb-5">
					<div>Area Do Usuario</div>
					<li><a href="#">Cadastrar Meus Livros </a></li>
					<li><a href="#">Minha Biblioteca</a></li>
					<li><a href="#">Editar Meus Dados</a></li>
					<li><a href="<%=request.getContextPath()%>/logout">Sair</a></li>
				</ul>
			</div>
    	</nav>
