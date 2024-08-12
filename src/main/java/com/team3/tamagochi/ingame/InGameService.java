package com.team3.tamagochi.ingame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class InGameService {
	
	@Autowired
	private InGameDAO inGameDAO;
	
	public MyPetDTO getPetStatus(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.getPetStatus(myPetDTO);
	}
	
	public int feedPet(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.feedPet(myPetDTO);
	}
	
	public int strollPet(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.strollPet(myPetDTO);
	}
	
	public int cleanPet(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.cleanPet(myPetDTO);
	}
	
	public Long getPetExp(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.getPetExp(myPetDTO);
	}
}
