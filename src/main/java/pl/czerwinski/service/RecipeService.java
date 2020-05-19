package pl.czerwinski.service;

import java.util.ArrayList;
import java.util.Optional;

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

	public void updateRecipe(Recipe recipe) {
		Optional<Recipe> recipeEntity = recipeRepository.findById(recipe.getRecipeId());
		Recipe recipeUpdate = recipeEntity.get();
		recipeUpdate.setDescription(recipe.getDescription());
		recipeUpdate.setImagePath(recipe.getImagePath());
		recipeUpdate.setIngredients(recipe.getIngredients());
		recipeUpdate.setName(recipe.getName());
		recipeRepository.save(recipeUpdate);
	}
	
	public boolean deleteRecipe(Recipe recipe) {
		recipeRepository.deleteById(recipe.getRecipeId());
		boolean recipeExist = recipeRepository.existsById(recipe.getRecipeId());
		if (!recipeExist) {
			return true;
		} else {
			return false;
		}
	}

}
