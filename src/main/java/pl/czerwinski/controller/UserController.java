package pl.czerwinski.controller;

import java.util.List;

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
	public boolean checkUser(@RequestBody User user){
		boolean userExist = userService.findUser(user);
		return userExist;
	}
	
	@PostMapping
	@RequestMapping(headers = "action=add-user")
	public boolean addUser(@RequestBody User user){
		boolean userAdd = userService.addUser(user);
		return userAdd;
	}
	
	@DeleteMapping
	public boolean deleteUser(@RequestBody User user){
		boolean userDelete = userService.deleteUser(user);
		return userDelete;
	}
	
	
}
