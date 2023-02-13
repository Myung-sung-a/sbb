package com.mysite.sbb2.useres;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsersController {
	
	private final UsersService usersService;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	public String list(Model model) {
		
		List<Users> usersList =
				this.usersService.getList();
		
		model.addAttribute("usersList", usersList);
		
		return "users_list";
	}
	
	@GetMapping("/users/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		Users u =
				this.usersService.getUsers(id);
			
			model.addAttribute("users", u);
		
		return "users_detail";
	}
	

}