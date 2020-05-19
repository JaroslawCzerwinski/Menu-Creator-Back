package pl.czerwinski.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import pl.czerwinski.model.Day;
import pl.czerwinski.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findFirstByEmailAndPassword(String email, String password);

}
