package pt.ulht.es.cookbook.domain;

public class Recipe extends Recipe_Base {
    
    public  Recipe(String titulo, String problema, String solucao, String autor, String tags) {
        RecipeVersion initialVersion = new RecipeVersion(titulo, problema, solucao, autor, tags);
        addRecipeVersion(initialVersion);
        setCookbookManager(CookbookManager.getInstance());
    }

	public RecipeVersion getLastVersion() {
		// TODO Auto-generated method stub
		return getRecipeVersionIterator().next();
	}

	public void delete() {
		for (RecipeVersion recipeVersion : getRecipeVersionSet() ) {
			recipeVersion.delete();
		}
		setCookbookManager(null);
		super.deleteDomainObject();
	}


}
