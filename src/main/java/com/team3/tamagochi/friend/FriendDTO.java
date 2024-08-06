package com.team3.tamagochi.friend;

import java.util.List;

import com.team3.tamagochi.users.UsersDTO;

public class FriendDTO {
	private Long friend_num;
	private String user_id;
	private String friend_id;
	

	
	public Long getFriend_num() {
		return friend_num;
	}
	public void setFriend_num(Long friend_num) {
		this.friend_num = friend_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}
	
	
}
