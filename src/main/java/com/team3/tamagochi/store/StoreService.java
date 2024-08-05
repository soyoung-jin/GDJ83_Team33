package com.team3.tamagochi.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
	public List<WeaponDTO> getItemList() throws Exception{
		return storeDAO.getItemList();
	}

}
