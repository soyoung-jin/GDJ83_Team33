package com.team3.tamagochi.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/store/*")
@Controller
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	//Item 리스트 조회
	@GetMapping("itemList")
	public void getItemList (Model model, Integer category) throws Exception {
		
		
		List<ItemDTO> list = storeService.getItemList(category);
		
		
		model.addAttribute("itemList", list);
	}
	
	//Item 상세정보 조회
	@GetMapping("itemDetail")
	public void getItemDetail (ItemDTO itemDTO, Model model) throws Exception {
		System.out.println(itemDTO.getItem_num());
		
		itemDTO = storeService.getItemDetail(itemDTO);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("addItem")
	public void addItem () throws Exception {
		
	}
}
