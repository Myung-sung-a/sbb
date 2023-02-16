package com.mysite.sbb.user;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

import lombok.Getter;

@Getter
public enum UserRole {
	
	Admin("ROLE_ADMIN"),
	
	USER("ROLE_USER");
	
	UserRole(String value){
		
		this.value = value;
	}
	
	private String value;

}
