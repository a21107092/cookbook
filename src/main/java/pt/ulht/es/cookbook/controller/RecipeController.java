package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		int totalReceitas;

    	Collection<Recipe> receitas = CookbookManager.getInstance().getRecipe();
		List<RecipeVersion> receitasSortedList = new ArrayList<RecipeVersion>();
		for(Recipe each:receitas){
			receitasSortedList.add(each.getLastVersion());
		}
		Collections.sort(receitasSortedList, new RecipeVersion.CreationDateComparator());
    	model.addAttribute("receitas", receitasSortedList);
    	model.addAttribute("titulo", "Lista de todas as receitas");
    	
    	totalReceitas = receitasSortedList.size();
    	if (totalReceitas == 0)
    		model.addAttribute("totalReceitas", "Nao existem receitas.");
    	else if (totalReceitas == 1)
    		model.addAttribute("totalReceitas", totalReceitas +  " Receita listada.");
    	else
    		model.addAttribute("totalReceitas", totalReceitas +  " Receitas listadas.");

        return "listRecipes";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/search")
    public String search(@RequestParam String pesquisa, Model model) {
		int totalReceitas;
		
    	if(pesquisa == null || pesquisa == "")
        	return "redirect:/recipes";

    	Collection<Recipe> receitas = CookbookManager.getInstance().getRecipe();
    	List<RecipeVersion> receitasSortedList = new ArrayList<RecipeVersion>();
//pesquisa.split(",");
    	for(Recipe r:receitas){
    		for(RecipeVersion rv:r.getRecipeVersion()){
    			if(rv.getTitulo().contains(pesquisa)   || 
    	    	   rv.getProblema().contains(pesquisa) ||
    	    	   rv.getTags().contains(pesquisa)     ||
    			   rv.getSolucao().contains(pesquisa)){
    				
    				receitasSortedList.add(rv);
    			}
    		}
		}
		Collections.sort(receitasSortedList, new RecipeVersion.CreationDateComparator());
    	model.addAttribute("receitas", receitasSortedList);
       	model.addAttribute("titulo", "Lista da pesquisa: "+pesquisa);
    	
    	totalReceitas = receitasSortedList.size();
    	if (totalReceitas == 0)
    		model.addAttribute("totalReceitas", "Nao existem receitas.");
    	else if (totalReceitas == 1)
    		model.addAttribute("totalReceitas", totalReceitas +  " Receita listada.");
    	else
    		model.addAttribute("totalReceitas", totalReceitas +  " Receitas listadas.");

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
    
    @RequestMapping(method=RequestMethod.POST, value="/editedrecipe/{id}")
    public String editedRecipe(@RequestParam Map<String,String> params, @PathVariable String id) {
    	String titulo   = params.get("titulo");
    	String problema = params.get("problema");
    	String solucao  = params.get("solucao");
    	String autor    = params.get("autor");
    	String tags     = params.get("tags");
    	
    	RecipeVersion oldRecipe     = AbstractDomainObject.fromExternalId(id);
    	RecipeVersion versaoReceita = new RecipeVersion(titulo, problema, solucao, autor, tags);
    	oldRecipe.getRecipe().addRecipeVersion(versaoReceita);

    	return "redirect:/recipes/"+versaoReceita.getOid();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {
		int totalReceitas;

		RecipeVersion receita = CookbookManager.fromExternalId(id);
		
		if(receita != null){
			List<RecipeVersion> recipeList = receita.getRecipe().getRecipeVersion();

			model.addAttribute("receita",receita);
	    	model.addAttribute("listaversoes", recipeList);

	    	totalReceitas = recipeList.size();
	    	if (totalReceitas == 0){
	    		model.addAttribute("totalReceitas", "Nao existem versões desta receita.");
	    	} else if (totalReceitas == 1){
	    		model.addAttribute("totalReceitas", totalReceitas +  " versão da receita.");
	    	} else {
	    		model.addAttribute("totalReceitas", totalReceitas +  " versões da receitas.");
	    	}
	    	return "detailedRecipe";
    	} else {
    		return "recipeNotFound";
    	}
   }

    @RequestMapping("/delrecipe/{id}")
    public String delRecipe(Model model, @PathVariable String id) {
		RecipeVersion recipeVersion = AbstractDomainObject.fromExternalId(id);
    	if(recipeVersion != null){
    		Recipe recipe = recipeVersion.getRecipe();
			recipe.delete();
			CookbookManager.getInstance().removeRecipe(recipe);
	    	return "redirect:/recipes";
    	} else {
    		return "recipeNotFound";
    	}
   }

    @RequestMapping("/editrecipe/{id}")
    public String editRecipe(Model model, @PathVariable String id) {
		RecipeVersion receita = AbstractDomainObject.fromExternalId(id);
    	if(receita != null){
	    	model.addAttribute("receita",receita);
	    	return "editRecipe";
    	} else {
    		return "recipeNotFound";
    	}
   }
}