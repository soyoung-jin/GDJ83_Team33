package com.team3.tamagochi.friend;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.users.UsersDTO;

@Repository
public class FriendDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.friend.FriendDAO.";
	
	public List<FriendDTO> getFriendList(UsersDTO usersDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE + "getFriendList", usersDTO);
	}
	
	public UsersDTO getFriendDetail(FriendDTO friendDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getFriendDetail", friendDTO);
	}
	
	public int deleteFriend(FriendDTO friendDTO) throws Exception{
		return sqlSession.delete(NAMESPACE + "deleteFriend", friendDTO);
	}
	
}
