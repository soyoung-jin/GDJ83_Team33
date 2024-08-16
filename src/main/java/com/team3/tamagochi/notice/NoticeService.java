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
	
	public int add(NoticeDTO noticeDTO, HttpSession session) throws Exception{
		int result = noticeDAO.add(noticeDTO);
		
		return result;
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	public void hit(NoticeDTO noticeDTO) throws Exception {
		noticeDAO.hit(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}


}
