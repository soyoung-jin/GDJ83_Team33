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
	
	// 캐릭터 선택 메서드
	public int selectMyPet(UsersDTO usersDTO, MyPetDTO myPetDTO) throws Exception{
		
		int result = myPetDAO.selectReset(usersDTO); // 1. 해당 유저의 캐릭터 selected값을 전부 0으로 만든다
		
		if(result > 0) {
			result = myPetDAO.selectMyPet(myPetDTO); // 2. 선택한 캐릭터의 selected값을 1로 만든다
		}
		
		return result;
	}

}
