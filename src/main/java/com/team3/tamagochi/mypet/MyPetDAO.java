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

}
