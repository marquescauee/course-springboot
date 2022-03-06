package br.com.cauelopesmarques.course.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cauelopesmarques.course.models.User;
import br.com.cauelopesmarques.course.services.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = us.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = us.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<User> insert(@RequestBody User user) {
		user = us.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		us.delete(id);
		return ResponseEntity.noContent().build();
	}
}
