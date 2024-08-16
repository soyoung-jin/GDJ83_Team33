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
	
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",noticeDTO);
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail",noticeDTO);
	}
	
	public void hit(NoticeDTO noticeDTO) throws Exception {
		sqlSession.update(NAMESPACE + "hit", noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);

	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);

	}

}
