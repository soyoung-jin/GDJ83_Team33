package com.team3.tamagochi.mypet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/mypet/*")
public class MyPetController {
	
	@Autowired
	private MyPetService myPetService;
	
	
	// 내가 보유하고 있는 캐릭터 목록을 보여주는 메서드
	@GetMapping("mypetList")
	public void getList(Model model, HttpSession session) throws Exception{
		
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		
		List<MyPetDTO> list = myPetService.getList(usersDTO);
		
		model.addAttribute("list", list);
	}
	
	// 캐릭터의 상세정보를 보여주는 메서드
	@GetMapping("petDetail")
	public void getDetail(MyPetDTO myPetDTO, Model model, HttpSession session) throws Exception{
		
		myPetDTO = myPetService.getDetail(myPetDTO);
		
		model.addAttribute("myPetDTO", myPetDTO);
		
		// detail 페이지에서 select바로 내가 가진 캐릭터 목록을 보여주는 코드
		// 위에서 만들어둔 getList 메서드를 호출해서 내가 보유하고 있는 캐릭터 list를 가져옴
		this.getList(model, session);
	}
	
	// 캐릭터 이름을 수정하는 메서드
	@PostMapping("updateName")
	public String updatePetName(MyPetDTO myPetDTO, Model model) throws Exception{
		
		int result = myPetService.updatePetName(myPetDTO);
		
		if(result > 0) {
			model.addAttribute("result", "이름이 변경되었습니다.");
			model.addAttribute("url", "/mypet/petDetail?pet_num=" + myPetDTO.getPet_num());
		}else {
			model.addAttribute("result", "이름 수정 실패!");
			model.addAttribute("url", "/mypet/petDetail?pet_num=" + myPetDTO.getPet_num());
		}
		
		return "commons/message";
		
	}
	
	// 게임에 사용할 캐릭터를 선택하는 메서드
	@GetMapping("select")
	public String selectMyPet(MyPetDTO myPetDTO, Model model, HttpSession session) throws Exception{
		
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		
		int result = myPetService.selectMyPet(usersDTO, myPetDTO);
		
		if(result > 0) {
			model.addAttribute("msg", result);
		}
		
		return "commons/result";
	}

}
