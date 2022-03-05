package br.com.cauelopesmarques.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cauelopesmarques.course.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
