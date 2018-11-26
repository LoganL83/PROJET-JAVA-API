package springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

	/*List<Evenement> findById(Long id);
	List<Evenement> findByLieu(String lieu);
	List<Evenement> findByDate(Date date);
	List<Evenement> findByNom(String nom);
	List<Evenement> findAll();
	*/
	
}