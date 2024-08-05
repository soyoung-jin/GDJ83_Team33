package com.team3.tamagochi.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team3.tamagochi.boards.BoardDTO;
import com.team3.tamagochi.boards.util.Pager;

@RequestMapping("/notice/*")
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	@ModelAttribute("board")
	public String getBorad() {
		return "Notice";
	}

	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> list = noticeService.list(pager);
		model.addAttribute("list", list);

		return "notice/noticeList";

	}

}
