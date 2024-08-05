package com.team3.tamagochi.users;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.team3.tamagochi.users.UsersDAO.";
	
	
	public int registerUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "registerUsers", usersDTO);		
	}
}
