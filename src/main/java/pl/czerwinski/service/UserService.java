package pl.czerwinski.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.exception.MissingIdException;
import pl.czerwinski.exception.UserAlreadyExistException;
import pl.czerwinski.exception.UserMissingException;
import pl.czerwinski.model.User;
import pl.czerwinski.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

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

	public void findUser(User user) {
		User userExist = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (userExist == null) {
			throw new UserMissingException();
		}
	}

	public void deleteUser(User user) {
		if(user.getUserId() != null) {
			userRepository.deleteById(user.getUserId());
		} else {
			throw new MissingIdException();
		}
	}

	public void addNewUser(User user) {
			 boolean userAlreadyExist = userRepository.existsByEmail(user.getEmail());
			 if(userAlreadyExist) {
				 throw new UserAlreadyExistException(user.getEmail());
			 } else {
				 userRepository.save(user);
			 }
	}
}
