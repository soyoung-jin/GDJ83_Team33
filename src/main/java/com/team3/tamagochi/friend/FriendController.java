package com.team3.tamagochi.friend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/friend/*")
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	@GetMapping("friendList")
	public void getFriendList(UsersDTO usersDTO, Model model, HttpSession session) throws Exception{
		usersDTO = (UsersDTO) session.getAttribute("users_info");
		
		usersDTO = friendService.getFriendList(usersDTO);
		
		model.addAttribute("usersDTO", usersDTO);
		
	}
	
	@GetMapping("friendDetail")
	public void	getFriendDetail(FriendDTO friendDTO, Model model, HttpSession session) throws Exception{
		UsersDTO friendInfoDTO = friendService.getFriendDetail(friendDTO);
		model.addAttribute("friendInfoDTO", friendInfoDTO);
		UsersDTO myDTO = (UsersDTO) session.getAttribute("users_info");
		model.addAttribute("myDTO", myDTO);
	}
	
	@GetMapping("deleteFriend")
	public String deleteFriend(FriendDTO friendDTO, Model model) throws Exception{
		int result = friendService.deleteFriend(friendDTO);
		
		if(result>0) {
			model.addAttribute("result", "친구를 끊었습니다.");
			model .addAttribute("url", "./friendList");
		} else {
			model.addAttribute("result", "오류발생.");
			model .addAttribute("url", "./friendList");
		}
		return "commons/message";
	}
	
}
