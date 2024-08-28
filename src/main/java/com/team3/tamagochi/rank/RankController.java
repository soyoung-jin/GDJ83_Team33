package com.team3.tamagochi.rank;

import java.util.ArrayList;
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
import com.team3.tamagochi.friend.FriendService;
import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.mypet.MyPetService;
import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.store.ItemFileDTO;
import com.team3.tamagochi.store.StoreDAO;
import com.team3.tamagochi.store.StoreService;
import com.team3.tamagochi.users.UsersDAO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping(value = "/rank/*")
public class RankController {

	@Autowired
	private RankService rankService;
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private MyPetService myPetService;

	@GetMapping("rankList")
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		
		List<MyPetDTO> ar = rankService.list(pager);
		
		for(int i=0;i<ar.size();i++) {
			MyPetDTO myPetDTO = myPetService.getDetail(ar.get(i));
			ar.set(i, myPetDTO);
		}
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("rank/rankList");
		
		return mv;
	}
	
	@GetMapping("rankPlayModal")
	public void rankPlayModal(Model model, MyPetDTO myPetDTO) throws Exception {
		myPetDTO = myPetService.getDetail(myPetDTO);
		model.addAttribute("petDTO", myPetDTO);
		
	}
	

	@GetMapping("rankDetail")
	public String detail(MyPetDTO myPetDTO, Model model, HttpSession session, Pager pager) throws Exception{
			
		myPetDTO = myPetService.getDetail(myPetDTO);
				
		model.addAttribute("myPetDTO", myPetDTO);
		
		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		
		usersDTO = friendService.getFriendList(usersDTO);
		
		model.addAttribute("usersDTO", usersDTO);
		

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
