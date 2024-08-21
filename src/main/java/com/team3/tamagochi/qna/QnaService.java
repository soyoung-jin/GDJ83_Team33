package com.team3.tamagochi.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.notice.NoticeDTO;


@Service
public class QnaService {
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> list(Pager pager) throws Exception{
		pager.makerow();
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.list(pager);
		
	}
	
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.detail(qnaDTO);
	}
	
	public void hit(QnaDTO qnaDTO) throws Exception {
		qnaDAO.hit(qnaDTO);
	}
	
	public int add(QnaDTO qnaDTO, HttpSession session) throws Exception{
		if(qnaDTO.getQuestion_contents() == null) {
			qnaDTO.setQuestion_contents("");
		}
		
		int result = qnaDAO.add(qnaDTO);
		
		return result;
	}
	
	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}
	
	public int reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		QnaDTO origin = (QnaDTO) qnaDAO.detail(qnaDTO);
		// 부모를 가져와야 답글에서 insert할 수 있음
		// 1. step에 1씩 업데이트
		int result = qnaDAO.replyUpdate(origin);

		// 2. 답글의 ref, step, depth를 세팅
		System.out.println(origin.getQuestion_ref());
		qnaDTO.setQuestion_step(origin.getQuestion_step() + 1);
		qnaDTO.setQuestion_depth(origin.getQuestion_depth() + 1);
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}
	
	

}
