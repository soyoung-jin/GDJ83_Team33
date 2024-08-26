package com.team3.tamagochi.rank;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.mypet.MyPetDTO;

@Controller
@RequestMapping(value = "/rank/*")
public class RankController {

	@Autowired
	private RankService rankService;

	@GetMapping("rankList")
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		List<MyPetDTO> ar = rankService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("rank/rankList");
		
		return mv;
	}
	

	@GetMapping("rankDetail")
	public String detail(MyPetDTO myPetDTO, Model model, HttpSession session, Pager pager) throws Exception{
			
		myPetDTO = rankService.detail(myPetDTO);		
		model.addAttribute("myPetDTO", myPetDTO);
		

		return "rank/rankDetail";

	}
	
	@GetMapping("clickLike")
	public String clickLike (MyPetDTO myPetDTO, Model model) throws Exception{
			System.out.println(myPetDTO.getPet_num());
		int result = rankService.clickLike(myPetDTO);
		
		model.addAttribute("msg",result);
		
		return "commons/result";

	}
	
	
	
	
	

}
