package pl.czerwinski.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.czerwinski.model.Day;
import pl.czerwinski.model.DayId;
import pl.czerwinski.model.User;

public interface DayRepository extends CrudRepository<Day, DayId>{

	List<Day> findAllByUser(User user);

}
