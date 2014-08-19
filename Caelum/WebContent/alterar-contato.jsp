<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="data" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Contatos</title>
</head>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>


<body>
	<c:import url="cabecalho.jsp"></c:import>
	<h1>Agenda</h1>
	<form action="mvc" method="post">
		<table>
			<tr>
			<tr>
				Nome
				<input type="text" name="nome" value = "${param.nome}">
				<br />
			</tr>
			<tr>
				Email
				<input type="text" name="email" value = "${param.email}">
				<br />
			<tr>
				Endereco
				<input type="text" name="endereco" value = "${param.endereco}">
				<br />
			</tr>
			<tr>
				Data Nascimento
				<data:campoData id="dataNascimento"></data:campoData>
				<br />
			</tr>
			<tr>
			<input type="submit" name="alterar" value="Alterar">
			<input type ="hidden" name="logica" value="AlterarContatos">
			<input type ="hidden" name="pass" value ="listar">
			</tr>

			</tr>



		</table>



	</form>



</body>
</html>