package com.team3.tamagochi.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/*")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("list")
	public void getList(UsersDTO usersDTO, Model model) throws Exception{
		
		List<UsersDTO> list = usersService.getList(usersDTO);
		
		model.addAttribute("list", list);
	}

}
