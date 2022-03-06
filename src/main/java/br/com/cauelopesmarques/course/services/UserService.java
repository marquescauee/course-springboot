package br.com.cauelopesmarques.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.course.models.User;
import br.com.cauelopesmarques.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = ur.findById(id);
		return obj.get();
	}
	
	public User insert(User user) {
		return ur.save(user);
	}
	
	public void delete(Long id) {
		ur.deleteById(id);
	}
}
