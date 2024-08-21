package com.team3.tamagochi.rank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.boards.util.Pager;

@Service
public class RankService {
	@Autowired
	RankDAO rankDAO;

	public List<RankDTO> list(Pager pager) throws Exception {
		pager.makerow();
		pager.makeNum(rankDAO.getTotalCount(pager));
		return rankDAO.list(pager);
	}

}
