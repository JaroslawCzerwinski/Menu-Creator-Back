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
		ConfigurableApplicationContext ctx = SpringApplication.run(MenuCreatorBackApplication.class, args);
	
	  List<User> users = new ArrayList<>();
      users.add(new User("jarek@wp.pl", "strongPassword"));
      users.add(new User("ania@wp.pl", "testoeHaslo"));
      users.add(new User("wojtek@wp.pl", "bardzoMocne Hasło"));
      
      UserRepository userRepo = ctx.getBean(UserRepository.class);
      users.forEach(userRepo::save);
      
      User firstUser = userRepo.findById(1L).get(); 
      //System.out.print(firstUser);
      userRepo.delete(firstUser); 
      
      userRepo.findAll().forEach(System.out::println);
      
      ctx.close();
	}
}
