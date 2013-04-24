package pt.ulht.es.cookbook.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Receita;

@Controller
public class RecipeController {
  
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {
    	Collection<Receita> receitas = CookbookManager.getRecipes();
    	model.addAttribute("receitas", receitas);
        return "listRecipes";
    }
    
    @RequestMapping("/recipes/create")
    public String showRecipesCreateForm(){
    	return "createRecipe";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/recipes")
    public String createRecipe(@RequestParam Map<String,String> params) {
    	String titulo = params.get("titulo");
    	String problema = params.get("problema");
    	String solucao = params.get("solucao");
    	
    	Receita receita = new Receita(titulo, problema, solucao);
    	CookbookManager.saveRecipe(receita);
    	
    	return "redirect:/recipes/"+receita.getId();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String showRecipe(Model model, @PathVariable String id) {
    	Receita receita = CookbookManager.getRecipe(id);
    	if(receita != null){
	    	model.addAttribute("receita",receita);
	    	return "detailedRecipe";
    	} else {
    		return "recipeNotFound";
    	}
   }
        
    
    
}