<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<header>
	 <nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-white" style="overflow: scroll"; >
      <div  class="position-sticky" style="font-size: 15px;"> 
	    
        <c:if test="${dados.administrador }">
        <div class="list-group list-group-flush mx-3 mt-4">
          <div> <strong>Area Administrativa</strong></div>
          <a href="<%=request.getContextPath()%>/novousuario" class="list-group-item list-group-item-action py-2 ripple"> Cadastra Usuario 	
          <img class="icon" width="30" height="30" src="https://img.icons8.com/ios/50/null/signing-a-document.png"/>
          </a>
		  <a href="<%=request.getContextPath()%>/novolivro" class="list-group-item list-group-item-action py-2 ripple"> Cadastrar  Livros 
            <img  width="30" height="30" src="https://img.icons8.com/ios/50/null/pdf--v1.png"/> 	
	     </a>
          <a href="<%=request.getContextPath()%>/lista/usuarios " class="list-group-item list-group-item-action py-2 ripple"> Lista Usuarios 
            <img width="30" height="30" src="https://img.icons8.com/ios/50/null/user-manual.png"/>
          </a>
          <a href="<%=request.getContextPath()%>/relatorio"  class="list-group-item list-group-item-action py-2 ripple"> Relatorio 
             <img width="30" height="30" src="https://img.icons8.com/ios/50/null/edit-graph-report.png"/>
          </a>
        </div>
        
        </c:if>
        
        <div class="list-group list-group-flush mx-3 mt-4">
          <div> <strong>Area Do Usuario</strong></div>
		  <a href="<%=request.getContextPath()%>/adicionameuslivros" class="list-group-item list-group-item-action py-2 ripple">Adcionar  Livros 
		     <img  width="30" height="30" src="https://img.icons8.com/ios/50/null/pdf--v1.png"/> 	
		   </a>
          
          <a href="#" class="list-group-item list-group-item-action py-2 ripple"> Minha Biblioteca 
              <img  width="30" height="30" src="https://img.icons8.com/ios/50/null/book-shelf.png"/>
          </a>
        </div>
        
         
      </div>
    </nav>

	<nav id="main-navbar"
		class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
		<!-- Container wrapper -->
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
				aria-controls="sidebarMenu" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>

			<div class="navbar-brand" > <img
				src="https://mdbootstrap.com/img/logo/mdb-transaprent-noshadows.png"
				height="25" alt="" loading="lazy" />
			</div>
			<p> Bem Vindo : ${dados.nome }</p>
			<ul class="navbar-nav ms-auto d-flex flex-row">
				<li class="nav-item dropdown">
				  <a class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"href="#" id="navbarDropdownMenuLink" role="button"data-mdb-toggle="dropdown" aria-expanded="false">
				     <c:if test="${dados.foto == null }">
				         <img src="https://mdbootstrap.com/img/Photos/Avatars/img (31).jpg"	class="rounded-circle" height="30" width="32" alt="" loading="lazy" />
				     </c:if>
				     
				     <c:if test="${dados.foto != null }">
				         <img src="${dados.foto }"	class="rounded-circle" height="30" width="32"  alt="" loading="lazy" />
				     </c:if>
				  </a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdownMenuLink">
						<li><a class="dropdown-item" href="<%=request.getContextPath()%>/editarmeusdados?loginUser=${dados.login}">Meus Dados</a></li>
                         <li><a  id="link-init" class="dropdown-item" href="<%=request.getContextPath()%>/voltarinicio">inicio</a></li>
						<li><a class="dropdown-item" href="<%=request.getContextPath()%>/logout">Encerra Sessao</a></li>
					</ul>
			    </li>
			</ul>
		</div>

		<!-- Container wrapper -->
	</nav>
	<!-- Navbar -->
</header>