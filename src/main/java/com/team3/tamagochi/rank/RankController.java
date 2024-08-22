package com.team3.tamagochi.rank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team3.tamagochi.boards.util.Pager;

@Controller
@RequestMapping(value = "/rank/*")
public class RankController {

	@Autowired
	private RankService rankService;

	@GetMapping("rankList")
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		List<RankDTO> ar = rankService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("rank/rankList");
		return mv;
	}

}
