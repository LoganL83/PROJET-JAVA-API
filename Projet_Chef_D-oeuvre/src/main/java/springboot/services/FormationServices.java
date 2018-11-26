package springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.Formation;
import springboot.repository.FormationRepository;

@Service
public class FormationServices {

	@Autowired
	private FormationRepository formationRepository;
	
	public List<Formation> findAll() {
	return this.formationRepository.findAll();
	}

	public Formation findById(Long id) {
	return this.formationRepository.findOne(id);
	}
	
	public Formation addFormation(Formation formation) {
	return this.formationRepository.save(formation);
	}

	public Formation updateFormation (Formation formation) {
	return this.formationRepository.save(formation);
	}

	public void deleteById (Long id) {
	this.formationRepository.delete(id);
	}
}
