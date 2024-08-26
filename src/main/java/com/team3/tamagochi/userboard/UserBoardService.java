package com.team3.tamagochi.userboard;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.boards.util.Pager;


@Service
public class UserBoardService {
	@Autowired
	private UserBoardDAO userBoardDAO;
	
	public List<UserBoardDTO> list(Pager pager) throws Exception{
		pager.makerow();
		pager.makeNum(userBoardDAO.getTotalCount(pager));
		return userBoardDAO.list(pager);
		
	}
	
	public UserBoardDTO detail(UserBoardDTO userBoardDTO) throws Exception{
		return userBoardDAO.detail(userBoardDTO);
	}
	
	public void hit(UserBoardDTO userBoardDTO) throws Exception {
		userBoardDAO.hit(userBoardDTO);
	}
	
	public int add(UserBoardDTO userBoardDTO, HttpSession session) throws Exception{
		if(userBoardDTO.getUserboard_contents() == null) {
			userBoardDTO.setUserboard_contents("");
		}
		
		int result = userBoardDAO.add(userBoardDTO);
		
		return result;
	}
	
	public int update(UserBoardDTO userBoardDTO) throws Exception {
		return userBoardDAO.update(userBoardDTO);
	}
	
	public int delete(UserBoardDTO userBoardDTO) throws Exception {
		return userBoardDAO.delete(userBoardDTO);
	}
	
	public int reply(UserBoardDTO userBoardDTO, HttpSession session) throws Exception {
		UserBoardDTO origin = (UserBoardDTO)detail(userBoardDTO);
		// 부모를 가져와야 답글에서 insert할 수 있음
		// 1. step에 1씩 업데이트
		int result = userBoardDAO.replyUpdate(origin);

		// 2. 답글의 ref, step, depth를 세팅
		userBoardDTO.setUserboard_ref(origin.getUserboard_ref());
		userBoardDTO.setUserboard_step(origin.getUserboard_step() + 1L);
		userBoardDTO.setUserboard_depth(origin.getUserboard_depth() + 1L);
		
		if(userBoardDTO.getUserboard_contents() == null) {
			userBoardDTO.setUserboard_contents("");
		}
		result = userBoardDAO.reply(userBoardDTO);
		
		return result;
	}
	
	

}
