package pt.ulht.es.cookbook.domain;

public class Recipe extends Recipe_Base {
    
    public  Recipe(String titulo, String problema, String solucao, String autor, String tags) {
    	System.out.println("Entrou no construtor da receita");
        RecipeVersion initialVersion = new RecipeVersion(titulo, problema, solucao, autor, tags);
        addRecipeVersion(initialVersion);
        setCookbookManager(CookbookManager.getInstance());
    	System.out.println("Terminou o construtor da receita "+getOid());
    	System.out.println("Id da RecipeVersion "+initialVersion.getOid());
    }
    
}
