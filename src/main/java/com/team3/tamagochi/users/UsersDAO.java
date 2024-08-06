package com.team3.tamagochi.users;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.team3.tamagochi.users.UsersDAO.";
	
	
	// 회원가입 메서드
	public int registerUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "registerUsers", usersDTO);		
	}
	
	// 로그인 메서드
	public UsersDTO loginUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "loginUsers", usersDTO);
	}
	
	// 회원정보 수정 메서드
	public int updateUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateUsers", usersDTO);
	}
	
	// 회원 탈퇴 메서드(데이터는 남아있으나 resign값을 0으로 만들어 더이상 로그인 하지 못하게 만듬)
	public int deleteAccount(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "deleteAccount", usersDTO);
	}
}
