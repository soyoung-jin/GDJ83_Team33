package com.team3.tamagochi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	// 회원가입 메서드
	public int registerUsers(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.registerUsers(usersDTO);
	}
	
	// 로그인 메서드
	public UsersDTO loginUsers(UsersDTO usersDTO) throws Exception{
		
		UsersDTO result = usersDAO.loginUsers(usersDTO);
		
		// result값이 Null일 경우, 데이터베이스에 존재하지 않는 id를 입력했음을 의미
		// result가 Null이 아닐 경우, 사용자가 입력한 id값이 데이터베이스에 존재
		// 따라서 Null이 아닐 경우 password가 맞는지 확인하는 코드 실행
		if(result != null) {
			if(result.getUser_pw().equals(usersDTO.getUser_pw())) {
				return result; // id도 일치하고 password도 일치할 경우 result를 return
			}else {
				return null; // id는 일치하지만 password가 일치하지 않을 경우 Null을 리턴
			}
		}
		
		return null; // id와 password 모두 일치하지 않을 경우 Null을 리턴
	}
	
	// 회원정보 수정 메서드
	public int updateUsers(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.updateUsers(usersDTO);
	}
	

}
