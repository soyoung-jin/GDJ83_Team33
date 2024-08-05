package com.team3.tamagochi.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
	public void getItemList()throws Exception{
		
	}

}
