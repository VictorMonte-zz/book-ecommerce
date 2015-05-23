<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Crud Livros</title>
<link href="css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="z-index: 5">
		<div class="container" style="z-index: 5">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">eStore</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Livros</a></li>
					<li><a href="#">Sobre</a></li>
					<li><a href="#">Contato</a></li>
				</ul>
				<ul class="nav navbar-nav" style="z-index: 5">
					<li class="divider-vertical" style="z-index: 5"></li>
					<li class="dropdown" style="z-index: 5"><a
						class="dropdown-toggle" href="#" data-toggle="dropdown">Login<strong
							class="caret"></strong></a>
						<div class="dropdown-menu"
							style="padding: 20px; padding-bottom: 0px; z-index: 5">
							<br />
							<form method="post" action="login" accept-charset="UTF-8"
								role="search">

								<input style="margin-bottom: 15px;" type="text"
									placeholder="Usuário" id="txtLogin" name="txtLogin"> <input
									style="margin-bottom: 15px;" type="password"
									placeholder="Senha" id="txtPassword" name="txtPassword">
								<input style="float: left; margin-right: 10px;" type="checkbox"
									name="remember-me" id="remember-me" value="1"> <label
									class="string optional" for="user_remember_me">
									Remember me</label> <input class="btn btn-primary" type="submit"
									id="sign-in" value="Entra"> <input
									class="btn btn-primary" type="submit" id="sign-in"
									value="Cadastra">

							</form>
							<br /> <br />
						</div></li>
				</ul>
				<ul class="nav navbar-nav" style="z-index: 5">
					<li role="presentation" class="dropdown" style="z-index: 5"><a
						class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Cadastro <span
							class="caret" style="z-index: 5"></span>
					</a>
						<ul class="dropdown-menu" role="menu" style="z-index: 5">
							<li><a href="Crud.html">Livros</a></li>
							<li><a href="Crud.html">Autores</a></li>
							<li><a href="Crud.html">Categoria</a></li>
							<li class="divider"></li>
							<li><a href="Crud.html">Promoção</a></li>
						</ul></li>
					<li><a href="Carinho.html"><span
							class="glyphicon glyphicon-shopping-cart"></span> Carinho</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<p>
		<br />
	</p>
	<p>
		<br />
	</p>

	<div class="container">




		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#Lista"
					aria-controls="home" role="tab" data-toggle="tab">Lista</a></li>
				<li role="presentation"><a href="#Adicionar"
					aria-controls="profile" role="tab" data-toggle="tab">Adicionar</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="Lista">
					<br />
					<!-- <p>
						<button type="button" class="btn btn-primary">
							<span class="glyphicon glyphicon-plus"></span> Adicionar
						</button>
					</p> -->
					<br />
					<div class="table - responsive">
						<!-- Default panel contents -->
						<div class="panel-heading">Livros</div>

						<!-- Table -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>Título</th>
									<th>Preço</th>
									<th>Págs.</th>
									<th>Descrição</th>
									<th>Arquivo</th>
									<th>Autor</th>
									<th>Editora</th>
									<th>Categoria</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<!-- <tr>
									<td>98745</td>
									<td>Naruto</td>
									<td>Desenho de Viado</td>
									<td>10,00</td>
									<td>10/10/2015</td>
									<td><a href=""><span class="glyphicon glyphicon-edit"></span>
											Editar <a href=""><span class="glyphicon glyphicon-trash"></span>
												Excluir </td>
								</tr> -->
								<c:choose>
									<c:when test="${!empty books}">

										<c:forEach items="${books}" var="book">
											<tr>
												<td>${book.id}</td>
												<td width="15%">${book.title}</td>
												<td>R$${book.price}</td>
												<td>${book.numerPages}</td>
												<td>${book.description}</td>
												<td>${book.imageDirectory}</td>
												<td>${book.authorId}</td>
												<td>${book.publishingHouseId}</td>
												<td>${book.categoryId}</td>
												<td><a href=""> <span
														class="glyphicon glyphicon-edit"></span> Editar <a href=""><span
															class="glyphicon glyphicon-trash"></span> Excluir</a></td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="11">
												<div class="alert alert-info" role="alert">
													<b>Nenhum</b> livro cadastrado.
												</div>
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
					<br />
					<!-- <ul class="pagination">
						<li class="disabled"><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul> -->

				</div>


				<div role="tabpanel" class="tab-pane" id="Adicionar">
					<form>
						<br />
						<div class="alert alert-success" role="alert">
							Mensagem de item cadastrado ou editado
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="alert alert-warning" role="alert">
							Mensagem de Alerta tipo campo não preeanchido
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="alert alert-danger" role="alert">
							Mensagem de Erro
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<br /> <br />
						<div class="form-group">
							<label for="exampleInputEmail1">Nome</label> <input type="text"
								class="form-control" id="txtNome" placeholder="Nome">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Descrição</label> <input
								type="textarea" class="form-control" id="txtNome"
								placeholder="Descrição">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Valor</label> <input type="text"
								class="form-control" id="txtNome" placeholder="valor">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Data</label> <input type="text"
								class="form-control" id="txtNome" placeholder="Data">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Nome</label> <input type="text"
								class="form-control" id="txtNome" placeholder="Nome">
						</div>

						<button type="button" class="btn btn-primary">Voltar</button>
						<button type="button" class="btn btn-success">Cadastrada</button>
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
					<p>Copyright &copy; Your Website 2014</p>
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
