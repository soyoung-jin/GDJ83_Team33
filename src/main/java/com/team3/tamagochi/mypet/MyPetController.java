package com.team3.tamagochi.mypet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/mypet/*")
public class MyPetController {
	
	@Autowired
	private MyPetService myPetService;
	
	
	@GetMapping("mypetList")
	public void getList(Model model, HttpSession session) throws Exception{
		
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		
		List<MyPetDTO> list = myPetService.getList(usersDTO);
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("petDetail")
	public void getDetail(MyPetDTO myPetDTO, Model model, HttpSession session) throws Exception{
		
		myPetDTO = myPetService.getDetail(myPetDTO);
		
		model.addAttribute("myPetDTO", myPetDTO);
		
		// detail 페이지에서 select바로 내가 가진 캐릭터 목록을 보여주는 코드
		// 위에서 만들어둔 getList 메서드를 호출해서 내가 보유하고 있는 캐릭터 list를 가져옴
		this.getList(model, session);
	}

}
