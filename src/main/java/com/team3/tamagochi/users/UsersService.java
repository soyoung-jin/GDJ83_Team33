package com.team3.tamagochi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	
	public int registerUsers(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.registerUsers(usersDTO);
	}
	

}
