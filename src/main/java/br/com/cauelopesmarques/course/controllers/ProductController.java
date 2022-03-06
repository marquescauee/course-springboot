package br.com.cauelopesmarques.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.course.models.Product;
import br.com.cauelopesmarques.course.services.ProductService;

@RestController
@RequestMapping(path="/products")
public class ProductController {

	@Autowired
	private ProductService us;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = us.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = us.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
