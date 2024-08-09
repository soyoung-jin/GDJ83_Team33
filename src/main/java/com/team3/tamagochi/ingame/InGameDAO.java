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
	
	public MyPetDTO getPetStatus(MyPetDTO myPetDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getPetStatus", myPetDTO);
	}
	
	public int feedPet(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "feedPet", myPetDTO);
	}
	
	public int strollPet(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "strollPet", myPetDTO);
	}
	
	public int cleanPet(MyPetDTO myPetDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "cleanPet", myPetDTO);
	}
	
	
	
}
