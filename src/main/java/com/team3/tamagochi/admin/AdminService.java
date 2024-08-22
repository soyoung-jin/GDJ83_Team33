package com.team3.tamagochi.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	
	public List<UsersDTO> getUserList() throws Exception{
		
		return adminDAO.getUserList();
	}
	
	public UsersDTO getUserDetail(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.getUserDetail(usersDTO);
	}
	
	public List<TransactionDTO> getUserTradeList(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.getUserTradeList(usersDTO);
	}
}
