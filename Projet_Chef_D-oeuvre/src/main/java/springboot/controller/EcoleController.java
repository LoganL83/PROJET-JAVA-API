package springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Ecole;
import springboot.repository.EcoleRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/ecole")

public class EcoleController {

	@Autowired
	private EcoleRepository ecoleRepository;

	public EcoleController(EcoleRepository ecoleRepository) {
		super();
		this.ecoleRepository = ecoleRepository;
	}

	// je créé mon CREATE ecole

	@CrossOrigin
	@PostMapping(value = "/ecole")
	Ecole addEcole(@Valid @RequestBody Ecole ecole) {
		ecole = new Ecole(null, null, null, null, null, 0);
		// rajouter les arguments id, nom, url, localisation, avis, note);
		return ecoleRepository.save(ecole);
	}

	// je créé mon READ pour lire :
	// toutes les écoles

	@CrossOrigin
	@GetMapping("/ecole")
	List<Ecole> getAllEcole() {
		return ecoleRepository.findAll();
	}

	// ou bien les READ par ID

	@CrossOrigin
	@GetMapping("/ecole/{id}")
	ResponseEntity<Ecole> getEcoleById(@PathVariable(value = "id") long id) {
		Ecole ecole = ecoleRepository.findOne(id);
		if (ecole == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ecole);
	}

	// Je créé mon UPDATE de user

	@CrossOrigin
	@PutMapping("/ecole/{id}")
	ResponseEntity<Ecole> updateEcole (@PathVariable(value = "id") long id, @Valid @RequestBody Ecole ecole) {
		Ecole ecoleToUpdate = ecoleRepository.findOne(id);
		if (ecoleToUpdate == null) {
			return ResponseEntity.notFound().build();
		}
	/**
	 * Mise à jour des attributs obligatoires On considère que l'email ainsi que le
	 * nom, le lieu sont primordiaux.
	 */

	ecoleToUpdate.setNom(ecole.getNom());
	ecoleToUpdate.setLocalisation(ecole.getLocalisation());

	/**
	 * Mise à jour des autres attributs
	 */

	if(ecole.getUrl()!=null)

	{
				ecoleToUpdate.setUrl(ecole.getUrl());
			}

	if(ecole.getAvis()!=null)
	{
		ecoleToUpdate.setAvis(ecole.getAvis());
	}

	if(ecole.getNote()!=0)
	{
		ecoleToUpdate.setNote(ecole.getNote());
	}
	}

	// Je créé mon DELETE école

	@CrossOrigin
	@DeleteMapping("/delete_ecole/{id}")
	ResponseEntity<Ecole> deleteEcole(@PathVariable(value = "id") long id) {
		Ecole ecole = ecoleRepository.findOne(id);
		if (ecole == null) {
			return ResponseEntity.notFound().build();
		}

		ecoleRepository.delete(ecole);
		return ResponseEntity.ok().build();
	}
}
