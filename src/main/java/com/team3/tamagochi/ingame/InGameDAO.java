package com.team3.tamagochi.ingame;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.UsersDTO;

@Repository
public class InGameDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.ingame.InGameDAO.";
	
	// 인게임 초입
	public MyPetDTO getPetStatus(MyPetDTO myPetDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getPetStatus", myPetDTO);
	}
	
	// 버튼 이벤트시 펫 정보 다시 가져오기
	public MyPetDTO checkPetStatus(MyPetDTO myPetDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "checkPetStatus", myPetDTO);
	}
	
	// 먹이주기
	public int feedPet(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "feedPet", myPetDTO);
	}
	
	// 산책하기
	public int strollPet(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "strollPet", myPetDTO);
	}
	
	// 청소하기
	public int cleanPet(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "cleanPet", myPetDTO);
	}
	
	// 경험치 가져오기
	public Long getPetExp(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getPetExp", myPetDTO);
	}
	
	// 레벨업
	public int levelUp(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "levelUp", myPetDTO);
	}
	
	// 진화
	public int evolutionUp(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "evolutionUp", myPetDTO);
	}
	
	
	
}
