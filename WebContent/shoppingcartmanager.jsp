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
									placeholder="Usu�rio" id="txtLogin" name="txtLogin"> <input
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
							<li><a href="Crud.html">Promo��o</a></li>
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

		<div>
			<h1>Meu Carrinho de Compras</h1>
		</div>
		<br /> <br />


		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#carinho"
					aria-controls="home" role="tab" data-toggle="tab">Carinho</a></li>
				<li role="presentation"><a href="#ListaDesejo"
					aria-controls="profile" role="tab" data-toggle="tab">Lista de
						Desejo</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="carinho">

					<div class="table - responsive">

						<!-- Table -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Item</th>
									<th>Descri��o</th>
									<th>Quantidade</th>
									<th>Valor Unit�riorio</th>
									<th>Valor Total</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty shoppingCart}">

										<c:forEach items="${shoppingCart}" var="book">
											<tr>
												<td><img src="img/capa/${ book.imageDirectory }" alt=""
													height="80" width="80"></td>
												<td>${ book.description }</td>
												<td><input type="text" class="form-control"
													id="txtQuantidade" placeholder="Nome"
													value="${ book.quantity }"></td>
												<td>R$${ book.singleValue }</td>
												<td>R$${ book.total }</td>
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
								<c:choose>
									<c:when test="${!empty totalCompra }">
										<tr>
											<td class="text-right" colspan="4">Total</td>
											<td>R$${ totalCompra }</td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr>
											<td class="text-right" colspan="4">Total</td>
											<td>R$0.0</td>
										</tr>
									</c:otherwise>
								</c:choose>

							</tbody>
						</table>
					</div>
				</div>


				<div role="tabpanel" class="tab-pane" id="ListaDesejo">

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
								<c:when test="${!empty wishBooks}">

									<c:forEach items="${wishBooks}" var="wish">
										<tr>
											<td><img src="img/capa/${wish.imageDirectory}" alt=""
												height="80" width="80"></td>
											<td>${wish.description}</td>
											<td>R$${wish.price}</td>
											<td><span class="glyphicon glyphicon-shopping-cart"></span>
												<a href="wishlist?op=adicionar&id=${wish.id}"
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
		<div class="text-right">
			<p>
				<!-- <button type="button" class="btn btn-primary">
					<span class="glyphicon glyphicon-plus"></span> Continuar Comprando
				</button> -->				
				
				<a href="checkout" class="btn btn-success">Finalizar Compra</a>
				
			</p>
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
