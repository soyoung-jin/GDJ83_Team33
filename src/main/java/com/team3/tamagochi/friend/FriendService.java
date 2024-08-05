package com.team3.tamagochi.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.users.UsersDTO;

@Service
public class FriendService {
	
	@Autowired
	private FriendDAO friendDAO;
	
	public List<FriendDTO> getFriendList(UsersDTO usersDTO) {
		return friendDAO.getFriendList(usersDTO);
	}
	
	public FriendDTO getFriendDetail(FriendDTO friendDTO) {
		return friendDAO.getFriendDetail(friendDTO);
	}
	
	public int deleteFriend(FriendDTO friendDTO) {
		return friendDAO.deleteFriend(friendDTO);
	}
	
}
