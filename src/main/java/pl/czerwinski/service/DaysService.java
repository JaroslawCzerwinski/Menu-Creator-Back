package pl.czerwinski.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.model.Day;
import pl.czerwinski.model.User;
import pl.czerwinski.repository.DayRepository;

@Service
public class DaysService {

private DayRepository dayRepository;
	
	@Autowired
	DaysService( DayRepository dayRepository) {
		this.dayRepository = dayRepository;
	}

	public List<Day> getUserDays(User user, Date startDate) {
		return dayRepository.findAllByUser(user);
	}

}
