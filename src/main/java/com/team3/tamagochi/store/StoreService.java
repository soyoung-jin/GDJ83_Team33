package com.team3.tamagochi.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
	public List<Object> getItemList(Integer category) throws Exception {
		
		return storeDAO.getItemList(category);
	}
	
	public ItemDTO getItemDetail(Long item_num,Integer category) throws Exception {
		
		return storeDAO.getItemDetail(item_num, category);
	}
	
	public void addItem(WeaponDTO weaponDTO) {
		storeDAO.addItem(weaponDTO);
	}

}
