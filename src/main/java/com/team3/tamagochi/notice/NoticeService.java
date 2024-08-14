package com.team3.tamagochi.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list() throws Exception{
		return noticeDAO.list();
	}
	
	public int add(NoticeDTO noticeDTO, HttpSession session) {
		int result = noticeDAO.add(noticeDTO);
		String path = session.getServletContext().getRealPath("resources/upload/Notice");
		
		return result;
	}

}
