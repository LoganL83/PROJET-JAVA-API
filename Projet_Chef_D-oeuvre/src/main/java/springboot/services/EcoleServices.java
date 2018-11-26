package springboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.Ecole;
import springboot.repository.EcoleRepository;


@Service
public class EcoleServices {

	@Autowired
	private EcoleRepository ecoleRepository;
	
	public List<Ecole> findAll() {
	return this.ecoleRepository.findAll();
	}

	public Ecole findById(Long id) {
	return this.ecoleRepository.findOne(id);
	}

	
	public Ecole addEcole(Ecole ecole) {
	return this.ecoleRepository.save(ecole);
	}

	public Ecole updateEcole (Ecole ecole) {
	return this.ecoleRepository.save(ecole);
	}

	public void deleteById (Long id) {
	this.ecoleRepository.delete(id);
	}
}

