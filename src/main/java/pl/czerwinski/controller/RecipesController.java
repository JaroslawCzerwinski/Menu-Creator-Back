package pl.czerwinski.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	public RecipesController(RecipeService userService) {
		this.recipeService = userService;
	}
	
	@GetMapping
	public List<Recipe> getRecipes(){
		List<Recipe> recipes = recipeService.getRecipes();
		return recipes;
	}
	
	@PostMapping
	public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe){
		recipeService.addRecipe(recipe);
		return new ResponseEntity<String>("Recipe added correctly", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateRecipe(@RequestBody Recipe recipe) {
		 recipeService.updateRecipe(recipe);
		 return new ResponseEntity<String>("Recipe update correctly", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteRecipe(@RequestBody Long recipeId) {
		recipeService.deleteRecipe(recipeId);
		return new ResponseEntity<String>("Recipe deleted", HttpStatus.OK);
	}
}
