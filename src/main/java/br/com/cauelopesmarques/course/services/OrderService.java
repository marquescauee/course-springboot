package br.com.cauelopesmarques.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.course.entities.Order;
import br.com.cauelopesmarques.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository ur;
	
	public List<Order> findAll() {
		return ur.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = ur.findById(id);
		return obj.get();
	}
}
