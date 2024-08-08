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

	public List<ItemDTO> getItemList(ItemDTO itemDTO, Pager pager) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		

		map.put("itemDTO", itemDTO);
		map.put("pager", pager);

		pager.makerow();
		
		Integer totalCount = storeDAO.getTotalCount(map);
		
		pager.makeNum(totalCount);
		
		
		return storeDAO.getItemList(map);
	}

	public ItemDTO getItemDetail(ItemDTO itemDTO) throws Exception {

		return storeDAO.getItemDetail(itemDTO);
	}

	public int addItem(ItemDTO itemDTO) {
		return storeDAO.addItem(itemDTO);
	}

	public int updateItem(ItemDTO itemDTO) {

		return storeDAO.updateItem(itemDTO);
	}

	public int deleteItem(ItemDTO itemDTO) {

		return storeDAO.deleteItem(itemDTO);
	}
	
	public int addWishList(WishListDTO wishListDTO) {
		return storeDAO.addWishList(wishListDTO);
	}

}
