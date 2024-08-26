package com.team3.tamagochi.friend;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.WebSocketSession;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.users.InventoryDTO;
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
		
		List<ItemDTO> inventoryList  = friendService.getInvenList(myDTO);
		
		model.addAttribute("inventoryList", inventoryList);
	}
	
	@GetMapping("sendGift")
	public String getInvenList(InventoryDTO inventoryDTO, HttpSession session, Model model) throws Exception {
		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		InventoryDTO userInventoryDTO = new InventoryDTO();
		userInventoryDTO.setUser_id(usersDTO.getUser_id());
		userInventoryDTO.setItem_num(inventoryDTO.getItem_num());
		int result = friendService.takeGift(inventoryDTO);
		
		result = friendService.sendGift(userInventoryDTO);
		if(result > 0) {
			model.addAttribute("result", "선물을 보냈습니다");
			model .addAttribute("url", "./friendList");
		}else {
			model.addAttribute("result", "오류발생.");
			model .addAttribute("url", "./friendList");
		}
		return "commons/message";
	}
	
	@GetMapping("makeFriend")
	public String addFriend(FriendDTO friendDTO, Model model, HttpSession session, MyPetDTO myPetDTO) throws Exception {
		// friend to user(친구가 유저를 추가)
		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		
		friendDTO.setFriend_id(usersDTO.getUser_id());
		int result = friendService.makeFriends(friendDTO);
		
		// user to friend(유저가 친구를 추가)
		FriendDTO friendDTOReversed = new FriendDTO();
		friendDTOReversed.setUser_id(usersDTO.getUser_id());
		friendDTOReversed.setFriend_id(friendDTO.getUser_id());
		result = friendService.makeFriends(friendDTOReversed);
		
		// 친구 불러오기
		//usersDTO = friendService.getFriendList(usersDTO);
		
		model.addAttribute("result", "친구가 되었어요");
		model.addAttribute("url", "/rank/rankDetail?pet_num=" + myPetDTO.getPet_num());
		return "commons/message";
	}
	
	@GetMapping("deleteFriend")
	public String deleteFriend(FriendDTO friendDTO, Model model, HttpSession session) throws Exception{
		// 친구가 유저를 삭제
		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		friendDTO.setFriend_id(usersDTO.getUser_id());
		int result = friendService.deleteFriend(friendDTO);
		
		// 유저가 친구를 삭제
		FriendDTO friendDTOReversed = new FriendDTO();
		friendDTOReversed.setUser_id(usersDTO.getUser_id());
		friendDTOReversed.setFriend_id(friendDTO.getUser_id());
		result = friendService.deleteFriend(friendDTOReversed);
		
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
