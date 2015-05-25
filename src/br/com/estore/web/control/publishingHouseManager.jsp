<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Editora Crud</title>
<link href="css/bootstrap.min.css" rel="stylesheet">


</head>
<body>

	<div class="container">

		<div role="tabpanel">


			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">

				<li role="presentation"
						<c:if test="${empty TabAddEdit}">						 
									class="active"
						</c:if>						
				><a href="#Lista" aria-controls="home"
					role="tab" data-toggle="tab">Lista</a></li>

				<li role="presentation"
				<c:if test="${!empty TabAddEdit}">						 
									class="active"
						</c:if>
				
				><a href="#Adicionar"
					aria-controls="profile" role="tab" data-toggle="tab">Adicionar/Editar</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" id="Lista"
						<c:if test="${empty TabAddEdit}">						 
									class="tab-pane active"
						</c:if>
						<c:if test="${!empty TabAddEdit}">						 
									class="tab-pane"
						</c:if>
				
				>

					<br />
					<p>
						<a href="PublishingHouse?op=cadastra" class="btn btn-primary"
							role="button"><span class="glyphicon glyphicon-plus"></span>
							Adicionar</a>
					</p>
					<br />


					<div class="table - responsive">
						<!-- Default panel contents -->
						<div class="panel-heading">Editora</div>


						<c:choose>
							<c:when test="${!empty MensagemPublishingHouse}">
								<br />
								<div class="alert alert-success" role="alert">
									${MensagemPublishingHouse}
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>

							</c:when>
							<c:when test="${!empty MensagemErro}">
								<br />
								<div class="alert alert-danger" role="alert">
									${MensagemErro}
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>

							</c:when>
						</c:choose>


						<!-- Table -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Código Editora</th>
									<th>Nome</th>
									<th>Razão Social</th>
									<th>E-mail</th>
									<th>CNPJ</th>
									<th>IE</th>
									<th>Site</th>
									<th>Telefone</th>
									<th>Endereço</th>
									<th>Sede</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty PublishingHouses}">
										<c:forEach items="${PublishingHouses}" var="PublishingHouse">
											<tr>
												<td>${PublishingHouse.id}</td>
												<td>${PublishingHouse.name}</td>
												<td>${PublishingHouse.companyName}</td>
												<td>${PublishingHouse.email}</td>
												<td>${PublishingHouse.cnpj}</td>
												<td>${PublishingHouse.ie}</td>
												<td>${PublishingHouse.site}</td>
												<td>${PublishingHouse.phone}</td>
												<td>${PublishingHouse.address}</td>
												<td>${PublishingHouse.head}</td>										
												<td style="white-space: nowrap;"><a
													href="PublishingHouse?op=editar&id=${PublishingHouse.id}"> <span
														class="glyphicon glyphicon-edit"></span> Editar
												</a></td>
												<td style="white-space: nowrap;"><a
													href="PublishingHouse?op=deletar&id=${PublishingHouse.id}"> <span
														class="glyphicon glyphicon-trash"></span> Excluir
												</a></td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="11">
												<div class="alert alert-info" role="alert">
													<b>Nenhuma</b> Editora cadastrado.
												</div>
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
					<br />			
				</div>


				<div role="tabpanel"  id="Adicionar"
						<c:if test="${!empty TabAddEdit}">						 
									class="tab-pane active"
						</c:if>
						<c:if test="${empty TabAddEdit}">						 
									class="tab-pane"
						</c:if>
						>
					<form method="post" action="PublishingHouse?op=confirmar">
						<br /> <br /> <br />
						<div class="form-group">
							<label>Código Editora</label> <input type="text"
								class="form-control" id="txtIdEditora" name="txtIdEditora"
								placeholder="Código Editora" readonly="readonly"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = ${PublishingHouse.id}
							    </c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>

						<div class="form-group">
							<label>Nome</label> <input type="text" class="form-control"
								id="txtNome" name="txtNome"
								placeholder="Nome"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.name}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<div class="form-group">
							<label>Razão Social</label> <input type="text" class="form-control"
								id="txtRazaoSocial" name="txtRazaoSocial"
								placeholder="Razão Social"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.companyName}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<div class="form-group">
							<label>E-mail</label> <input type="text" class="form-control"
								id="txtEmail" name="txtEmail"
								placeholder="E-mail"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.email}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<div class="form-group">
							<label>CNPJ</label> <input type="text" class="form-control"
								id="txtCNPJ" name="txtCNPJ"
								placeholder="CNPJ"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.cnpj}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<div class="form-group">
							<label>IE</label> <input type="text" class="form-control"
								id="txtIE" name="txtIE"
								placeholder="IE"
								<c:if test="${!empty PublishingHouse}">						 
						 				 value="${PublishingHouse.ie}"   
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<div class="form-group">
							<label>Site</label> <input type="text" class="form-control"
								id="txtSite" name="txtSite"
								placeholder="Site"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.site}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						
						<div class="form-group">
							<label>Telefone</label> <input type="text" class="form-control"
								id="txtTelefone" name="txtTelefone"
								placeholder="Telefone"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.phone}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
				
						<div class="form-group">
							<label>Endereço</label> <input type="text" class="form-control"
								id="txtEndereco" name="txtEndereco"
								placeholder="Endereço"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.address}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<div class="form-group">
							<label>Sede</label> <input type="text" class="form-control"
								id="txtSede" name="txtSede"
								placeholder="Sede"
								<c:if test="${!empty PublishingHouse}">						 
						 					value = "${PublishingHouse.head}"
								</c:if>
								<c:if test="${empty PublishingHouse}">						 
						 					value = ""
							    </c:if>>
						</div>
						
						<input class="btn btn-success" type="submit" id="sign-in"
							value="confirmar">
					</form>
				</div>
			</div>
		</div>

	</div>


	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>eStore &copy; Your Website 2014</p>
			</div>
		</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>