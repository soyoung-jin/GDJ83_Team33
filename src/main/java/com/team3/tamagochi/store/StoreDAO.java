package com.team3.tamagochi.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private final String NAMESPACE="com.team3.tamagochi.store.StoreDAO.";
	
	public List<ItemDTO> getItemList(Integer category) {
		return sqlSession.selectList(NAMESPACE+"getItemList", category);
	}
	
	public ItemDTO getItemDetail(ItemDTO itemDTO) {
		return sqlSession.selectOne(NAMESPACE+"getItemDetail", itemDTO);
	}

}
