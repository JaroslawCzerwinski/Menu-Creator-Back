package pl.czerwinski.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.model.Day;
import pl.czerwinski.model.User;
import pl.czerwinski.repository.DayRepository;
import pl.czerwinski.repository.UserRepository;

@Service
public class DaysService {

	private UserRepository userRepository;
	private DayRepository dayRepository;

	@Autowired
	DaysService(UserRepository userRepository, DayRepository dayRepository) {
		this.userRepository = userRepository;
		this.dayRepository = dayRepository;
	}

	public List<Day> getUserDays(User user) {
		User userEntity = userRepository.findByEmail(user.getEmail());
		return (List<Day>) userEntity.getDays();
	}

	public void addUserDays(User user) {
		List<Day> daysToSave = overrideExistingDaysOrAddNewDay(user);
		dayRepository.saveAll(daysToSave);
	}

	private List<Day> overrideExistingDaysOrAddNewDay(User user) {
		List<Day> newUserDays = (List<Day>) user.getDays();
		List<Day> daysToSave = new ArrayList<Day>();

		for (Day newDay : newUserDays) {
			if (newDay.getId() != null) {
				Day tempDay = dayRepository.findById(newDay.getId()).get();
				tempDay.setRecipes(newDay.getRecipes());
				daysToSave.add(tempDay);
			} else {
				daysToSave.add(newDay);
			}
		}
		return daysToSave;
	}

}
