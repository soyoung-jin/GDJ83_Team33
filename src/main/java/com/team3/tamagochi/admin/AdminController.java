package com.team3.tamagochi.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	
	@GetMapping("adminMain")
	public void getAdminMain(Model model) throws Exception{
		
		List<UsersDTO> list = adminService.getUserList();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("userDetail")
	public void getUserDetail(Model model, UsersDTO usersDTO) throws Exception{
		
		usersDTO = adminService.getUserDetail(usersDTO);
		
		model.addAttribute("usersDTO", usersDTO);
	}
}
