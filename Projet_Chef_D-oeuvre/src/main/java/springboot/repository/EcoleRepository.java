package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Ecole;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Long> {
/*
	List<Ecole> findByLocalisation(String localisation);
	List<Ecole> findByNom(String nom);
	List<Ecole> findByNote(double note);
	*/
}
