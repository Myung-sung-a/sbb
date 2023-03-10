package com.mysite.sbb2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class HelloLombok5 {
	
	private final String hello;		// 필드 : private
	private  int lombok;			// 필드
	

	public static void main(String[] args) {
		
		HelloLombok5 lombok = new HelloLombok5("성아성아");
		
		lombok.setLombok(5);
		System.out.println(lombok.getHello());
		System.out.println(lombok.getLombok());
		
		System.out.println(lombok);

	}

}
