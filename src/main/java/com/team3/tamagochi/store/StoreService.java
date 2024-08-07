package com.team3.tamagochi.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.boards.util.Pager;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
	public List<Object> getItemList(Integer category, Pager pager) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		
		pager.makerow();
		
		map.put("pager", pager);		
		
		Integer totalCount =  storeDAO.getTotalCount(map);
		
		System.out.println(totalCount);
		
		pager.makeNum(totalCount);
		
		
		return storeDAO.getItemList(map);
	}
	
	public ItemDTO getItemDetail(Long item_num,Integer category) throws Exception {
		
		return storeDAO.getItemDetail(item_num, category);
	}
	
	public int addItem(WeaponDTO weaponDTO) {
		return storeDAO.addItem(weaponDTO);
	}

}
