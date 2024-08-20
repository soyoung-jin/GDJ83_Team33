package com.team3.tamagochi.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.users.UsersDTO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.team3.tamagochi.admin.AdminDAO.";
	
	// 전체 유저 목록을 조회하는 메서드
	public List<UsersDTO> getUserList()throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getUserList");
	}
	
	// 선택한 유저 상세 정보 조회 메서드
	public UsersDTO getUserDetail(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getUserDetail", usersDTO);
	}
}
