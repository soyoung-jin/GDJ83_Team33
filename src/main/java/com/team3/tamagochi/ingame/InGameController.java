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
	
	@GetMapping("fight")
	public void fight() throws Exception {
		
		
	}
	
	//<====================펫 정보======================>
	@GetMapping("ingame")
	public void getPetStatus(MyPetDTO myPetDTO, Model model, HttpSession session) throws Exception {
		UsersDTO tempDTO = (UsersDTO) session.getAttribute("users_info");
		myPetDTO.setUser_id(tempDTO.getUser_id());
		myPetDTO = inGameService.getPetStatus(myPetDTO);
		model.addAttribute("myPetDTO", myPetDTO);
		
	}
	
	//<====================펫 경험치 가져오기, 펫 체크 다시 불러오기======================>
	@GetMapping("checkPetStatus")
	@ResponseBody
	public MyPetDTO getPetExp(MyPetDTO myPetDTO, Model model) throws Exception {
		myPetDTO = inGameService.checkPetStatus(myPetDTO);
		
		return myPetDTO;
	}
	
	
	
	//<====================펫 행동, 펫 체크 다시 불러오기======================>
	//1. 밥
	@GetMapping("feed")
	@ResponseBody
	public MyPetDTO feedPet(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.feedPet(myPetDTO);
		//펫 상태 다시 불러오기
		myPetDTO =inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
	}
	
	//2. 산책
	@GetMapping("stroll")
	@ResponseBody
	public MyPetDTO strollPet(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.strollPet(myPetDTO);
		//펫 상태 다시 불러오기
		myPetDTO =inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
	}
	
	//3. 청소
	@GetMapping("clean")
	@ResponseBody
	public MyPetDTO cleanPet(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.cleanPet(myPetDTO);
		//펫 상태 다시 불러오기
		myPetDTO = inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
	}
	
	
	//<====================펫 진화======================>
	@GetMapping("levelUp")
	@ResponseBody
	public MyPetDTO levelUp(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.levelUp(myPetDTO);
		myPetDTO = inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
		
	}
	
	
	
	
}
