package com.team3.tamagochi.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.boards.BoardDAO;
import com.team3.tamagochi.boards.BoardDTO;
import com.team3.tamagochi.boards.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.boards.notice.NoticeDAO.";

	// List start
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}
	// List end

	// getTotal start
	@Override
	public Long getTotalCount(Pager pager) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

}
