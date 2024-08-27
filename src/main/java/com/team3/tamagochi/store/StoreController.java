package com.team3.tamagochi.store;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.mypet.MyPetService;
import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;
import com.team3.tamagochi.users.UsersService;

@RequestMapping("/store/*")
@Controller
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@Autowired
	MyPetService myPetService;
	
	@Autowired
	UsersService usersService;

	// ==============================결제 관련 메소드=============================
	// ==============================결제 관련 메소드=============================
	// ==============================결제 관련 메소드=============================

	// 장바구니 결제 메소드
	@GetMapping("purchaseItem")
	public void purchaseItem(@RequestParam List<Long> ar, Model model) throws Exception {
			List<WishListDTO> list = new ArrayList<WishListDTO>();
			for (Long a : ar) {
				WishListDTO wishListDTO = new WishListDTO();
				wishListDTO.setWishlist_num(a);
				wishListDTO = storeService.getWishListDetail(wishListDTO);
				
				list.add(wishListDTO);
			}
				model.addAttribute("purchaseList", list);
	}
	
	// 단품결제 메소드
	@PostMapping("purchaseItem")
	public String purchaseItem(ItemDTO itemDTO, HttpSession session, Model model) throws Exception {
		
		// 아이템 중복 검사
		WishListDTO wishListDTO = new WishListDTO();
		wishListDTO.setItem_num(itemDTO.getItem_num());
		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		wishListDTO.setUser_id(usersDTO.getUser_id());
		
		int check = storeService.checkDuplication(wishListDTO);
		
		if(check == 0) {
			model.addAttribute("result", "이미 가지고 있는 아이템입니다.");
			model.addAttribute("url", "/store/itemList");
			return "commons/message";
		} else {
			itemDTO = storeService.getItemDetail(itemDTO);
			model.addAttribute("dto",itemDTO);
			return "purchaseItem";
		}
	}

	// 카카오페이 결제 후 DB 저장
	@PostMapping("purchaseComplete")
	public void purchaseComplete(@RequestBody TransactionDTO transactionDTO, HttpSession session, Model model)
			throws Exception {

		System.out.println(transactionDTO.getItem_num());
		System.out.println(transactionDTO.getTransaction_amount());
		System.out.println(transactionDTO.getTransaction_order());

		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		transactionDTO.setUser_id(usersDTO.getUser_id());
		transactionDTO.setTransaction_type("구입");

		//결제내역 생성
		int result = storeService.addTransaction(transactionDTO);
	
		if (result == 0) {
			model.addAttribute("result", "DB저장 실패");
			model.addAttribute("url", "/");
		}
	}
	
	@GetMapping("purchaseFinish")
	public void purchaseFinish () throws Exception {
		
	}

	// ==============================위시리스트 관련 메소드=============================
	// ==============================위시리스트 관련 메소드=============================
	// ==============================위시리스트 관련 메소드=============================

	@GetMapping("deleteWishList")
	public String deleteWishList(WishListDTO wishListDTO, HttpSession session, Model model) {
		
		if(wishListDTO.getWishlist_num() == null) {
			return "commons/result";
		}

		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		wishListDTO.setUser_id(usersDTO.getUser_id());

		int result = storeService.deleteWishList(wishListDTO);

		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("addWishList")
	public String addWishList(WishListDTO wishListDTO, HttpSession session, Model model) throws Exception {
		

		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");

		if (usersDTO == null) {
			model.addAttribute("msg", -1);

			return "commons/result";
		}

		wishListDTO.setUser_id(usersDTO.getUser_id());
		
		//중복확인
		int check = storeService.checkDuplication(wishListDTO);
		if(check == 0) {
			model.addAttribute("msg", -2);
			return "commons/result";
		}

		int result = storeService.addWishList(wishListDTO);

		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("getWishList")
	public String getWishList(HttpSession session, Model model) throws Exception {

		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");

		if (usersDTO == null) {
			model.addAttribute("result", "로그인 후 이용하세요.");
			model.addAttribute("url", "/users/login");

			return "commons/message";
		}

		List<WishListDTO> list = storeService.getWishList(usersDTO);

		// itemDTO의 itemfiledto를 추가하는 반복문
		for (WishListDTO dto : list) {
			ItemDTO itemDTO = new ItemDTO();

			itemDTO.setItem_num(dto.getItem_num());

			dto.setItemDTO(storeService.getItemDetail(itemDTO));
		}

		model.addAttribute("wishlist", list);

		return "store/getWishList";
	}

	// ============================== 상점,아이템관련 메소드 =============================
	// ============================== 상점,아이템관련 메소드 =============================
	// ============================== 상점,아이템관련 메소드 =============================

	// 캐릭터 이미지 가져오기
	@GetMapping("getImage")
	public ResponseEntity<byte[]> getImage(ItemFileDTO itemFileDTO, HttpSession session) throws Exception {

		String realPath = session.getServletContext().getRealPath("/resources/img/item");

		File file = new File(realPath, itemFileDTO.getFile_name());
		
		if(!file.exists()) {
			file = new File(realPath, "default.gif");
		}

		ResponseEntity<byte[]> result = null;

		HttpHeaders header = new HttpHeaders();

		header.add("Content-type", Files.probeContentType(file.toPath()));

		result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		return result;
	}

	@GetMapping("itemListRefresh")
	public String getItemList(ItemDTO itemDTO, Pager pager, Model model, HttpSession session) throws Exception {

		UsersDTO usersDTO = (UsersDTO) session.getAttribute("users_info");
		
		pager.setPerPage(6);

		List<ItemDTO> list = storeService.getItemList(itemDTO, pager);
		
		if (list == null) {
			model.addAttribute("msg", "<h2 class=\"text-white\">결과값이 없습니다.</h2>");
			return "commons/result";
		}
		
		//소유한 장비, 캐릭터 중복확인하는 과정
		if(itemDTO.getCategory_num()==0) {
			List<MyPetDTO> myPetList = myPetService.getList(usersDTO);
			
			for(MyPetDTO mypetDTO:myPetList) {
				for(ItemDTO dto:list) {
					if(dto.getItem_num()==mypetDTO.getItem_num()) {
						dto.setItem_description("");
					}
				}
			}
		} else {
			List<ItemDTO> invenList = usersService.getInvenList(usersDTO);
			
			for(ItemDTO invenDTO:invenList) {
				for(ItemDTO dto:list) {
					if(dto.getItem_num()==invenDTO.getItem_num()) {
						dto.setItem_description("");
					}
				}
			}
		}
		//소유한 장비, 캐릭터 중복확인하는 과정
		
		model.addAttribute("itemList", list);
		model.addAttribute("pager", pager);

		return "store/itemListRefresh";
	}

	// ajax로 리스트 조회하기 위해 jsp 찾아가는 경로만 작성
	// resources/js/storelist.js 스트립트 작성
	@GetMapping("itemList")
	public void getItemList(ItemDTO itemDTO, Model model) {
		model.addAttribute("dto", itemDTO);
	}

	// Item 상세정보 조회
	@GetMapping("itemDetail")
	// category 리스트 조회 때 생긴 parameter 재사용
	public String getItemDetail(ItemDTO itemDTO, Model model) throws Exception {

		itemDTO = storeService.getItemDetail(itemDTO);

		model.addAttribute("dto", itemDTO);
		
		return "store/itemDetail";
	}

	@GetMapping("addItem")
	public void addItem() throws Exception {
	}

	// weaponDTO의 변수에 무기설명 변수가 더 있어 매개변수로 받아옴
	@PostMapping("addItem")
	public String addItem(ItemDTO itemDTO, MultipartFile[] attach, Model model, HttpSession session) throws Exception {
		model.addAttribute("url", "addItem");
		
		for(MultipartFile mf:attach) {
			if(mf.isEmpty()) {
				model.addAttribute("result", "이미지 파일을 전부 추가해주세요.");
				return"commons/message";
			}
		}

		int result = storeService.addItem(itemDTO, attach, session);

		if (result > 0) {
			model.addAttribute("result", "추가 성공");
		} else {
			model.addAttribute("result", "추가 실패");
		}
		return "commons/message";
	}

	@GetMapping("updateItem")
	public String updateItem(ItemDTO itemDTO, Model model, HttpSession session) throws Exception {

		itemDTO = storeService.getItemDetail(itemDTO);
		
		String path = session.getServletContext().getRealPath("/resources/img/item");

		model.addAttribute("dto", itemDTO);
		model.addAttribute("path", path);

		return "store/addItem";
	}

	@PostMapping("updateItem")
	public String updateItem(ItemDTO itemDTO, MultipartFile[] attach, Model model, HttpSession session) throws Exception {
		
		
		model.addAttribute("url", "itemList?category_num="+itemDTO.getCategory_num());
		
		for(MultipartFile mf:attach) {
			if(mf.isEmpty()) {
				model.addAttribute("result", "이미지 파일을 전부 추가해주세요.");
				return"commons/message";
			}
		}
		
		int result = storeService.updateItem(itemDTO, attach, session);

		if (result == 1) {
			model.addAttribute("result", "수정 성공");
		} else if(result == 0){
			model.addAttribute("result", "수정 실패");
		} else if(result == -1){
			model.addAttribute("result", "이미지 등록이 안되어있음");
		}


		return "commons/message";
	}

	@GetMapping("deleteItem")
	public String deleteItem(ItemDTO itemDTO, Model model) throws Exception {
		
		int result = storeService.checkEquip(itemDTO);
		
		if(result==-1) {
			model.addAttribute("msg",result);
			return "commons/result";
		}

		result = storeService.deleteItem(itemDTO);
		
		model.addAttribute("msg", result);

		return "commons/result";
	}
}
