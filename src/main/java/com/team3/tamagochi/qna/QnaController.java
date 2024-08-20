package com.team3.tamagochi.qna;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.notice.NoticeDTO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception{
		List<QnaDTO> ar = qnaService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");
		return mv;
	}
	
	@GetMapping("qnaDetail")
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception{
		hit(qnaDTO);
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("detail",qnaDTO);
		return "qna/qnaDetail";
		
	}
	
	
	public void hit(QnaDTO qnaDTO) throws Exception {
		qnaService.hit(qnaDTO);
	}
	
	@GetMapping("qnaAdd")
	public String add() throws Exception {
		return "qna/qnaAdd";
	}

	@PostMapping("qnaAdd")
	public String add(QnaDTO qnaDTO, HttpSession session, Model model) throws Exception {
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		qnaDTO.setUser_id(usersDTO.getUser_id());
		int result = qnaService.add(qnaDTO, session);
		
		return "redirect:./qnaList";
	}

	
	@GetMapping("qnaUpdate")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO =qnaService.detail(qnaDTO);
		model.addAttribute("detail", qnaDTO);
		return "qna/qnaUpdate";
	}

	@PostMapping("qnaUpdate")
	public String update(QnaDTO qnaDTO) throws Exception {
		int num = qnaService.update(qnaDTO);
		return "redirect:./qnaDetail?question_num=" + qnaDTO.getQuestion_num();
	}
	
	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO,  Model model) throws Exception {
		int num = qnaService.delete(qnaDTO);
		
		String path = "commons/message";
		if (num > 0) {
			path = "redirect:./qnaList";
		} else {
			model.addAttribute("result", "게시물을 지우지 못했습니다.");
			model.addAttribute("url", "./qnaList");
		}
		return path;
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("detail", qnaDTO);
		return "qna/qnaAdd";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		qnaDTO.setUser_id(usersDTO.getUser_id());
		int result = qnaService.reply(qnaDTO, session);
		return "redirect:./qnaList";
	}

	
	
}