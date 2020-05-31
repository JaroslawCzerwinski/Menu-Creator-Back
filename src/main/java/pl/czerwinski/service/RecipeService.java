package pl.czerwinski.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.exception.MissingIdException;
import pl.czerwinski.exception.RecipeAlreadyExistException;
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

	public void addRecipe(Recipe recipe) {
		if (recipe.getRecipeId() == null) {
			recipeRepository.save(recipe);
		} else {
			throw new RecipeAlreadyExistException(recipe.getName());
		}
	}

	public void updateRecipe(Recipe recipe) {
		if (recipe.getRecipeId() != null) {
		recipeRepository.save(recipe);
		} else {
			throw new MissingIdException();
		}
	}

	public void deleteRecipe(Recipe recipe) {
		if (recipe.getRecipeId() != null) {
		recipeRepository.deleteById(recipe.getRecipeId());
		} else {
			throw new MissingIdException();
		}
	}

}
