package com.team3.tamagochi.friend;

import java.util.List;

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
	
	@GetMapping("getFriendList")
	public void getFriendList(UsersDTO userDTO, Model model) {
		List<FriendDTO> list = friendService.getFriendList(userDTO);
	}
	
}
