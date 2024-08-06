package com.team3.tamagochi.users;

import javax.servlet.http.HttpSession;

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
	public String registerUsers(UsersDTO usersDTO, Model model) throws Exception{
		
		int result = usersService.registerUsers(usersDTO);
		
		if(result>0) {
			model.addAttribute("result", "회원가입 성공!");
			model.addAttribute("url", "/");	
		}
		
		return "commons/message";
	}
	
	@GetMapping("login")
	public void loginUsers() throws Exception{
		
	}
	
	@PostMapping("login")
	public String loginUsers(UsersDTO usersDTO, Model model, HttpSession session) throws Exception{
		
		usersDTO = usersService.loginUsers(usersDTO);
		
		if(usersDTO != null) {
			session.setAttribute("users_info", usersDTO);
			model.addAttribute("result", "로그인 성공!");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("result", "로그인 실패!");
			model.addAttribute("url", "/");
		}
		
		return "commons/message";
	}
	
	@GetMapping("logout")
	public String logoutUsers(HttpSession session) throws Exception{	
		
		session.invalidate(); // session의 유지시간을 0으로 만들어서 로그아웃 상태로 만듬
		
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public void getMyPage(HttpSession session, Model model) throws Exception{
		
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		
		model.addAttribute("usersDTO", usersDTO);
		
	}
	
	@PostMapping("update")
	public String updateUsers(Model model, UsersDTO usersDTO) throws Exception{
					
		int result = usersService.updateUsers(usersDTO);
		
		if(result > 0) {
			model.addAttribute("result", "수정 성공!");
			model.addAttribute("url", "/users/mypage");
		}else {
			model.addAttribute("result", "수정 실패!!");
			model.addAttribute("url", "/users/mypage");
		}
		// update후에 mypage가 바로 최신화 되도록 수정해야 됨
		// 현재는 로그아웃 후 다시 로그인해야 mypage 정보가 바뀜
		// service딴에서 detail 메서드를 만들어서 호출하는 식으로 사용하면 되는듯 함
		return "commons/message";
	}

}
