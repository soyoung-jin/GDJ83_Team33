package com.team3.tamagochi.boards;

import java.util.List;

import com.team3.tamagochi.boards.util.Pager;

public interface BoardDAO {
	// NoticeDAO, QnaDAO

	// totalCount
	public Long getTotalCount(Pager pager) throws Exception;

	// list
	public abstract List<BoardDTO> list(Pager pager) throws Exception;

//	// add
//	public int add(BoardDTO boardDTO) throws Exception;
//
//	// update
//	int update(BoardDTO boardDTO) throws Exception;
//
//	// delete
//	int delete(BoardDTO boardDTO) throws Exception;
//
//	// detail
//	BoardDTO detail(BoardDTO boardDTO) throws Exception;

}
