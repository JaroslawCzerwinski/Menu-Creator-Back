package pl.czerwinski.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.czerwinski.model.Recipe;
import pl.czerwinski.model.User;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
