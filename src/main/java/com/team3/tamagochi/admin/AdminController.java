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
		
		// 환불한 아이템은 무기 or 캐릭터에 따라서 처리해야 하는 메서드가 달라진다
		// 때문에 구분을 위해 storeService에서 itemDetail 메서드를 통해 해당 아이템의 카테고리 정보를 가져온다
		itemDTO = storeService.getItemDetail(itemDTO);
		
		long category = itemDTO.getCategory_num();
		int result = 0;
		
		// 카테고리가 캐릭터인지 무기인지에 따라서 메서드를 다르게 실행
		if(category == 0) {
			// 캐릭터 환불 코드 실행
			myPetDTO.setItem_num(transactionDTO.getItem_num());
			myPetDTO.setUser_id(transactionDTO.getUser_id());
			myPetDTO = adminService.refundCharacter1(myPetDTO);		// 환불한 아이템 번호에 맞는 캐릭터를 조회
			result = adminService.refundCharacter2(myPetDTO);	// 조회한 캐릭터를 DB에서 삭제
			// 삭제한 캐릭터가 만약 현재 사용중인 캐릭터라면, 다른 캐릭터를 조회해서 임의로 하나의 캐릭터를 사용중으로 바꿈
			if(myPetDTO.getPet_selected() == 1) {
				List<MyPetDTO> list = myPetService.getList(usersDTO);
				result = adminService.selectMyPet(list.get(0)); // 캐릭터 선택은 기존에 만들어둔 메서드를 재활용
			}
			
		}else {
			// 무기 환불 코드 실행
			// 1. 환불하려는 아이템의 소지품 번호를 검색
			inventoryDTO = adminService.refundItem1(transactionDTO);
			
			// 2. 환불 유저의 캐릭터 중 해당 아이템을 장착중인 캐릭터의 추가 능력치를 0으로 만듬
			myPetDTO2.setUser_id(inventoryDTO.getUser_id());
			myPetDTO2.setEquip_num(inventoryDTO.getInventory_num());
			result = adminService.refundItem2(myPetDTO2);
			
			// 3. inventory에 있는 환불 요청 아이템을 삭제
			result = adminService.refundItem3(inventoryDTO);
		}
		
		if(result > 0) {
			
			// 1. 환불하고자 하는 구매내역을 조회
			transactionDTO = adminService.refundTransaction1(transactionDTO);
			/* 2. 구입한 거래내역에서 order번호를 null로 update해줌
			   (이미 구입한 아이템이나 환불한 아이템은 다시 환불하지 못하게 order번호의 null여부로 button을 보이게 한다) */
			result = adminService.refundTransaction2(transactionDTO);
			// 3. 조회한 구매내역 정보로 환불 내역을 새로 insert해줌(거래 종류, 날짜를 제외한 나머지 값이 구입한 거래내역과 같다)
			result = adminService.refundTransaction3(transactionDTO);
		}
		
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
}
