package pt.ulht.es.cookbook.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CookbookManager {

	private static int nextReceitaId = 1;
	private static Map<String,Receita> RECEITA_MAP = new HashMap<String,Receita>();

	public static void saveRecipe(Receita receita) {
		String id = nextReceitaId+"";
		RECEITA_MAP.put(id, receita);
		receita.setId(id);
		nextReceitaId++;
	}

	public static Receita getRecipe(String id) {
		return RECEITA_MAP.get(id);
	}

	public static Collection<Receita> getRecipes() {
		return RECEITA_MAP.values();
	}

}
