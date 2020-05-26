<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF8"> <title>Sistema Nine</title> 
 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/boo tstrap.min.css" integrity="sha384ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T
" crossorigin="anonymous"> <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.9.0/css/all.css"> 
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo " 
crossorigin="anonymous"></script> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF8"> <title>Sistema Nine</title> 
 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous"> <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.9.0/css/all.css"> 
 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
crossorigin="anonymous"></script> 

</head>
<title>Sistema NineTails</title>

<body>

<h1 class="bg-dark p-3 text-center text-white">Cadastro de Clientes </h1>
<h2><center> NineTails</center></h2>
<hr/>
<form method="post" action="gravar.html">
<center>
<br/ >Nome<br/>
<input type="text" name="Nome" id="nome" size="50"/>
<br/>Email<br/>
<input type="email" name="Email" id="email" size="50"/>
<br/>Telefone<br/>
<input type="tel" name="Telefone" id="telefone" size="50"/>
<br/>Endereço<br/>
<input type="text" name="endereco.logradouro" size="50"/>
<br/>Estado<br/>
<input type="text" name="endereco.estado" size="50"/>
<br/>Cidade<br/>
<input type="text" name="endereco.cidade" size="50"/>
<br/>Bairro<br/>
<input type="text" name="endereco.bairro" size="50"/>
<br></center>
<center>
<button type="submit">Cadastrar Dados</button></center> 
<br/>
${msg}
</form>

<%@ page import="entity.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>






		<center><a href="${caminho}listar">Listar Todos</a></center>
<center><a href="${caminho}deletar.html">deletar</a></center>


</body>
</html>