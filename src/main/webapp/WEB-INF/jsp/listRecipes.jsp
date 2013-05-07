<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Recipe List</title>
	<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
</head>
<body>
<table class="table table-hover">
	<caption>Lista de receitas</caption>
		
	<c:forEach var="receita" items='${receitas}'>
		<tr><td><a href="/recipes/${receita.id}">${receita.id} - ${receita.titulo}</a>
		</td></tr>
	</c:forEach>
</table>

<p>${totalReceitas}</p>

<!--R2 - Listar Receitas
Deve ser possivel listar receitas existentes, essa listagem deve estar ordenada
por ordem alfabetica do titulo da receita.

Na vista de listagem de
receitas, deve aparecer sempre a ultima versao de cada receita.
-->
</body>
</html>