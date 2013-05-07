package pt.ulht.es.cookbook.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
    	int totalReceitas;
		List<Receita> receitasSortedList = new ArrayList<Receita>(CookbookManager.getRecipes());
		Collections.sort(receitasSortedList, new Receita.CreationDateComparator());

    	model.addAttribute("receitas", receitasSortedList);
    	
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
    	String titulo = params.get("titulo");
    	String problema = params.get("problema");
    	String solucao = params.get("solucao");
    	String autor = params.get("autor");
    	String tags = params.get("tags");
    	
    	Receita receita = new Receita(titulo, problema, solucao, autor, tags);
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