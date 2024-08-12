package com.team3.tamagochi.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@RequestMapping(value="add", method= RequestMethod.POST)
	public String add() {
		return "notice/add";
	}

}
