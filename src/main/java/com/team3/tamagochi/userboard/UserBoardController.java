package com.team3.tamagochi.userboard;

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
@RequestMapping(value="/userboard/*")
public class UserBoardController {
	
	@Autowired
	private UserBoardService userBoardService;
	
	@GetMapping("userboardList")
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception{
		List<UserBoardDTO> ar = userBoardService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("userboard/userboardList");
		return mv;
	}
	
	@GetMapping("userboardDetail")
	public String getDetail(UserBoardDTO userBoardDTO, Model model) throws Exception{
		hit(userBoardDTO);
		userBoardDTO = userBoardService.detail(userBoardDTO);
		model.addAttribute("detail",userBoardDTO);
		return "userboard/userboardDetail";
		
	}
	
	
	public void hit(UserBoardDTO userBoardDTO) throws Exception {
		userBoardService.hit(userBoardDTO);
	}
	
	@GetMapping("userboardAdd")
	public String add() throws Exception {
		return "userboard/userboardAdd";
	}

	@PostMapping("userboardAdd")
	public String add(UserBoardDTO userBoardDTO, HttpSession session, Model model) throws Exception {
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		userBoardDTO.setUser_id(usersDTO.getUser_id());
		int result = userBoardService.add(userBoardDTO, session);
		
		return "redirect:./userboardList";
	}

	
	@GetMapping("userboardUpdate")
	public String update(UserBoardDTO userBoardDTO, Model model) throws Exception {
		userBoardDTO =userBoardService.detail(userBoardDTO);
		model.addAttribute("detail", userBoardDTO);
		return "userboard/userboardUpdate";
	}

	@PostMapping("userboardUpdate")
	public String update(UserBoardDTO userBoardDTO) throws Exception {
		int num = userBoardService.update(userBoardDTO);
		return "redirect:./userboardDetail?userboard_num=" + userBoardDTO.getUserboard_num();
	}
	
	@GetMapping("delete")
	public String delete(UserBoardDTO userBoardDTO,  Model model) throws Exception {
		int num = userBoardService.delete(userBoardDTO);
		
		String path = "commons/message";
		if (num > 0) {
			path = "redirect:./userboardList";
		} else {
			model.addAttribute("result", "게시물을 지우지 못했습니다.");
			model.addAttribute("url", "./userboardList");
		}
		return path;
	}
	
	@GetMapping("reply")
	public String reply(UserBoardDTO userBoardDTO, Model model) throws Exception {
		model.addAttribute("detail", userBoardDTO);
		return "userboard/userboardAdd";
	}
	
	@PostMapping("reply")
	public String reply(UserBoardDTO userBoardDTO, HttpSession session) throws Exception {
		UsersDTO usersDTO = (UsersDTO)session.getAttribute("users_info");
		userBoardDTO.setUser_id(usersDTO.getUser_id());
		int result = userBoardService.reply(userBoardDTO, session);
		return "redirect:./userboardList";
	}

	
	
}
