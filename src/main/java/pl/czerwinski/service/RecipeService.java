package pl.czerwinski.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.model.Recipe;
import pl.czerwinski.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository recipeRepository;
	
	@Autowired
	RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	public ArrayList<Recipe> getRecipes() {
		return (ArrayList<Recipe>) recipeRepository.findAll();
	}

	public boolean addRecipe(Recipe recipe) {
		Recipe recipeAdd = recipeRepository.save(recipe);
		if(recipeAdd != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateRecipe(Recipe recipe) {
		
		return false;
	}

	public boolean deleteRecipe(Recipe recipe) {
		recipeRepository.deleteById(recipe.getRecipeId());
		return false;
	}

}
