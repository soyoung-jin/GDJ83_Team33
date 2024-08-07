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
	public String getItemList(Integer category, Pager pager, Model model) throws Exception {
		
		pager.setPerPage(6);
		
		List<Object> list = storeService.getItemList(category, pager);
		
		model.addAttribute("itemList", list);
		model.addAttribute("pager",pager);
		
		return "store/itemListRefresh";
	}
	
	//ajax로 리스트 조회하기 위해 jsp 찾아가는 경로만 작성
	//resources/js/storelist.js 스트립트 작성
	@GetMapping("itemList")
	public void getItemList(Pager pager, Model model) {
		
	}
	
	//Item 상세정보 조회
	@GetMapping("itemDetail")
	//category 리스트 조회 때 생긴 parameter 재사용
	public void getItemDetail (Long item_num, Integer category, Model model) throws Exception {
		
		if(category == 1) {
			WeaponDTO itemDTO = (WeaponDTO) storeService.getItemDetail(item_num,category);
			model.addAttribute("itemDTO", itemDTO);

		} else if(category == 0){
			CharacterDTO itemDTO = (CharacterDTO) storeService.getItemDetail(item_num,category);
			model.addAttribute("itemDTO", itemDTO);
		}
	}
	
	@GetMapping("addItem")
	public void addItem () throws Exception {
	}
	
	//weaponDTO의 변수에 무기설명 변수가 더 있어 매개변수로 받아옴
	@PostMapping("addItem")
	public String addItem (WeaponDTO weaponDTO, Model model) throws Exception {

		int result = storeService.addItem(weaponDTO);
		
		if(result>0) {
			model.addAttribute("result", "추가 성공");
		} else {
			model.addAttribute("result", "추가 실패");
		}

		model.addAttribute("url","addItem");
		return "commons/message";
	}
}
