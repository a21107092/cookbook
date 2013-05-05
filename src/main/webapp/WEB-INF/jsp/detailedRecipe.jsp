<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe ${receita.id}</title>
</head>
<body>
	<h1>${receita.titulo}<h1/>
	<b>Problema:</b>
	<p>${receita.problema}</p>
	<b>Solução:</b>
	<p>${receita.solucao}</p>
	<b>Autor:</b>
	<p>${receita.autor}</p>
	<b>Tags:</b>
	<p>${receita.tags}</p>
	
	<br/><br/><br/>
R3 - Ver Receita em Detalhe
Deve ser possivel clicar numa receita da lista de receitas, e ver essa receita em
detalhe. Essa vista detalhe da receita deve incluir o titulo da receita, o problema
e a sua respectiva descricao. Deve tambem estar presente nessa vista em detalhe,
qual o nome do autor e a respectiva data e hora (timestamp) da criacao dessa
receita.

Assim, na vista detalhada da
receita, deve aparecer igualmente uma lista das varias versoes existentes, bem como a data em que cada uma das versoes foi editada.
</body>
</html>