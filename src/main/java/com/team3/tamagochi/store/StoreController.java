package com.team3.tamagochi.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	public void getItemList () throws Exception {
		storeService.getItemList();
	}
}
