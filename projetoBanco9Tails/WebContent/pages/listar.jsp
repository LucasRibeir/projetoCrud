<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/boo tstrap.min.css"
	integrity="sha384ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T
"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.9.0/css/all.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo "
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Sistema Nine</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.9.0/css/all.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

</head>
<title>Listar</title>
</head>
<body>
	<h1 class="bg-dark p-3 text-center text-white">Listar Clientes</h1>





	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="caminho" value="${pageContext.request.contextPath}" />








	<div id="resposta">
		<c:forEach items="${msg}" var="linha">
			<form>
				<table>
					<tr>
						<th>${linha.nome}
						<th />
					<tr />

					<br>
					<th>${linha.email}</br>
					<tr>

						<th>${linha.telefone}
					<tr />
					<th>${linha.endereco.logradouro}
					<th>${linha.endereco.estado}
					<th>${linha.endereco.cidade}
					<th>${linha.endereco.bairro}
				</table>
			</form>
		</c:forEach>
	</div>


	<br />
	<a href="${caminho}/">Pagina Principal</a>
	<br>

</body>
</html>