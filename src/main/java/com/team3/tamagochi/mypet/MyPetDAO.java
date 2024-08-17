package com.team3.tamagochi.mypet;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.users.UsersDTO;

@Repository
public class MyPetDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESAPCE = "com.team3.tamagochi.mypet.MyPetDAO.";
	
	
	public List<MyPetDTO> getList(UsersDTO usersDTO)throws Exception{
	
		return sqlSession.selectList(NAMESAPCE + "getList", usersDTO);
	}
	
	public MyPetDTO getDetail(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESAPCE + "getDetail", myPetDTO);
	}
	
	public int updatePetName(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.update(NAMESAPCE + "updatePetName", myPetDTO);
	}
	
	// 캐릭터 선택 메서드
	// 1. 해당 유저의 캐릭터 selected값을 전부 0으로 만든다
	public int selectReset(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESAPCE + "selectReset", usersDTO);
	}
	
	// 2. 선택한 캐릭터의 selected값을 1로 만든다
	public int selectMyPet(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.update(NAMESAPCE + "selectMyPet", myPetDTO);
	}

}
