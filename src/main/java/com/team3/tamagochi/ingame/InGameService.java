package com.team3.tamagochi.ingame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class InGameService {
	
	@Autowired
	private InGameDAO inGameDAO;
	
	// 인게임 초입
	public MyPetDTO getPetStatus(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.getPetStatus(myPetDTO);
	}
	
	// 버튼 이벤트시 펫 정보 다시 가져오기
	public MyPetDTO checkPetStatus(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.checkPetStatus(myPetDTO);
	}
	
	// 먹이주기
	public int feedPet(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.feedPet(myPetDTO);
	}
	
	// 산책하기
	public int strollPet(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.strollPet(myPetDTO);
	}
	
	// 청소하기
	public int cleanPet(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.cleanPet(myPetDTO);
	}
	
	// 경험치 가져오기
	public Long getPetExp(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.getPetExp(myPetDTO);
	}
	
	// 레벨업
	public int levelUp(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.levelUp(myPetDTO);
	}
}
