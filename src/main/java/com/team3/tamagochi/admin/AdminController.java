package com.team3.tamagochi.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	
	@GetMapping("adminMain")
	public void getAdminMain(Model model) throws Exception{
		
		List<UsersDTO> list = adminService.getUserList();
		
		// 연간 매출 조회 메서드
		SalesDTO salesDTO = adminService.getSales();
		// 연간 환불 조회 메서드
		SalesDTO refundDTO = adminService.getRefund();
		// 월간 매출 조회 메서드
		Long monthSales = adminService.getMonthSales();
		// 월간 환불 조회 메서드
		Long monthRefund = adminService.getMonthRefund();
		
		model.addAttribute("list", list);
		model.addAttribute("salesDTO", salesDTO);
		model.addAttribute("refundDTO", refundDTO);
		model.addAttribute("monthSales", monthSales);
		model.addAttribute("monthRefund", monthRefund);
	}
	
	@GetMapping("userDetail")
	public void getUserDetail(Model model, UsersDTO usersDTO) throws Exception{
		
		usersDTO = adminService.getUserDetail(usersDTO);
		
		model.addAttribute("usersDTO", usersDTO);
	}
	
	@GetMapping("tradeList")
	public void getUserTradeList(Model model, UsersDTO usersDTO) throws Exception{
		
		List<TransactionDTO> list = adminService.getUserTradeList(usersDTO);
		
		model.addAttribute("list", list);
	}
	
	@PostMapping("userUpdate")
	public String updateUserDetail(Model model, UsersDTO usersDTO) throws Exception{
		
		int result = adminService.updateUserDetail(usersDTO);
		
		String id = usersDTO.getUser_id();
		
		if(result > 0) {
			model.addAttribute("result", "회원 정보가 수정되었습니다.");
			model.addAttribute("url", "/admin/userDetail?user_id=" + id);
		}
		
		return "commons/message";
	}
	
	@GetMapping("userResign")
	public String updateUserResign(Model model, UsersDTO usersDTO) throws Exception{
	
		System.out.println(usersDTO.getUser_resign());
		int result = adminService.updateUserResign(usersDTO);
	
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
}
