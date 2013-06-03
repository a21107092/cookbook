package pt.ulht.es.cookbook.domain;

public class Recipe extends Recipe_Base {
    
    public  Recipe(String titulo, String problema, String solucao, String autor, String tags) {
        RecipeVersion initialVersion = new RecipeVersion(titulo, problema, solucao, autor, tags);
        addRecipeVersion(initialVersion);
        setCookbookManager(CookbookManager.getInstance());
    }

	public RecipeVersion getLastVersion() {
		RecipeVersion rvRet = getRecipeVersionIterator().next();
		
		for(RecipeVersion rv: getRecipeVersionSet()){
			if( rv.getCreationTimestamp().compareTo(rvRet.getCreationTimestamp())>0 )
				rvRet = rv;
		}
		return rvRet;
	}

	public void delete() {
		for (RecipeVersion recipeVersion : getRecipeVersionSet() ) {
			recipeVersion.delete();
		}
		setCookbookManager(null);
		super.deleteDomainObject();
	}


}
