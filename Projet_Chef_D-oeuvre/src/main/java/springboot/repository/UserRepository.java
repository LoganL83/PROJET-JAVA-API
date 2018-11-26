package springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.model.User; //importation du User pour faire le lien

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/*List<User> findById(Long id);
	List<User> findByEmail(String email);
	List<User> findBySituation(String situation);
	*/
}
