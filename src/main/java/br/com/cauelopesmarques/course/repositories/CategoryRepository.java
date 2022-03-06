package br.com.cauelopesmarques.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cauelopesmarques.course.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
