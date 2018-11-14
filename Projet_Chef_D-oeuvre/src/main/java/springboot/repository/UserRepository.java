package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.model.User; //importation du User pour faire le lien

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
