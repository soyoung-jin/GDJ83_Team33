package com.team3.tamagochi.rank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.mypet.MyPetDTO;

@Service
public class RankService {
	@Autowired
	RankDAO rankDAO;

	public List<MyPetDTO> list(Pager pager) throws Exception {
		pager.makerow();
		pager.makeNum(rankDAO.getTotalCount(pager));
		return rankDAO.list(pager);
	}
	
	public MyPetDTO detail(MyPetDTO myPetDTO) throws Exception{
		
		return rankDAO.detail(myPetDTO);
	}
	
	public int clickLike(MyPetDTO myPetDTO) throws Exception{
		
		return rankDAO.clickLike(myPetDTO);
	}

}
