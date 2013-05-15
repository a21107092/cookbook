<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Receita nº ${receita.id}</title>
	<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
</head>
<body>
<div class="container">
	<h3>Receita ${receita.id} - ${receita.titulo}</h3>
	<dl>
	  <dt>Problema</dt>
	  <dd>${receita.problema}</dd>
	  <dt>Solução</dt>
	  <dd>${receita.solucao}</dd>
	  <dt>Autor</dt>
	  <dd>${receita.autor}</dd>
	  <dt>Tags</dt>
	  <dd>${receita.tags}</dd>
	  <dt>Receita criada em</dt>
	  <dd>${receita.dataCriacaoFormatada}</dd>
	</dl>
<div>

<!--
<div class="btn-group">
  <a class="btn" href="/editrecipe/${receita.id}"><i class="icon-pencil"></i> Editar</a>
  <a class="btn" href="/delrecipe/${receita.id}"><i class="icon-remove"></i> Eliminar</a>
</div>

	<br/><br/><br/>
R3 - Ver Receita em Detalhe
Deve ser possivel clicar numa receita da lista de receitas, e ver essa receita em
detalhe. Essa vista detalhe da receita deve incluir o titulo da receita, o problema
e a sua respectiva descricao. Deve tambem estar presente nessa vista em detalhe,
qual o nome do autor e a respectiva data e hora (timestamp) da criacao dessa
receita.

Assim, na vista detalhada da
receita, deve aparecer igualmente uma lista das varias versoes existentes, bem como a data em que cada uma das versoes
 foi editada.
-->
</body>
</html>