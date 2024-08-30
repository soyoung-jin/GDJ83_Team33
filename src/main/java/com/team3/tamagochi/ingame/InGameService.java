package com.team3.tamagochi.ingame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.record.RecordDTO;
import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.users.InventoryDTO;
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
	
	// 진화
	public int evolutionUp(MyPetDTO myPetDTO) throws Exception {
		return inGameDAO.evolutionUp(myPetDTO);
	}
	
	// 인벤토리 테이블에서 아이템번호 찾아오기
	public ItemDTO getItemNumForWeapon(InventoryDTO inventoryDTO) throws Exception {
		return inGameDAO.getItemNumForWeapon(inventoryDTO);
	}
	
	// 전투 결과 삽입
	public int fightResult(RecordDTO recordDTO) throws Exception {
		return inGameDAO.fightResult(recordDTO);
	}
	
	// 전투 결과 조회
	public RecordDTO fightScore(RecordDTO recordDTO) throws Exception {
		return inGameDAO.fightScore(recordDTO);
	}
	
	public List<RecordDTO> getFightList(RecordDTO recordDTO) throws Exception{
		return inGameDAO.getFightList(recordDTO);
	}
}
