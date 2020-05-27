package pl.czerwinski.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.czerwinski.model.Day;

@Repository
public interface DayRepository extends CrudRepository<Day, Long>{

	
}
