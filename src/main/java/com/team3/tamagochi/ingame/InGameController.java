package com.team3.tamagochi.ingame;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/ingame/*")
public class InGameController {
	
	@Autowired
	private InGameService inGameService;
	
	@GetMapping("ingame")
	public void getPetStatus(UsersDTO usersDTO, Model model, HttpSession session) throws Exception {
		usersDTO = (UsersDTO) session.getAttribute("users_info");
		
		MyPetDTO myPetDTO = inGameService.getPetStatus(usersDTO);
		
		model.addAttribute("myPetDTO", myPetDTO);
		
		if(myPetDTO == null) {
			
		}
	}
	
	@GetMapping("feed")
	public String feedPet(Model model, UsersDTO usersDTO, HttpSession session) throws Exception {
		usersDTO = (UsersDTO) session.getAttribute("users_info");
		int result = inGameService.feedPet(usersDTO);
		model.addAttribute("msg", result);
		return "commons/result";
	}
	
	@GetMapping("stroll")
	public String strollPet(Model model, UsersDTO usersDTO, HttpSession session) throws Exception {
		usersDTO = (UsersDTO) session.getAttribute("users_info");
		int result = inGameService.strollPet(usersDTO);
		model.addAttribute("msg", result);
		return "commons/result";
	}
	
	@GetMapping("clean")
	public String cleanPet(Model model, UsersDTO usersDTO, HttpSession session) throws Exception {
		usersDTO = (UsersDTO) session.getAttribute("users_info");
		int result = inGameService.cleanPet(usersDTO);
		model.addAttribute("msg", result);
		return "commons/result";
	}
	
	
	
}
