package com.team3.tamagochi.userboard;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.notice.NoticeDTO;


@Repository
public class UserBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE ="com.team3.tamagochi.userboard.UserBoardDAO.";
	
	public List<UserBoardDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE + "list",pager);
	}
	
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount",pager);
		
	}
	
	public UserBoardDTO detail(UserBoardDTO userBoardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail",userBoardDTO);
	}
	
	public void hit(UserBoardDTO userBoardDTO) throws Exception {
		sqlSession.update(NAMESPACE + "hit", userBoardDTO);
	}
	
	public int add(UserBoardDTO userBoardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", userBoardDTO);
	}
	
	public int update(UserBoardDTO userBoardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", userBoardDTO);

	}
	
	public int delete(UserBoardDTO userBoardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", userBoardDTO);

	}
	
	public int reply(UserBoardDTO userBoardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", userBoardDTO);
	}

	public int replyUpdate(UserBoardDTO userBoardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "replyUpdate", userBoardDTO);
	}

}