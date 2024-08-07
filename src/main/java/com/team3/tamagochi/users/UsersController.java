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
	public void registerUsers() throws Exception{}
	
	@PostMapping("register")
	public String registerUsers(UsersDTO usersDTO, Model model) throws Exception{
		
		int result = usersService.registerUsers(usersDTO);
		
		if(result>0) {
			model.addAttribute("result", "회원가입 성공!");
			model.addAttribute("url", "/");
			
			// 회원가입시 디폴트 캐릭터 4개가 자동으로 생성되는 코드
			result = usersService.setDefaultCharacter(usersDTO);
		}
		
		return "commons/message";
	}
	
	
	@GetMapping("login")
	public void loginUsers() throws Exception{}
	
	@PostMapping("login")
	public String loginUsers(UsersDTO usersDTO, Model model, HttpSession session) throws Exception{
		
		usersDTO = usersService.loginUsers(usersDTO);
		
		// 탈퇴한 회원은 resign값이 0이기 때문에 이 값으로 탈퇴한 회원인지 아닌지 구분.
		if(usersDTO != null && usersDTO.getUser_resign() == 1) {
			session.setAttribute("users_info", usersDTO);
			model.addAttribute("result", "환영합니다!");
			model.addAttribute("url", "/");
		}else if(usersDTO != null && usersDTO.getUser_resign() == 0){
			model.addAttribute("result", "탈퇴한 회원입니다.");
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
		
		// 회원 정보 수정시, 로그인 정보가 session에 담겨있기 때문에 로그아웃을 했다가 다시 로그인해야 수정된 정보가 출력됨
		// updateUsersData라는 메서드를 만들어서 업데이트된 정보를 새로 호출함으로서 바로 보여줄 수 있게 만듬
		usersDTO = usersService.updateUsersData(usersDTO);
		
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
		
		return "commons/message";
	}
	
	
	@GetMapping("deleteAccount")
	public void deleteAccount() throws Exception{}
	
	@PostMapping("deleteAccount")
	public String deleteAccount(UsersDTO usersDTO, HttpSession session, Model model) throws Exception{
		
		// session에 담긴 로그인 id를 임시 DTO에 담아둔 뒤, 그걸 다시 꺼내서 입력받은 usersDTO에 넣는 코드
		// 입력받은 usersDTO에는 id값이 없기 때문에 이러한 과정을 거침
		UsersDTO tempDTO = (UsersDTO)session.getAttribute("users_info");
		usersDTO.setUser_id(tempDTO.getUser_id());
		
		int result = usersService.deleteAccount(usersDTO);
		
		if(result > 0) {
			model.addAttribute("result", "회원 탈퇴가 완료되었습니다. 감사합니다.");
			model.addAttribute("url", "/");
			session.invalidate();
		}else {
			model.addAttribute("result", "올바른 비밀번호를 입력해주세요.");
			model.addAttribute("url", "/users/deleteAccount");
		}
		
		return "commons/message";
	}
	
	
	@GetMapping("inventory")
	public void getInvenList() throws Exception{
		
	}

}
