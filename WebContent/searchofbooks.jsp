<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Carrinho de Compras</title>
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
					<li><a href="search?op=carregar"><span
							class="glyphicon glyphicon-book"></span> Buscar Livros</a></li>
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
									placeholder="Usu�rio" id="txtLogin" name="txtLogin"> <input
									style="margin-bottom: 15px;" type="password"
									placeholder="Senha" id="txtPassword" name="txtPassword">
								<!-- <input
								style="float: left; margin-right: 10px;" type="checkbox"
								name="remember-me" id="remember-me" value="1"> -->
								<!-- <label
								class="string optional" for="user_remember_me">
								Lembre-me</label> -->
								<input class="btn btn-primary" type="submit" id="sign-in"
									value="Entra">
							</form>
							<br /> <a href="customerregistration.jsp">Cadastrar-me</a> <br />
							<br />
						</div></li>
				</ul>
				<c:choose>
					<c:when test="${user.is_admin == 1}">
						<!-- Allow to register -->
						<ul class="nav navbar-nav" style="z-index: 5">
							<li role="presentation" class="dropdown" style="z-index: 5"><a
								class="dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-expanded="false"> Cadastro <span
									class="caret" style="z-index: 5"></span>
							</a>
								<ul class="dropdown-menu" role="menu" style="z-index: 5">
									<li><a href="book?op=listar">Livros</a></li>
									<li><a href="Crud.html">Autores</a></li>
									<li><a href="Crud.html">Categoria</a></li>
									<li class="divider"></li>
									<li><a href="category?op=listar">Promo��o</a></li>
								</ul></li>
							<li><a href="shoppingcart?op=listar"><span
									class="glyphicon glyphicon-shopping-cart"></span> Carinho</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="nav navbar-nav" style="z-index: 5">
							<li><a href="shoppingcart?op=listar"><span
									class="glyphicon glyphicon-shopping-cart"></span> Carinho</a></li>
						</ul>
					</c:otherwise>
				</c:choose>


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

		<div>
			<h1>Busca</h1>
		</div>
		<br /> <br />


		<div role="tabpanel">

			<!-- Nav tabs -->
			<c:choose>
				<c:when test="${searchType == 1 }">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#carinho"
							aria-controls="home" role="tab" data-toggle="tab">Busca
								Simples</a></li>
						<li role="presentation"><a href="#ListaDesejo"
							aria-controls="profile" role="tab" data-toggle="tab">Busca
								Avan�ada</a></li>
					</ul>
				</c:when>
				<c:when test="${searchType == 2 }">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation"><a href="#carinho"
							aria-controls="home" role="tab" data-toggle="tab">Busca
								Simples</a></li>
						<li role="presentation" class="active"><a href="#ListaDesejo"
							aria-controls="profile" role="tab" data-toggle="tab">Busca
								Avan�ada</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav nav-tabs" role="tablist">

						<li role="presentation" class="active"><a href="#carinho"
							aria-controls="home" role="tab" data-toggle="tab">Busca
								Simples</a></li>
						<li role="presentation"><a href="#ListaDesejo"
							aria-controls="profile" role="tab" data-toggle="tab">Busca
								Avan�ada</a></li>
					</ul>
				</c:otherwise>
			</c:choose>

			<!-- Tab panes -->
			<div class="tab-content">


				<div role="tabpanel" class="tab-pane active" id="carinho">

					<div class="table - responsive">

						<!-- Busca Simples -->
						<form class="navbar-form navbar-left" role="search" method="post"
							action="search?op=buscaSimples">
							<div class="form-group">
								<input id="txtNomeSimples" name="txtNomeSimples" type="text"
									class="form-control" placeholder="Qual livro voc� procura?">
							</div>
							<input type="submit" class="btn btn-default" value="Buscar" />
						</form>

						<!-- Table -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Item</th>
									<th>Descri��o</th>
									<th>Valor</th>
								</tr>
							</thead>
							<tbody>

								<c:choose>
									<c:when test="${!empty booksSimple}">

										<c:forEach items="${booksSimple}" var="book">
											<tr>
												<td><img src="img/capa/${book.imageDirectory}" alt=""
													height="80" width="80"></td>
												<td>${book.description}</td>
												<td>R$${book.price}</td>
												<td><span class="glyphicon glyphicon-shopping-cart"></span>
													<a href="wishlist?op=adicionar&id=${book.id}"
													class="btnbtn-primary">Adicionar ao Carinho</a></td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${erro == 1}">
										<tr>
											<td colspan="11">
												<div class="alert alert-info" role="alert">
													<b>Nenhum</b> livro cadastrado.
												</div>
											</td>
										</tr>
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
				</div>

				<div role="tabpanel" class="tab-pane" id="ListaDesejo">

					<!-- Busca Avan�ada -->
					<form class="navbar-form navbar-left" role="search" method="post"
						action="search?op=buscaAvancada">
						<div class="form-group">
							<input id="txtNomeAvancada" name="txtNomeAvancada" type="text"
								class="form-control" placeholder="Qual livro voc� procura?">
						</div>

						<div class="btn-group">
							<c:choose>
								<c:when test="${!empty publishingHouses}">
									&nbsp;
									<select id="ddlEditora" name="ddlEditora"
										style="width: 100px; height: 34px;">
										<option value="0">Editora</option>
										<c:forEach items="${publishingHouses}" var="publishingHouse">
											<option value="${publishingHouse.id}">${publishingHouse.name}</option>
										</c:forEach>
									</select>
									&nbsp;
								</c:when>
								<c:otherwise>
									<!-- Nenhum item adicionado -->
								</c:otherwise>
							</c:choose>
						</div>

						<div class="btn-group">
							<c:choose>
								<c:when test="${!empty authors}">
										&nbsp;
										<select id="ddlAutor" name="ddlAutor"
										style="width: 100px; height: 34px;">
										<option value="0">Autor(a)</option>
										<c:forEach items="${authors}" var="author">
											<option value="${author.id}">${author.name}</option>
										</c:forEach>
									</select>
										&nbsp;
									</c:when>
								<c:otherwise>
									<!-- Nenhum item adicionado -->
								</c:otherwise>
							</c:choose>
						</div>

						<div class="btn-group">
							<c:choose>
								<c:when test="${!empty categories}">
										&nbsp;
										<select id="ddlCategoria" name="ddlCategoria"
										style="width: 100px; height: 34px;">
										<option value="0">Categoria</option>
										<c:forEach items="${categories}" var="category">
											<option value="${category.id}">${category.description}</option>
										</c:forEach>
									</select>
										&nbsp;
									</c:when>
								<c:otherwise>
									<!-- Nenhum item adicionado -->
								</c:otherwise>
							</c:choose>
						</div>

						<input type="submit" class="btn btn-default" value="Buscar" />
					</form>

					<!-- Table -->
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Item</th>
								<th>Descri��o</th>
								<th>Valor</th>
							</tr>
						</thead>
						<tbody>

							<c:choose>
								<c:when test="${!empty booksAvancada}">

									<c:forEach items="${booksAvancada}" var="book">
										<tr>
											<td><img src="img/capa/${book.imageDirectory}" alt=""
												height="80" width="80"></td>
											<td>${book.description}</td>
											<td>R$${book.price}</td>
											<td><span class="glyphicon glyphicon-shopping-cart"></span>
												<a href="wishlist?op=adicionar&id=${book.id}"
												class="btnbtn-primary">Adicionar ao Carinho</a></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:when test="${erro == 1}">
									<tr>
										<td colspan="11">
											<div class="alert alert-info" role="alert">
												<b>Nenhum</b> livro cadastrado.
											</div>
										</td>
									</tr>
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





			</div>
		</div>
		<!-- <div class="text-right">
			<p>
				<a href="checkout" class="btn btn-success">Finalizar Compra</a>
			</p>
		</div> -->

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
