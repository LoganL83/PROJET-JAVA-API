package springboot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Formation; //importation de Formation


@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
/*
	List<Formation> findByDate(LocalDate date);
	List<Formation> findByMetier(String metier);
	List<Formation> findByLocalisation(String localisation);
	List<Formation> findByType(String type);
	List<Formation> findByCertification(String certification);
	List<Formation> fondByNote(double note);*/
	
}