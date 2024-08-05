package com.team3.tamagochi.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
	public List<ItemDTO> getItemList(Integer category) throws Exception {
		return storeDAO.getItemList(category);
	}
	
	public ItemDTO getItemDetail(ItemDTO itemDTO) throws Exception {
		return storeDAO.getItemDetail(itemDTO);
	}

}
