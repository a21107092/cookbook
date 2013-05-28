<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Recipe List</title>
		<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
	</head>
	
	<body>
	
		<div class="container" align="right">
			<form class="form-search" method="POST" action="/search">
			  <div class="input-append">
			    <input type="text" name="pesquisa" class="span2 search-query">
			    <button type="submit" class="btn">Pesquisa</button>
			  </div>
			</form>
		</div>
		
		<table class="table table-hover">
			<caption>${titulo}</caption>
				
			<c:forEach var="receita" items='${receitas}'>
				<tr><td><a href="/recipes/${receita.oid}">${receita.oid} - ${receita.titulo}</a></td>
					<td style="text-align: right"><a class="btn" href="/delrecipe/${receita.oid}"><i class="icon-remove"></i> Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<p>${totalReceitas}</p>
	
	</body>
</html>