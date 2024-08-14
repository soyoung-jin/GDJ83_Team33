package com.team3.tamagochi.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE ="com.team3.tamagochi.notice.NoticeDAO.";
	
	public List<NoticeDTO> list() throws Exception{
		return sqlSession.selectList(NAMESPACE + "list");
	}
	
	public int add(NoticeDTO noticeDTO) {
		return sqlSession.insert(NAMESPACE+"add",noticeDTO);
	}

}
