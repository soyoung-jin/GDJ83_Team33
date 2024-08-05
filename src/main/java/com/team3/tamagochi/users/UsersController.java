package com.team3.tamagochi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/*")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("register")
	public void registerUsers() throws Exception{
		
	}
	
	@PostMapping("register")
	public String registerUsers(UsersDTO usersDTO) throws Exception{
		
		int result = usersService.registerUsers(usersDTO);
		
		return "redirect:/";
	}

}
