package pl.czerwinski.service;

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

	public boolean findUser(User user) {
		User userExist = userRepository.findFirstByEmailAndPassword(user.getEmail(), user.getPassword());
		if(userExist != null) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
