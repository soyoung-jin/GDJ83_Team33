package com.team3.tamagochi.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.boards.BoardDAO;
import com.team3.tamagochi.boards.BoardDTO;
import com.team3.tamagochi.boards.BoardService;
import com.team3.tamagochi.boards.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		// 1. rownum 계산
		pager.makerow();
		// 2. pageing 계산
		pager.makeNum(boardDAO.getTotalCount(pager));
		return boardDAO.list(pager);
	}

}
