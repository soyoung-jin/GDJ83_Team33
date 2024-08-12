package com.team3.tamagochi.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.boards.util.Pager;

@Repository
public class StoreDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.store.StoreDAO.";

	public List<ItemDTO> getItemList(Map<String, Object> map) {
	
		return sqlSession.selectList(NAMESPACE + "getItemList", map);
	}

	public Integer getTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", map);
	}

	public ItemDTO getItemDetail(ItemDTO itemDTO) {
		return sqlSession.selectOne(NAMESPACE + "getItemDetail", itemDTO);
	}

	public int addItem(ItemDTO itemDTO) {
		return sqlSession.insert(NAMESPACE + "addItem", itemDTO);
	}

	public int updateItem(ItemDTO itemDTO) {
		return sqlSession.update(NAMESPACE + "updateItem", itemDTO);
	}

	public int deleteItem(ItemDTO itemDTO) {
		return sqlSession.update(NAMESPACE + "deleteItem", itemDTO);
	}
	
	public int addWishList(WishListDTO wishListDTO) {
		return sqlSession.insert(NAMESPACE+"addWishList", wishListDTO);
	}

}
