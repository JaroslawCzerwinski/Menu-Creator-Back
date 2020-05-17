package pl.czerwinski.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@PostMapping
	public boolean checkUser(@RequestBody User user){
		boolean userExist = userService.findUser(user);
		return userExist;
	}
	
	@DeleteMapping
	public boolean deleteUser(@RequestBody User user){
		boolean userDelete = userService.deleteUser(user);
		return userDelete;
	}
	
	
}
