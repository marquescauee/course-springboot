package br.com.cauelopesmarques.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.course.entities.Category;
import br.com.cauelopesmarques.course.services.CategoryService;

@RestController
@RequestMapping(path="/categories")
public class CategoryResource {

	@Autowired
	private CategoryService us;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = us.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = us.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
