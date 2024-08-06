package com.team3.tamagochi.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/store/*")
@Controller
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("itemListRefresh")
	public String getItemList(Integer category, Model model) throws Exception {
		
		List<ItemDTO> list = null;
		
		if(category == null) {
			category = 0;
		}
		
		list = storeService.getItemList(category);

		model.addAttribute("itemList", list);
		
		return "store/itemListRefresh";
	}
	
	//ajax로 리스트 조회하기 위해 jsp 찾아가는 경로만 작성
	//resources/js/storelist.js 스트립트 작성
	@GetMapping("itemList")
	public void getItemList() {
	}
	
	//Item 상세정보 조회
	@GetMapping("itemDetail")
	//category 리스트 조회 때 생긴 parameter 재사용
	public void getItemDetail (Long item_num, Integer category, Model model) throws Exception {
		
		ItemDTO itemDTO = storeService.getItemDetail(item_num,category);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("addItem")
	public void addItem () throws Exception {
	}
	
	@PostMapping("addItem")
	public void addItem (ItemDTO itemDTO) throws Exception {
		
	}
}
