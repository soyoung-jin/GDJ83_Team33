package com.team3.tamagochi.mypet;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPetDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESAPCE = "com.team3.tamagochi.mypet.MyPetDAO.";
	
	
	public List<MyPetDTO> getList()throws Exception{
	
		return sqlSession.selectList(NAMESAPCE + "getList");
	}

}
