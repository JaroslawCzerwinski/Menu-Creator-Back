package pl.czerwinski.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.czerwinski.model.Day;
import pl.czerwinski.model.Recipe;
import pl.czerwinski.model.User;
import pl.czerwinski.service.DaysService;

@RestController
@RequestMapping("/days")
public class DaysController {

	private DaysService daysService;
	
	public DaysController(DaysService daysService) {
		this.daysService = daysService;
	}
	
	@PostMapping(headers = "action=get-days")
	public List<Day> getDays(@RequestBody User user){
		List<Day> userDays = daysService.getUserDays(user);
		return userDays;
	}
	
	@PostMapping(headers ="action=add-days")
	public ArrayList<User> addDays(@RequestBody User user){
		ArrayList<User> tempUser = daysService.addUserDays(user);
		return tempUser;
	}
	
}
