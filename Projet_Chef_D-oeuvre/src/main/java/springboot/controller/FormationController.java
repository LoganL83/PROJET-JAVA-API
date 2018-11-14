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
import springboot.model.Formation;
import springboot.repository.FormationRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/formation")
public class FormationController {

	@Autowired
	private FormationRepository formationRepository;

	public FormationController(FormationRepository formationRepository) {
		super();
		this.formationRepository = formationRepository;
	}

	// je créé mon CREATE formation

	@CrossOrigin
	@PostMapping(value = "/formation")
	Formation addFormation(@Valid @RequestBody Formation formation) {
		formation = new Formation(null, null, null, null, null, null, null, null, null, 0); 
		// rajouter les arguments id, url, type, localisation, metier, certification, date, avis, note);
		return formationRepository.save(formation);
	}

	// je créé mon READ pour lire : 
	// toutes les formations
	
	@CrossOrigin
	@GetMapping("/formations")
	List<Formation> getAllActeur() {
		return formationRepository.findAll();
	}

	// ou bien les READ par ID
	
	@CrossOrigin
	@GetMapping("/formation/{id}")
	ResponseEntity<Formation> getFormationById(@PathVariable(value = "id") long id) {
		Formation formation = formationRepository.findOne(id);
		if (formation == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(formation);
	}

	// Je créé mon UPDATE de formation
	
	@CrossOrigin
	@PutMapping("/formation/{id}")
	ResponseEntity<Formation> updateFormation (@PathVariable(value = "id") long id, @Valid @RequestBody Formation formation) {
		Formation formationToUpdate = formationRepository.findOne(id);
		if (formationToUpdate == null) {
			return ResponseEntity.notFound().build();
		}

		/**
		 * Mise à jour des attributs obligatoires On considère que le nom, le lieu et le
		 * métier sont un minimum pour savoir Qui, fait quoi, et ou.
		 */

		formationToUpdate.setNom(formation.getNom());
		formationToUpdate.setLocalisation(formation.getLocalisation());
		formationToUpdate.setMetier(formation.getMetier());

		/**
		 * Mise à jour des autres attributs
		 */

		if (formation.getUrl() != null) {
			formationToUpdate.setUrl(formation.getUrl());
		}

		if (formation.getType() != null) {
			formationToUpdate.setType(formation.getType());
		}

		if (formation.getCertification() != null) {
			formationToUpdate.setCertification(formation.getCertification());
		}
		if (formation.getDate() != null) {
			formationToUpdate.setDate(formation.getDate());
		}
		if (formation.getAvis() != null) {
			formationToUpdate.setAvis(formation.getAvis());
		}
		if (formation.getNote() != 0) {
			formationToUpdate.setNote(formation.getNote());
		}
		Formation updatedFormation = formationRepository.save(formationToUpdate);
        return ResponseEntity.ok(updatedFormation);
	}
	
	//Je créé mon DELETE formation
	
	 @CrossOrigin
	    @DeleteMapping("/delete_formations/{id}")
	    ResponseEntity<Formation> deleteFormation(@PathVariable(value = "id") long id) {
	        Formation formation = formationRepository.findOne(id);
	        if (formation == null) {
	            return ResponseEntity.notFound().build();
	        }

	        formationRepository.delete(formation);
	        return ResponseEntity.ok().build();
	    }
}
