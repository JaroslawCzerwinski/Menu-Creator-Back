package pl.czerwinski.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.czerwinski.exception.MissingIdException;
import pl.czerwinski.exception.UserAlreadyExistException;
import pl.czerwinski.exception.UserMissingException;
import pl.czerwinski.model.Day;
import pl.czerwinski.model.User;
import pl.czerwinski.repository.UserRepository;

@Service
public class UserService {

	private final int dayInMilliseconds = 86400000;
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Iterable<User> usersEntity = userRepository.findAll();
		usersEntity.forEach(users::add);
		return users;
	}

	public void findUser(String username) {
		User userExist = userRepository.findByEmail(username);
		if (userExist == null) {
			throw new UserMissingException();
		}
	}

	public void deleteUser(User user) {
		if (user.getUserId() != null) {
			userRepository.deleteById(user.getUserId());
		} else {
			throw new MissingIdException();
		}
	}

	public void addNewUser(User user) {
		boolean userAlreadyExist = userRepository.existsByEmail(user.getEmail());
		if (userAlreadyExist) {
			throw new UserAlreadyExistException(user.getEmail());
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			ArrayList<Day> emptyDays = initNewUserEmptyDays();
			user.setDays(emptyDays);
			userRepository.save(user);
		}
	}

	private ArrayList<Day> initNewUserEmptyDays() {
		ArrayList<Day> emptyDays = new ArrayList<Day>();
		
		for (int i = 0; i < 5; i++) {
			Day day = new Day();
			Date tempDate = new Date(System.currentTimeMillis() + dayInMilliseconds * i );
			day.setDate(tempDate);
			emptyDays.add(day);
		}
		
		for (int i = 1; i < 5; i++) {
			Day day = new Day();
			Date tempDate = new Date(System.currentTimeMillis() - dayInMilliseconds * i );
			day.setDate(tempDate);
			emptyDays.add(day);
		}
		return emptyDays;
	}

}