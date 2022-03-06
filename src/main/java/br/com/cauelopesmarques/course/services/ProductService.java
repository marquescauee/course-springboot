package br.com.cauelopesmarques.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.course.models.Product;
import br.com.cauelopesmarques.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository ur;
	
	public List<Product> findAll() {
		return ur.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = ur.findById(id);
		return obj.get();
	}
}
