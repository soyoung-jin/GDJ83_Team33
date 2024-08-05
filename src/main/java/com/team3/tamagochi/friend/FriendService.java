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
	
}
