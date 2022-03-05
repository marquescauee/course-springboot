package br.com.cauelopesmarques.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauelopesmarques.course.entities.Category;
import br.com.cauelopesmarques.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cr;
	
	public List<Category> findAll() {
		return cr.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = cr.findById(id);
		return obj.get();
	}
}
