package pl.czerwinski.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.czerwinski.model.User;
import pl.czerwinski.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	
	@Autowired
	UserService( UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Iterable<User> usersEntity = userRepository.findAll();
		usersEntity.forEach(users::add);
		return users;
	}
	
	public boolean addUser(User user) {
		userRepository.save(user);
		boolean userAddSucess = userRepository.existsById(user.getUserId());
		return userAddSucess;
	}

	public boolean findUser(User user) {
		User userExist = userRepository.findFirstByEmailAndPassword(user.getEmail(), user.getPassword());
		if(userExist != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteUser(User user) {
		userRepository.deleteById(user.getUserId());
		boolean userExist = userRepository.existsById(user.getUserId());
		if (!userExist) {
			return true;
		} else {
			return false;
		}
	}
}
