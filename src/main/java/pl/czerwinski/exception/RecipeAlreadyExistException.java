package pl.czerwinski.exception;

public class RecipeAlreadyExistException extends RuntimeException {

	
	public RecipeAlreadyExistException(String name) {
		super("Recipe with name " + name + " already exist in database");
	}
}
