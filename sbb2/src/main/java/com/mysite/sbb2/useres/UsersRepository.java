package com.mysite.sbb2.useres;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;





public interface UsersRepository extends JpaRepository<Users, Integer> {

	Page<Users> findAll(Pageable pageable);
	

	

}


