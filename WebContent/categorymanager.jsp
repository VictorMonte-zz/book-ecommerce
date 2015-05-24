<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Crud Categoria</title>
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
						<a href="category?op=cadastra" class="btn btn-primary"
							role="button"><span class="glyphicon glyphicon-plus"></span>
							Adicionar</a>
					</p>
					<br />


					<div class="table - responsive">
						<!-- Default panel contents -->
						<div class="panel-heading">Categoria</div>


						<c:choose>
							<c:when test="${!empty Mensagem}">
								<br />
								<div class="alert alert-success" role="alert">
									${Mensagem}
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
									<th>Código Categoria</th>
									<th>Descrição</th>
									<th>Ação</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty categorys}">
										<c:forEach items="${categorys}" var="category">
											<tr>
												<td>${category.id}</td>
												<td>${category.description}</td>
												<td style="white-space: nowrap;"><a
													href="category?op=editar&id=${category.id}"> <span
														class="glyphicon glyphicon-edit"></span> Editar
												</a></td>
												<td style="white-space: nowrap;"><a
													href="category?op=deletar&id=${category.id}"> <span
														class="glyphicon glyphicon-trash"></span> Excluir
												</a></td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="11">
												<div class="alert alert-info" role="alert">
													<b>Nenhuma</b> Categoria cadastrado.
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
					<form method="post" action="category?op=confirmar">
						<br /> <br /> <br />
						<div class="form-group">
							<label>Código Categoria</label> <input type="text"
								class="form-control" id="txtIdCategory" name="txtIdCategory"
								placeholder="Código Categoria" readonly="readonly"
								<c:if test="${!empty category}">						 
						 					value = ${category.id}
							    </c:if>
								<c:if test="${empty category}">						 
						 					value = ""
							    </c:if>>
						</div>

						<div class="form-group">
							<label>Descriação</label> <input type="text" class="form-control"
								id="txtDescription" name="txtDescription"
								placeholder="Descrição"
								<c:if test="${!empty category}">						 
						 					value = "${category.description}"
								</c:if>
								<c:if test="${empty category}">						 
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