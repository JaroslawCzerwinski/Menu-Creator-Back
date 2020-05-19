package pl.czerwinski.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.model.Day;
import pl.czerwinski.model.Recipe;
import pl.czerwinski.model.User;
import pl.czerwinski.repository.DayRepository;
import pl.czerwinski.repository.UserRepository;

@Service
public class DaysService {

private UserRepository userRepository;
private DayRepository dayRepository;
	
	@Autowired
	DaysService( UserRepository userRepository, DayRepository dayRepository) {
		this.userRepository = userRepository;
		this.dayRepository = dayRepository;
	}

	public List<Day> getUserDays(User user) {
		 Optional<User> userEntity = userRepository.findById(user.getUserId());
		 return  userEntity.get().getDays();
	}

	public ArrayList<User> addUserDays(User user) {
		ArrayList<User> userEntity = (ArrayList<User>) userRepository.findAll();
		System.out.println(userEntity.toString());
		//ArrayList<Recipe> dayEntity = (ArrayList<Recipe>) dayRepository.findAll();
		//System.out.println(dayEntity.toString());
		return userEntity;
	}
		
	

}
