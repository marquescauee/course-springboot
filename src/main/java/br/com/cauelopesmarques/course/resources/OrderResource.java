package br.com.cauelopesmarques.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cauelopesmarques.course.entities.Order;
import br.com.cauelopesmarques.course.services.OrderService;

@RestController
@RequestMapping(path="/orders")
public class OrderResource {

	@Autowired
	private OrderService us;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = us.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = us.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
