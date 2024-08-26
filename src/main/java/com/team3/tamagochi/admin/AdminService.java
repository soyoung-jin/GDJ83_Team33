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
	
	public int updateUserDetail(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.updateUserDetail(usersDTO);
	}
	
	public int updateUserResign(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.updateUserResign(usersDTO);
	}
	
	public List<TransactionDTO> getUserTradeList(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.getUserTradeList(usersDTO);
	}
	
	public SalesDTO getSales()throws Exception{
		
		return adminDAO.getSales();
	}
}
