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
	
	public List<ItemDTO> getItemList(Integer category) throws Exception {
		return storeDAO.getItemList(category);
	}
	
	public ItemDTO getItemDetail(ItemDTO itemDTO, Integer category) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("itemDTO", itemDTO);
		map.put("category", category);
		
		return storeDAO.getItemDetail(map);
	}

}
