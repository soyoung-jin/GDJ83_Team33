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
	
	@GetMapping("itemList")
	public void getItemList (Model model) throws Exception {
		List<WeaponDTO> list = storeService.getItemList();
		
		System.out.println(list.get(0).getWeapon_name());
		
		model.addAttribute("wpList", list);
	}
	
	@GetMapping("itemDetail")
	public void getItemDetail (WeaponDTO weaponDTO, Model model) throws Exception {
		System.out.println(weaponDTO.getWeapon_num());
		
		weaponDTO = storeService.getItemDetail(weaponDTO);
		
		model.addAttribute("wpDTO", weaponDTO);
		
		
	}
}
