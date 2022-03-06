package br.com.cauelopesmarques.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.course.models.Category;
import br.com.cauelopesmarques.course.services.CategoryService;

@RestController
@RequestMapping(path="/categories")
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = cs.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = cs.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
