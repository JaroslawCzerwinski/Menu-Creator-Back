package pl.czerwinski.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.czerwinski.model.Recipe;
import pl.czerwinski.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
	
	private RecipeService recipeService;

	public RecipesController( RecipeService userService) {
		this.recipeService = userService;
	}
	
	@GetMapping
	public List<Recipe> getRecipes(){
		List<Recipe> recipes = recipeService.getRecipes();
		return recipes;
	}
	
	@PostMapping
	public boolean addRecipe(@RequestBody Recipe recipe){
		boolean recipeAdd = recipeService.addRecipe(recipe);
		return recipeAdd;
	}
	
	@PutMapping
	public boolean updateRecipe(@RequestBody Recipe recipe) {
		boolean recipeUpdate = recipeService.updateRecipe(recipe);
		return recipeUpdate;
	}
	
	@DeleteMapping
	public boolean deleteRecipe(@RequestBody Recipe recipe) {
		boolean recipeDelete = recipeService.deleteRecipe(recipe);
		return recipeDelete;
	}
}
