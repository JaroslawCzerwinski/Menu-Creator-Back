package pl.czerwinski.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuCreatorController {

	@RequestMapping("/menuCreator")
	public String getMenuCreator(){
		return "{ttile: menu-creator}";
	}
}
