package pl.czerwinski.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.czerwinski.model.Day;
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
	public ResponseEntity<String> addDays(@RequestBody User user){
		daysService.addUserDays(user);
		return new ResponseEntity<String>("Days added correctly", HttpStatus.OK);
	}
	
}
