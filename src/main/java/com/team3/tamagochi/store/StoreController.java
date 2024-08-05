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
	
	@GetMapping("itemList")
	public void getItemList() {
	}
	
	//Item 상세정보 조회
	@GetMapping("itemDetail")
	public void getItemDetail (ItemDTO itemDTO, Integer category, Model model) throws Exception {
		
		itemDTO = storeService.getItemDetail(itemDTO, category);
		
		model.addAttribute("itemDTO", itemDTO);
	}
	
	@GetMapping("addItem")
	public void addItem () throws Exception {
		
	}
}
