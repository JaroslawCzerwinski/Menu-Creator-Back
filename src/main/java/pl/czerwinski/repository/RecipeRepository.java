package pl.czerwinski.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.czerwinski.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
