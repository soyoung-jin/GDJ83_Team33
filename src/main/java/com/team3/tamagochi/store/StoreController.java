package com.team3.tamagochi.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.tamagochi.boards.util.Pager;

@RequestMapping("/store/*")
@Controller
public class StoreController {

	@Autowired
	StoreService storeService;

	@GetMapping("itemListRefresh")
	public String getItemList(ItemDTO itemDTO, Pager pager, Model model) throws Exception {
		
		System.out.println(itemDTO.getCategory_num());

		pager.setPerPage(6);

		List<ItemDTO> list = storeService.getItemList(itemDTO, pager);

		model.addAttribute("itemList", list);
		model.addAttribute("pager", pager);

		return "store/itemListRefresh";
	}

	// ajax로 리스트 조회하기 위해 jsp 찾아가는 경로만 작성
	// resources/js/storelist.js 스트립트 작성
	@GetMapping("itemList")
	public void getItemList() {
	}

	// Item 상세정보 조회
	@GetMapping("itemDetail")
	// category 리스트 조회 때 생긴 parameter 재사용
	public void getItemDetail(Long item_num, Integer category, Model model) throws Exception {

		ItemDTO itemDTO = storeService.getItemDetail(item_num, category);

		model.addAttribute("dto", itemDTO);
	}

	@GetMapping("addItem")
	public void addItem() throws Exception {
	}

	// weaponDTO의 변수에 무기설명 변수가 더 있어 매개변수로 받아옴
	@PostMapping("addItem")
	public String addItem(WeaponDTO weaponDTO, Model model) throws Exception {

		int result = storeService.addItem(weaponDTO);

		if (result > 0) {
			model.addAttribute("result", "추가 성공");
		} else {
			model.addAttribute("result", "추가 실패");
		}

		model.addAttribute("url", "addItem");
		return "commons/message";
	}

	@GetMapping("updateItem")
	public String updateItem(Integer category, Long item_num, Model model) throws Exception {

		ItemDTO itemDTO = storeService.getItemDetail(item_num, category);

		model.addAttribute("dto", itemDTO);
		model.addAttribute("category", category);

		return "store/addItem";
	}

	@PostMapping("updateItem")
	public String updateItem(WeaponDTO weaponDTO, Long item_num) throws Exception {
		int result = storeService.updateItem(weaponDTO, item_num);

		return "store/itemList";
	}

	@GetMapping("deleteItem")
	public String deleteItem(Integer category, Long item_num, Model model) throws Exception {

		int result = storeService.deleteItem(category, item_num);

		if (result == 1) {
			model.addAttribute("result", "삭제 성공");
		} else {
			model.addAttribute("result", "삭제 실패");
		}

		model.addAttribute("url", "/store/itemList?category=1");
		model.addAttribute("page", category);

		return "commons/message";
	}
}
