package com.mysite.sbb2.useres;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	//public List<Users> getList(){
		//return this.usersRepository.findAll();
	//}
	
	// Controller 에서 getList 메소드 호출 시 출력할 page 번호를 매개변수로 받음. : 0, 1, 2, 3
		public Page<Users> getList(int page){
			
			// 최신글을 먼저 출력하기, 날짜 컬럼 (createDate)을 desc해서 출력
			List<Sort.Order> sorts = new ArrayList();
			sorts.add(Sort.Order.desc("regdate"));
			
			
			// Pageable 객체에 2개의 값을 담아서 매개변수로 던짐, 10 <== 출력할 레코드 수
			Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
			
			return this.usersRepository.findAll(pageable);
		}
	
	public Users getUsers(Integer idx) {
		
		Optional<Users> op = this.usersRepository.findById(idx);
		if(op.isPresent()) {
			return op.get();
		}else {
			throw new DataNotFoundException("요청한 파일을 찾지 못했습니다.");
		}
	}
	
	public void create(String name, String pass, String email) {
	      Users u = new Users();
	      u.setName(name);
	      u.setPass(pass);
	      u.setEmail(email);
	      
	      this.usersRepository.save(u);
	   
	   }

}
