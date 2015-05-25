<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="z-index:5">
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
								placeholder="Usuário" id="txtLogin" name="txtLogin"> <input
								style="margin-bottom: 15px;" type="password" placeholder="Senha"
								id="txtPassword" name="txtPassword">
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
								<li><a href="category?op=listar">Promoção</a></li>
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
	<!-- /.container --> </nav>
	<p>
		<br />
	</p>
	<p>
		<br />
	</p>


	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<!-- <div class="col-md-3">
				<p class="lead">Categorias</p>
				<div class="list-group">
					<a href="#" class="list-group-item"> Viagem </a> <a href="#"
						class="list-group-item"> Infantil </a> <a href="#"
						class="list-group-item"> Teen </a> <a href="#"
						class="list-group-item"> Metodologia de Pesquisa </a> <a href="#"
						class="list-group-item"> Sustentabilidade </a> <a href="#"
						class="list-group-item"> Videogames </a> <a href="#"
						class="list-group-item"> Autoajuda </a> <a href="#"
						class="list-group-item"> Biografias </a> <a href="#"
						class="list-group-item"> Administração </a> <a href="#"
						class="list-group-item"> Ciências Biológicas </a> <a href="#"
						class="list-group-item"> Ciências Exatas </a> <a href="#"
						class="list-group-item"> Ciências Sociais </a> <a href="#"
						class="list-group-item"> Comportamento </a> <a href="#"
						class="list-group-item"> Comunicação </a> <a href="#"
						class="list-group-item"> Dicionários </a> <a href="#"
						class="list-group-item"> Didáticos </a> <a href="#"
						class="list-group-item"> Direito </a> <a href="#"
						class="list-group-item"> Economia </a> <a href="#"
						class="list-group-item"> Engenharia </a> <a href="#"
						class="list-group-item"> Educação </a> <a href="#"
						class="list-group-item"> Concursos Públicos </a> <a href="#"
						class="list-group-item"> Ensino de Línguas </a> <a href="#"
						class="list-group-item"> Esoterismo </a> <a href="#"
						class="list-group-item"> Esportes e Lazer </a> <a href="#"
						class="list-group-item"> Filosofia </a> <a href="#"
						class="list-group-item"> Geografia </a> <a href="#"
						class="list-group-item"> História </a> <a href="#"
						class="list-group-item"> Gastronomia </a> <a href="#"
						class="list-group-item"> HQs </a> <a href="#"
						class="list-group-item"> Humor e Entretenimento </a> <a href="#"
						class="list-group-item"> Informática e Tecnologia </a> <a href="#"
						class="list-group-item"> LGBT </a> <a href="#"
						class="list-group-item"> Literatura Internacional </a> <a href="#"
						class="list-group-item"> Literatura Nacional </a> <a href="#"
						class="list-group-item"> Medicina </a> <a href="#"
						class="list-group-item"> Pets </a> <a href="#"
						class="list-group-item"> Arquitetura </a> <a href="#"
						class="list-group-item"> Psicologia </a> <a href="#"
						class="list-group-item"> Religião </a> <a href="#"
						class="list-group-item"> Saúde, Fitness e Beleza </a>
				</div>
			</div> -->

			<div class="col-md-9">

				<div class="thumbnail">
					<!-- <img class="img-responsive" src="http://placehold.it/800x300"
						alt="">  -->
					<div style="margin-left: 35%; width: 260px; height: 365px;">
						<img src="img/capa/${book.imageDirectory }" alt="">
					</div>
					<div class="caption-full">
						<h4 class="pull-right">R$${book.price}</h4>
						<h4>
							<a href="#">${book.title}</a>
						</h4>
						<!-- <p>
							See more snippets like these online store reviews at <a
								target="_blank" href="http://bootsnipp.com">Bootsnipp -
								http://bootsnipp.com</a>.
						</p>
						<p>
							Want to make these reviews work? Check out <strong><a
								href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this
									building a review system tutorial</a> </strong>over at maxoffsky.com!
						</p> -->
						<p>${book.description}</p>


					</div>
					<div class="ratings">

						<div class="text-right">
							<form method="post"
								action="shoppingcart?op=adicionar&id=${book.id}">
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1">Quantidade</span>
									<input type="number" class="form-control" placeholder="0"
										aria-describedby="basic-addon1" id="txtQuantidade"
										name="txtQuantidade" style="width: 150px;">
								</div>
								<input type="submit" value="Adicionar ao Carrinho"
									class="btn btn-success" /> <a href="wishlist?op=cadastrar&id=${book.id}"
									class="btn btn-primary"> Adicionar a lista Desejo </a>
							</form>

							<br /> <br /> <br />
						</div>
						<!-- <p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span> 4.0 stars
						</p> -->

						<c:choose>
							<c:when test="${msg == 1}">
								<div class="alert alert-success" role="alert">
									Item(s) adicionado(s) no Carrinho.
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:when>
							<c:when test="${msg == 3}">
								<div class="alert alert-success" role="alert">
									Item(s) adicionado(s) no W.
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:when>
							<c:when test="${msg == 2}">
								<div class="alert alert-warning" role="alert">
									Informar a quantidade.
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:when>
							<c:when test="${msg == 4}">
								<div class="alert alert-warning" role="alert">
									Necessário estar logado para realizar está ação.
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:when>
						</c:choose>

					</div>
				</div>

				<div class="well">

					<div class="text-right">
						<a class="btn btn-success">Adicionar comentario</a>
					</div>

					<hr>

					<div class="row">
						<div class="col-md-12">
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span> Anonymous <span
								class="pull-right">10 days ago</span>
							<p>This product was great in terms of quality. I would
								definitely buy another!</p>
						</div>
					</div>

					<hr>

					<div class="row">
						<div class="col-md-12">
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span> Anonymous <span
								class="pull-right">12 days ago</span>
							<p>I've alredy ordered another one!</p>
						</div>
					</div>

					<hr>

					<div class="row">
						<div class="col-md-12">
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span> Anonymous <span
								class="pull-right">15 days ago</span>
							<p>I've seen some better than this, but not at this price. I
								definitely recommend this item.</p>
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>
	<!-- /.container -->

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
