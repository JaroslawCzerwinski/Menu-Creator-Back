package pl.czerwinski.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.czerwinski.model.User;
import pl.czerwinski.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
private UserService userService;
	
	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<String> registrationNewUser(@RequestBody User user){
		userService.addNewUser(user);
		return new ResponseEntity<String>("User added correctly", HttpStatus.OK);
		
	}
}
