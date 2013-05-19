package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;
import pt.ulht.es.cookbook.domain.RecipeVersion;

@Controller
public class RecipeController {
  
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {
    	Collection<Recipe> receitas = CookbookManager.getInstance().getRecipe();
		List<RecipeVersion> receitasSortedList = new ArrayList<RecipeVersion>();
		for(Recipe each:receitas){
			receitasSortedList.add(each.getLastVersion());
		}
//		Collections.sort(receitasSortedList, new Receita.CreationDateComparator());
    	model.addAttribute("receitas", receitasSortedList);
        return "listRecipes";
    }
    
    @RequestMapping("/recipes/create")
    public String showRecipesCreateForm(){
    	return "createRecipe";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/recipes")
    public String createRecipe(@RequestParam Map<String,String> params) {
    	String titulo   = params.get("titulo");
    	String problema = params.get("problema");
    	String solucao  = params.get("solucao");
    	String autor    = params.get("autor");
    	String tags     = params.get("tags");

    	Recipe receita = new Recipe(titulo, problema, solucao, autor, tags);
		RecipeVersion versaoReceita = receita.getLastVersion();
    	return "redirect:/recipes/"+versaoReceita.getOid();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {
		RecipeVersion receita = AbstractDomainObject.fromExternalId(id);
    	if(receita != null){
	    	model.addAttribute("receita",receita);
	    	return "detailedRecipe";
    	} else {
    		return "recipeNotFound";
    	}
   }
        
    
    
}