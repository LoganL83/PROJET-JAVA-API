package springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.User;
import springboot.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
	return this.userRepository.findAll();
	}

	public User findById(Long id) {
	return this.userRepository.findOne(id);
	}

	
	public User addUser(User user) {
	return this.userRepository.save(user);
	}

	public User updateUser (User user) {
	return this.userRepository.save(user);
	}

	public void deleteById(Long id) {
	this.userRepository.delete(id);
	}
}
