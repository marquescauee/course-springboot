package br.com.cauelopesmarques.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.course.models.User;
import br.com.cauelopesmarques.course.repositories.UserRepository;
import br.com.cauelopesmarques.course.services.exceptions.DatabaseException;
import br.com.cauelopesmarques.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = ur.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return ur.save(user);
	}
	
	public void delete(Long id) {
		try {
			ur.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		try {
			User newUser = ur.getById(id);
			updateData(newUser, user);
			return ur.save(newUser);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());		
	}
}
