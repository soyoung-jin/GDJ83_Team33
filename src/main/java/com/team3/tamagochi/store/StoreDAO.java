package com.team3.tamagochi.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public void getItemList() {
		
	}

}
