<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Criar nova receita</title>
		<%@ include file="/WEB-INF/jsp/common/libs.jsp" %>
	</head>
	<body>
		<form class="form-horizontal" method="POST" action="/recipes">
		  <div class="control-group">
		    <label class="control-label" for="titulo">Titulo</label>
		    <div class="controls">
		      <input class="input-block-level" type="text" id="titulo" placeholder="Titulo da receita" name="titulo" autofocus />
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="problema">Problema</label>
		    <div class="controls">
		      <input class="input-block-level" type="text" id="problema" placeholder="Descrição do problema" name="problema"/>
			  </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="solucao">Solucao</label>
		    <div class="controls">
		      <textarea rows="6" class="input-block-level" type="text" id="solucao" name="solucao" ></textarea>
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="autor">Autor</label>
		    <div class="controls">
		      <input class="input-block-level" type="text" id="autor" placeholder="Nome do autor" name="autor" />
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="tags">Tags</label>
		    <div class="controls">
		      <input class="input-block-level" type="text" id="tags" placeholder="palavras separadas por uma virgula" name="tags">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn">Criar nova receita</button>
		    </div>
		  </div>
		</form>
	</body>
</html>