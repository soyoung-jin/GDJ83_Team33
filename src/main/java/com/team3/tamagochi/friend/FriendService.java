package com.team3.tamagochi.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.users.UsersDTO;

@Service
public class FriendService {
	
	@Autowired
	private FriendDAO friendDAO;
	
	public UsersDTO getFriendList(UsersDTO usersDTO) throws Exception{
		return friendDAO.getFriendList(usersDTO);
	}
	
	public UsersDTO getFriendDetail(FriendDTO friendDTO) throws Exception{
		return friendDAO.getFriendDetail(friendDTO);
	}
	
	public int deleteFriend(FriendDTO friendDTO) throws Exception{
		return friendDAO.deleteFriend(friendDTO);
	}
	
}
