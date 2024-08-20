package com.team3.tamagochi.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.notice.NoticeDTO;


@Repository
public class QnaDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE ="com.team3.tamagochi.qna.QnaDAO.";
	
	public List<QnaDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE + "list",pager);
	}
	
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount",pager);
		
	}
	
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail",qnaDTO);
	}
	
	public void hit(QnaDTO qnaDTO) throws Exception {
		sqlSession.update(NAMESPACE + "hit", qnaDTO);
	}
	
	public int add(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", qnaDTO);
	}
	
	public int update(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", qnaDTO);

	}
	
	public int delete(QnaDTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", qnaDTO);

	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}

	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "replyUpdate", qnaDTO);
	}

}