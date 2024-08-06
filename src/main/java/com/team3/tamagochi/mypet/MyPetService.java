package com.team3.tamagochi.mypet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPetService {
	
	@Autowired
	private MyPetDAO myPetDAO;
	
	
	public List<MyPetDTO> getList() throws Exception{
		
		return myPetDAO.getList();
	}

}
