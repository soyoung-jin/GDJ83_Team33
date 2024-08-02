package com.team3.tamagochi.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	
	public List<UsersDTO> getList(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.getList(usersDTO);
		
	}

}
