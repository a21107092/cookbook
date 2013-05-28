<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Receita nº ${receita.oid}</title>
	<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
</head>
<body>
<div class="container">
	<h3>Receita ${receita.oid} - ${receita.titulo}</h3>
	<dl>
	  <dt>Problema</dt>
	  <dd>${receita.problema}</dd>
	  <dt>Solução</dt>
      <textarea rows="6" class="input-block-level" type="text" id="solucao" name="solucao">${receita.solucao}</textarea>
	  <dt>Autor</dt>
	  <dd>${receita.autor}</dd>
	  <dt>Tags</dt>
	  <dd>${receita.tags}</dd>
	  <dt>Receita criada em</dt>
	  <dd>${receita.creationTimestampFormatada}</dd>
	</dl>
<div>

<div class="btn-group">
  <a class="btn" href="/editrecipe/${receita.oid}"><i class="icon-pencil"></i> Editar</a>
</div>

</br>
</br>
<div class="container">
		<table class="table table-hover">
			<caption>Lista de versões desta receita</caption>
				
			<c:forEach var="receitaversao" items='${listaversoes}'>
				<tr><td><a href="/recipes/${receitaversao.oid}">Versão de ${receitaversao.creationTimestampFormatada} (${receitaversao.titulo}) <small>(nº ${receitaversao.oid})</small></a></td>
				</tr>
			</c:forEach>
		</table>
		
		<p>${totalReceitas}</p>
</div>
	
<!--
<script type=text/javascipt">
	$("#benfica-button").click(function(e)) {
		$("#benfica-button").text("novo texto");
		$("this").text("novo texto");
		$(".span12").append("<b>novo texto</b><br/>");
		alert("sssss");
		
	});

</script>
-->
</body>
</html>