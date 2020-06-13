package pl.czerwinski.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.czerwinski.model.User;
import pl.czerwinski.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUser(){
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	@PostMapping
	@RequestMapping(headers = "action=check-user")
	public ResponseEntity<String> checkUser(@RequestBody String username){
		userService.findUser(username);
		return new ResponseEntity<String>("User with email "+ username + " exist in data base", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteUser(@RequestBody User user){
		userService.deleteUser(user);
		return new ResponseEntity<String>("User with email "+ user.getEmail() + " deleted from data base", HttpStatus.OK);
	}
	
	
}
