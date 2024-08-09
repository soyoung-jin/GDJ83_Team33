package com.team3.tamagochi.ingame;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/ingame/*")
public class InGameController {
	
	@Autowired
	private InGameService inGameService;
	
	//<====================펫 정보======================>
	@GetMapping("ingame")
	public void getPetStatus(MyPetDTO myPetDTO, Model model, HttpSession session) throws Exception {
		UsersDTO tempDTO = (UsersDTO) session.getAttribute("users_info");
		myPetDTO.setUser_id(tempDTO.getUser_id());
		myPetDTO.setItem_num(4L);
		myPetDTO = inGameService.getPetStatus(myPetDTO);
		
		model.addAttribute("myPetDTO", myPetDTO);
		
	}
	
	//<====================펫 행동======================>
	//1. 밥
	@GetMapping("feed")
	@ResponseBody
	public MyPetDTO feedPet(Model model, MyPetDTO myPetDTO, HttpSession session) throws Exception {
		myPetDTO = (MyPetDTO) session.getAttribute("users_info");
		int result = inGameService.feedPet(myPetDTO);
		myPetDTO.setItem_num(4L);
		//펫 상태 다시 불러오기
		myPetDTO =inGameService.getPetStatus(myPetDTO);
		model.addAttribute("msg", result);
		return myPetDTO;
	}
	
	//2. 산책
	@GetMapping("stroll")
	@ResponseBody
	public MyPetDTO strollPet(Model model, MyPetDTO myPetDTO, HttpSession session) throws Exception {
		myPetDTO = (MyPetDTO) session.getAttribute("users_info");
		int result = inGameService.strollPet(myPetDTO);
		myPetDTO.setItem_num(4L);
		//펫 상태 다시 불러오기
		myPetDTO =inGameService.getPetStatus(myPetDTO);
		model.addAttribute("msg", result);
		return myPetDTO;
	}
	
	//3. 청소
	@GetMapping("clean")
	@ResponseBody
	public MyPetDTO cleanPet(Model model, MyPetDTO myPetDTO, HttpSession session) throws Exception {
		myPetDTO = (MyPetDTO) session.getAttribute("users_info");
		int result = inGameService.cleanPet(myPetDTO);
		myPetDTO.setItem_num(4L);
		
		//펫 상태 다시 불러오기
		myPetDTO = inGameService.getPetStatus(myPetDTO);
		model.addAttribute("msg", result);
		return myPetDTO;
	}
	
	
	
	
}
