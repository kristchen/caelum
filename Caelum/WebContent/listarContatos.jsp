<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<h1>Lista de Contatos  </h1>

	<table border="3">

		<tr>
			
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data Nascimento</th>
			<th><a href="addContato.jsp">Adicionar Contato</a></th>

			<c:forEach var="contato" items="${contatos}">
		</tr>

		<tr>
			<td>${contato.nome}</td>
			<td>${contato.email}</td>
			<td>${contato.endereco}</td>
			<td>${contato.dataNascimento}</td>
			
			<td><a href="contatos-servlet?logica=RemoveContatos&id=${contato.id}">Remover</a>
			</td>
			
			<td><a href="contatos-servlet?logica=AlterarContatos&id=${contato.id}&pass=alterar">Alterar</a>
										
			
			
			</td>
		</tr>
		</c:forEach>
	</table>










</body>
</html>