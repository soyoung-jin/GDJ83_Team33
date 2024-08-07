package com.team3.tamagochi.mypet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.users.UsersDTO;

@Service
public class MyPetService {
	
	@Autowired
	private MyPetDAO myPetDAO;
	
	
	public List<MyPetDTO> getList(UsersDTO usersDTO) throws Exception{
		
		return myPetDAO.getList(usersDTO);
	}
	
	public MyPetDTO getDetail(MyPetDTO myPetDTO) throws Exception{
		
		return myPetDAO.getDetail(myPetDTO);
	}
	
	public int updatePetName(MyPetDTO myPetDTO) throws Exception{
		
		return myPetDAO.updatePetName(myPetDTO);
	}

}
