package pl.czerwinski.controller;

import java.sql.Date;
import java.util.List;

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
	
	@PostMapping
	public List<Day> getDays(@RequestBody User user, Date startDate){
		List<Day> userDays = daysService.getUserDays(user, startDate);
		return userDays;
	}
}