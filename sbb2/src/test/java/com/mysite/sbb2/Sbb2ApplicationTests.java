package com.mysite.sbb2;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.useres.Users;
import com.mysite.sbb2.useres.UsersRepository;

@SpringBootTest
class Sbb2ApplicationTests {
	
	@Autowired
	private UsersRepository usersRepository;
	
	
/*
	@Test
	void contextLoads() {
		Users u1 = new Users();
		u1.setName("명성아");
		u1.setPass("5678");
		u1.setEmail("tjddk6229");
		u1.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u1);
		
		
		
	}
	*/
	
	@Test
	public void insert1000() {
		Users u = null;
		
		for(int i=1; i<=1000; i++) {
			u = new Users();
			u.setName("명성아 -" +i);
			u.setPass("pass1");
			u.setEmail("tjddk -" + i);
			u.setRegdate(LocalDateTime.now());
			u.setCnt(null);
			
			this.usersRepository.save(u);
			
		}
	}
	

}
