package com.team3.tamagochi.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList", method= RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<NoticeDTO> list = noticeService.list();
		model.addAttribute("list",list);
		
		return "notice/noticeList";
		
	}
	
	
	@RequestMapping(value="noticeAdd", method= RequestMethod.GET)
	public String add() {
		return "notice/noticeAdd";
	}

}
