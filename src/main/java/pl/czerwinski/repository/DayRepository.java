package pl.czerwinski.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.czerwinski.model.DayId;
import pl.czerwinski.model.Recipe;

@Repository
public interface DayRepository extends CrudRepository<Recipe, DayId>{

	
}
