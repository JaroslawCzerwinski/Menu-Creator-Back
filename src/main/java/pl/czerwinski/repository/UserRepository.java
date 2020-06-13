package pl.czerwinski.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.czerwinski.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>{
	
	boolean existsByEmail(String email);

	User findByEmail(String email);
	

}
