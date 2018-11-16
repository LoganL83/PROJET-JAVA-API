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
import springboot.model.User;
import springboot.repository.UserRepository;

//@CrossOrigin("http://localhost:3306/taFormation?useSSL=false") //?useSSL=false
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	
	
	// je créé mon CREATE user

		//@CrossOrigin
		@PostMapping(value = "/user")
		User addUser(@Valid @RequestBody User user) {
			//user = new User(null, null, null, 0, null, null, null/*, null, null*/); 
			// rajouter les arguments id, email, mot de passe, age, lieu, niveau d'étude, situation, liste écoles, liste formations);
			return userRepository.save(user);
		}

		// je créé mon READ pour lire : 
		// tous les utilisateurs
		
		//@CrossOrigin
		@GetMapping("/user")
		List<User> getAllUser() {
			return userRepository.findAll();
		}

		// ou bien les READ par ID
		
		//@CrossOrigin
		@GetMapping("/user/{id}")
		ResponseEntity<User> getUserById(@PathVariable(value = "id") long id) {
			User user = userRepository.findOne(id);
			if (user == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}

		// Je créé mon UPDATE de user
		
		//@CrossOrigin
		@PutMapping("/user/{id}")
		ResponseEntity<User> updateUser (@PathVariable(value = "id") long id, @Valid @RequestBody User user) {
			User userToUpdate = userRepository.findOne(id);
			if (userToUpdate == null) {
				return ResponseEntity.notFound().build();
			}

			/**
			 * Mise à jour des attributs obligatoires On considère que l'email ainsi que le mot
			 * de passe sont primordiaux pour se connecter
			 */

			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setMot_de_passe(user.getMot_de_passe());

			/**
			 * Mise à jour des autres attributs
			 */

			if (user.getAge() != 0) {
				userToUpdate.setAge(user.getAge());
			}

			if (user.getLieu() != null) {
				userToUpdate.setLieu(user.getLieu());
			}

			if (user.getNiveau_etude() != null) {
				userToUpdate.setNiveau_etude(user.getNiveau_etude());
			}
			if (user.getSituation() != null) {
				userToUpdate.setSituation(user.getSituation());
			}
			User updatedUser = userRepository.save(userToUpdate);
	        return ResponseEntity.ok(updatedUser);
		}
		
		//Je créé mon DELETE user
		
		//@CrossOrigin
		@DeleteMapping("/people/{id}")
		ResponseEntity<User> deleteUser(@PathVariable(value = "id") long id) {
		        User user = userRepository.findOne(id);
		        if (user == null) {
		            return ResponseEntity.notFound().build();
		        }

		        userRepository.delete(user);
		        return ResponseEntity.ok().build();
		    }
		
		public UserController(UserRepository userRepository) {
			super();
			this.userRepository = userRepository;
		}
	}

