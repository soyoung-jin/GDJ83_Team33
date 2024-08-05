package com.team3.tamagochi.boards;

import java.util.List;

import com.team3.tamagochi.boards.util.Pager;

public interface BoardService {

	public abstract List<BoardDTO> list(Pager pager) throws Exception;

//	// add
//	public int add(BoardDTO boardDTO, HttpSession session) throws Exception;
//
//	// update
//	public int update(BoardDTO boardDTO) throws Exception;
//
//	// delete
//	public int delete(BoardDTO boardDTO) throws Exception;
//
//	// detail
//	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
}
