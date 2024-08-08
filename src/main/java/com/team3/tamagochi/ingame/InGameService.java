package com.team3.tamagochi.ingame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class InGameService {
	
	@Autowired
	private InGameDAO inGameDAO;
	
	public MyPetDTO getPetStatus(UsersDTO usersDTO) throws Exception {
		return inGameDAO.getPetStatus(usersDTO);
	}
	
	public int feedPet(UsersDTO usersDTO) throws Exception {
		return inGameDAO.feedPet(usersDTO);
	}
	
	public int strollPet(UsersDTO usersDTO) throws Exception {
		return inGameDAO.strollPet(usersDTO);
	}
	
	public int cleanPet(UsersDTO usersDTO) throws Exception {
		return inGameDAO.cleanPet(usersDTO);
	}
}
