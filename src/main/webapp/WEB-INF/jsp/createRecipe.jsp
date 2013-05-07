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
		      <input type="text" id="titulo" placeholder="qq coisa" name="titulo">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="problema">Problema</label>
		    <div class="controls">
		      <input type="text" id="problema" name="problema">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="solucao">Solucao</label>
		    <div class="controls">
		      <input type="text" id="solucao" name="solucao">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="autor">Autor</label>
		    <div class="controls">
		      <input type="text" id="autor" name="autor">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" for="tags">Tags</label>
		    <div class="controls">
		      <input type="text" id="tags" name="tags">
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