<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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

		<form method="post" action="customer">
			<br />

			<c:choose>
				<c:when test="${cadastroRealizado == 1}">
					<div class="alert alert-success" role="alert">
						Cadastro concluído.
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:when>
				<c:when test="${erro == 2}">
					<div class="alert alert-warning" role="alert">
						Existe(m) campo(s) não preenchidos, favor verificar novamente.
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:when>
				<c:when test="${erro == 3}">
					<div class="alert alert-danger" role="alert">
						Mensagem de Erro
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:when>
			</c:choose>

			<br /> <br />

			<!-- ` customer`.`LOGIN`, -->
			<div class="form-group">
				<label for="txtLogin">Login</label> <input type="text"
					class="form-control" id="txtLogin" name="txtLogin" placeholder="Login">
			</div>

			<!-- ` customer`.`PASSWORD`, -->
			<div class="form-group">
				<label for="txtPassword">Password</label> <input type="password"
					class="form-control" id="txtPassword" name="txtPassword" placeholder="Password">
			</div>

			<!-- ` customer`.`NAME`, -->
			<div class="form-group">
				<label for="txtName">Nome</label> <input type="text"
					class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
			</div>

			<!-- ` customer`.`EMAIL`, -->
			<div class="form-group">
				<label for="txtEmail">E-mail</label> <input type="text"
					class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
			</div>


			<!-- ` customer`.`GENDER`, -->
			<div class="form-group">
				<label for="txtNome">Sexo</label> <label class="radio-inline">
					<input type="radio" id="rdSexo" name="rdSexo">Masculino
				</label> <label class="radio-inline"> <input type="radio"
					name="rdSexo" id="rdSexo">Feminino
				</label>
			</div>

			<!-- ` customer`.`PHONE`, -->
			<div class="form-group">
				<label for="txtTelefone">Telefone</label> <input type="text"
					class="form-control" id="txtTelefone" name="txtTelefone" placeholder="Telefone">
			</div>

			<!-- ` customer`.`ADDRESS` -->
			<div class="form-group">
				<label for="txtEndereco">Endereço</label> <input type="text"
					class="form-control" id="txtEndereco" name="txtEndereco"  placeholder="Endereço">
			</div>

			<input class="btn btn-success" type="submit" id="sign-in" value="Cadastrar">
		</form>

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