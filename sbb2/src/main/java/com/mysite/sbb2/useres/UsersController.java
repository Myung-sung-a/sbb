package com.mysite.sbb2.useres;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;






import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsersController {
	
	private final UsersService usersService;
	
	//@GetMapping("/users/list")
	//@PostMapping("/users/list")
	//public String list(Model model) {
		
		//List<Users> usersList =
				//this.usersService.getList();
		
		//model.addAttribute("usersList", usersList);
		
		//return "users_list";
	//}
	
	@GetMapping("/users/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		
		// 비즈니스 로직 처리 : 
				Page<Users> paging =
					this.usersService.getList(page);
				
				// model 객체에 결과로 받은 paging 객체를 client 로 전송
				model.addAttribute("paging", paging);
				
				return "users_list";
		
	}
	
	@GetMapping("/users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx) {
		
		Users u =
				this.usersService.getUsers(idx);
			
			model.addAttribute("users", u);
		
		return "users_detail";
	}
	
	 //create 페이지
	   @GetMapping("/users/create")
	   public String usersCreate(UsersForm usersForm) {
	      return "users_form";
	   }
	   
	   @PostMapping("/users/create")
	   public String usersCreate(
	         
	         @Valid UsersForm usersForm, BindingResult bingResult)
	   {
	      if (bingResult.hasErrors()) {
	         return "users_form";
	      }
	      
	      
	      this.usersService.create(usersForm.getName(), usersForm.getPass(), usersForm.getEmail());
	      
	      return "redirect:/users/list";
	   }
	   

	
	
	

}
