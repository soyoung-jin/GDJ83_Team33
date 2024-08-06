package com.team3.tamagochi.store;

import java.util.List;
import java.util.Map;

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
	
	
	public ItemDTO getItemDetail(Long item_num,Integer category) {
	
		//카테고리 0: 캐릭터, 1:무기 분류, resultType이 달라야해서 mapper 분리함
		if(category==1) {
			return sqlSession.selectOne(NAMESPACE+"getWeaponDetail", item_num);
		}
		
		return sqlSession.selectOne(NAMESPACE+"getCharacterDetail", item_num);
	}

}
