package com.team3.tamagochi.rank;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.mypet.MyPetDTO;

@Repository
public class RankDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.rank.RankDAO.";

	public List<MyPetDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}

	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);

	}
	
	public MyPetDTO detail(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "detail", myPetDTO);
	}

}
