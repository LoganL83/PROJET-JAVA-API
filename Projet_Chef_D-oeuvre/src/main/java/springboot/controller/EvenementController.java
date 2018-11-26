package springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.model.Evenement;
import springboot.repository.EvenementRepository;


	//@CrossOrigin("http://localhost:3306/taFormation?useSSL=false")
	@RestController
	@RequestMapping("/api")
	public class EvenementController {

		@Autowired
		private EvenementRepository evenementRepository;
		
		/*
		public EvenementController(EvenementRepository evenementRepository) {
			super();
			this.evenementRepository = evenementRepository;
		}*/

		// je créé mon CREATE evenement

		//@CrossOrigin
		@PostMapping(value = "/nvl-evenement")
		Evenement addEvenement(@Valid @RequestBody Evenement evenement) {
			//evenement = new Evenement(null, null, null, null, null);
			// rajouter les arguments id, date, nom, lieu, descriptif);
			return evenementRepository.save(evenement);
		}

		// je créé mon READ pour lire :
		// tous les evenements

		//@CrossOrigin
		@GetMapping("/evenement")
		List<Evenement> getAllEvenement() {
			return evenementRepository.findAll();
		}

		// ou bien les READ par ID

		//@CrossOrigin
		@GetMapping("/evenement/{id}")
		ResponseEntity<Evenement> getEvenementById(@PathVariable(value = "id") long id) {
			Evenement evenement = evenementRepository.findOne(id);
			if (evenement == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(evenement);
		}

		// Je créé mon UPDATE d'evenement

		//@CrossOrigin
		@PutMapping("/evenement/id{id}")
		ResponseEntity<Evenement> updateEvenement (@PathVariable(value = "id") long id, @Valid @RequestBody Evenement evenement) {
			Evenement evenementToUpdate = evenementRepository.findOne(id);
			if (evenementToUpdate == null) {
				return ResponseEntity.notFound().build();
			}
		/**
		 * Mise à jour des attributs obligatoire
		 */

		evenementToUpdate.setDate(evenement.getDate());
		evenementToUpdate.setNom(evenement.getNom());
		evenementToUpdate.setLieu(evenement.getLieu());
		evenementToUpdate.setDescriptif(evenement.getDescriptif());
	

		
		Evenement updatedEvenement = evenementRepository.save(evenementToUpdate);
	    return ResponseEntity.ok(updatedEvenement);
		}
		

		// Je créé mon DELETE evenement

		//@CrossOrigin
		@DeleteMapping("/evenement/id{id}")
		ResponseEntity<Evenement> deleteEvenement(@PathVariable(value = "id") long id) {
			Evenement evenement = evenementRepository.findOne(id);
			if (evenement == null) {
				return ResponseEntity.notFound().build();
			}

			evenementRepository.delete(evenement);
			return ResponseEntity.ok().build();
		}
		
	}
