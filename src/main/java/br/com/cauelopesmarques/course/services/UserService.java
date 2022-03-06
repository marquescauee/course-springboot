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
	
	public User update(Long id, User user) {
		User newUser = ur.getById(id);
		updateData(newUser, user);
		
		return ur.save(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());		
	}
}
