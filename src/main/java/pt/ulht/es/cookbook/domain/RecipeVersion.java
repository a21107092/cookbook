package pt.ulht.es.cookbook.domain;

import org.joda.time.DateTime;

public class RecipeVersion extends RecipeVersion_Base {
    
    public  RecipeVersion(String titulo, String problema, String solucao, String autor, String tags) {
    	setTitulo(titulo);
    	setProblema(problema);
    	setSolucao(solucao);
    	setAutor(autor);
    	setTags(tags);
    	setCreationTimestamp(new DateTime());
    }

    
}
