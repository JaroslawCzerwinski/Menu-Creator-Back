package pl.czerwinski;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.czerwinski.model.User;
import pl.czerwinski.repository.UserRepository;

@SpringBootApplication
public class MenuCreatorBackApplication {

	public static void main(String[] args) {
		 SpringApplication.run(MenuCreatorBackApplication.class, args);
	
	}
}
