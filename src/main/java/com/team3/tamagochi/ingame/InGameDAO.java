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
	
	public MyPetDTO getPetStatus(UsersDTO userDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getPetStatus", userDTO);
	}
	
	public int feedPet(UsersDTO usersDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "feedPet", usersDTO);
	}
	
}
