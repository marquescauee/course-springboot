package br.com.cauelopesmarques.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cauelopesmarques.course.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
