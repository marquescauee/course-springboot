package br.com.cauelopesmarques.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cauelopesmarques.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
