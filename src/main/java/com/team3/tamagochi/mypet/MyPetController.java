package com.team3.tamagochi.mypet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypet/*")
public class MyPetController {
	
	@Autowired
	private MyPetService myPetService;
	
	
	@GetMapping("mypetList")
	public void getList(Model model) throws Exception{
		
		List<MyPetDTO> list = myPetService.getList();
		
		model.addAttribute("list", list);
	}

}
