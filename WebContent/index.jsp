<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>eStore</title>

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
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-book"></span> Livros</a></li>
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
						<br />
						<a href="customerregistration.jsp">Cadastrar-me</a> <br /> <br />
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
								<li><a href="Crud.html">Promoção</a></li>
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

	<!-- Page Content 
	<!--
	<c:choose>
					<c:when test="${!empty user.name}">
						<p class="lead">Bem vindo, ${user.name}</p>
					</c:when>
					<c:when test="${!empty error}">
						<p class="lead">${error}</p>
					</c:when>
					<c:otherwise>
						<p class="lead">Bem vindo, Visitante</p>
					</c:otherwise>
				</c:choose> 
	-->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
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
			</div>

			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" src="img/banner/banner-desconto-1.jpg"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="img/banner/banner-desconto-2.jpg"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="img/banner/banner-desconto-3.jpg"
										alt="">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>

				<div class="row">
					<c:choose>
						<c:when test="${!empty books}">
							<c:forEach items="${books}" var="book">
								<div class="col-sm-4 col-lg-4 col-md-4">
									<div class="thumbnail">
										<img src="img/capa/${ book.imageDirectory }"
											alt="${ book.title } }">
										<div class="caption">
											<h4 class="pull-right">R$${ book.price }</h4>
											<h4>
												<a href="item?id=${book.id}">${ book.title }</a>
											</h4>
											<p>
												See more snippets like this online store item at <a
													target="_blank" href="http://www.bootsnipp.com">Bootsnipp
													- http://bootsnipp.com</a>.
											</p>
										</div>
										<div class="ratings">
											<p class="pull-right">15 reviews</p>
											<p>
												<span class="glyphicon glyphicon-star"></span> <span
													class="glyphicon glyphicon-star"></span> <span
													class="glyphicon glyphicon-star"></span> <span
													class="glyphicon glyphicon-star"></span> <span
													class="glyphicon glyphicon-star"></span>
											</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="jumbotron">
								<h1>Livros não disponíveis.</h1>
								<p>Desculpe-nos o transtorno.</p>
								<p>
									<a class="btn btn-primary btn-lg" href="#" role="button">Faça
										um reclamação</a>
								</p>
							</div>
						</c:otherwise>
					</c:choose>



					<!-- <div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="img/capa/the_book_of_trees.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$24.99</h4>
								<h4>
									<a href="item.html">First Product</a>
								</h4>
								<p>
									See more snippets like this online store item at <a
										target="_blank" href="http://www.bootsnipp.com">Bootsnipp
										- http://bootsnipp.com</a>.
								</p>
							</div>
							<div class="ratings">
								<p class="pull-right">15 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="img/capa/danca_dos_dragoes.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$64.99</h4>
								<h4>
									<a href="item.html">Second Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">12 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="img/capa/harry_potter_1.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$74.99</h4>
								<h4>
									<a href="item.html">Third Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">31 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="img/capa/the_lord_of_the_rings.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$84.99</h4>
								<h4>
									<a href="item.html">Fourth Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">6 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="img/capa/mvc_book.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$94.99</h4>
								<h4>
									<a href="item.html">Fifth Product</a>
								</h4>
								<p>This is a short description. Lorem ipsum dolor sit amet,
									consectetur adipiscing elit.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">18 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div> -->

					<!-- <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4><a href="#">Like this template?</a>
                        </h4>
                        <p>If you like this template, then check out <a target="_blank" href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this tutorial</a> on how to build a working review system for your online store!</p>
                        <a class="btn btn-primary" target="_blank" href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">View Tutorial</a>
                    </div> -->

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