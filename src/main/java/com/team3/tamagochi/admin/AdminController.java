package com.team3.tamagochi.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.mypet.MyPetService;
import com.team3.tamagochi.store.CharacterDTO;
import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.store.StoreService;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StoreService storeService;
	@Autowired
	private MyPetService myPetService;

	
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
	
	@PostMapping("refund")
	public String refundItem(Model model, TransactionDTO transactionDTO, HttpSession session) throws Exception{
		
		ItemDTO itemDTO = new ItemDTO();
		MyPetDTO myPetDTO = new MyPetDTO();
		MyPetDTO myPetDTO2 = new MyPetDTO();
		UsersDTO usersDTO = new UsersDTO();
		InventoryDTO inventoryDTO = new InventoryDTO();
		usersDTO.setUser_id(transactionDTO.getUser_id());
		itemDTO.setItem_num(transactionDTO.getItem_num());
		
		// storeService에서 itemDetail 메서드를 통해 해당 아이템의 카테고리를 가져온다
		itemDTO = storeService.getItemDetail(itemDTO);
		
		long category = itemDTO.getCategory_num();
		int result = 0;
		
		// 카테고리가 캐릭터인지 무기인지에 따라서 메서드를 다르게 실행
		if(category == 0) {
			// 캐릭터 환불 코드 실행
			myPetDTO.setItem_num(transactionDTO.getItem_num());
			myPetDTO.setUser_id(transactionDTO.getUser_id());
			myPetDTO = adminService.refundCharacter1(myPetDTO);		// 아이템 번호에 맞는 캐릭터를 조회
			result = adminService.refundCharacter2(myPetDTO);	// 조회한 캐릭터를 DB에서 삭제
			if(myPetDTO.getPet_selected() == 1) {	// 삭제한 캐릭터가 현재 선택된 캐릭터라면, 다른 캐릭터를 조회해서 선택
				List<MyPetDTO> list = myPetService.getList(usersDTO);
				result = adminService.selectMyPet(list.get(0));
			}
			
		}else {
			System.out.println("안녕하세요 무기입니다.");
			// 무기 환불 코드 실행
			// 환불하려는 아이템의 소지품 번호를 검색
			inventoryDTO = adminService.refundItem1(transactionDTO);
			
			// 환불 유저의 캐릭터 중 해당 아이템을 장착중인 캐릭터의 추가 능력치를 0으로 만듬
			myPetDTO2.setUser_id(inventoryDTO.getUser_id());
			myPetDTO2.setEquip_num(inventoryDTO.getInventory_num());
			result = adminService.refundItem2(myPetDTO2);
			
			// inventory에 있는 환불 요청 아이템을 삭제
			result = adminService.refundItem3(inventoryDTO);
		}
		
		if(result > 0) {
			
			// 환불하고자 하는 거래내역을 조회한 뒤, 해당 값에서 거래 타입을 '환불'로 바꿔서 다시 삽입
			transactionDTO = adminService.refundTransaction1(transactionDTO);
			result = adminService.refundTransaction2(transactionDTO);
			result = adminService.refundTransaction3(transactionDTO);
		}
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
}
