package com.mysite.sbb;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class HelloLombok2 {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;

	
	public static void main(String[] args) {
		// 객체 생성 후 테스트
		HelloLombok2 lombok = new HelloLombok2();
		
		// setter를 사용해서 값을 입력
		lombok.setSeq(1);
		lombok.setTitle("성아");
		lombok.setWriter("명성아");
		lombok.setContent("해피히포");
		lombok.setRegdate(null);
		lombok.setCnt(1);
		
		// getter를 사용해서 값을 출력
		System.out.println(lombok.getSeq());
		System.out.println(lombok.getTitle());
		System.out.println(lombok.getWriter());
		System.out.println(lombok.getContent());
		System.out.println(lombok.getRegdate());
		System.out.println(lombok.getCnt());
		
		// toString() 메소드 호출
		System.out.println(lombok);
	

	}

}
