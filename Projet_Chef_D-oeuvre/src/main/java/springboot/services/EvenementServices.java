package springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.Evenement;
import springboot.repository.EvenementRepository;


@Service
public class EvenementServices {

	@Autowired
	private EvenementRepository evenementRepository;
	
	public List<Evenement> findAll() {
	return this.evenementRepository.findAll();
	}

	public Evenement findById(Long id) {
	return this.evenementRepository.findOne(id);
	}

	
	public Evenement addEvenement(Evenement evenement) {
	return this.evenementRepository.save(evenement);
	}

	public Evenement updateEvenement (Evenement evenement) {
	return this.evenementRepository.save(evenement);
	}

	public void deleteById (Long id) {
	this.evenementRepository.delete(id);
	}
}


