package com.team3.tamagochi.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.store.WeaponDTO;

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
	
	// 수정된 회원 정보를 보여주는 메서드
	// login 쿼리문을 재사용하여 service에서 updateData 메서드를 새로 만듬
	public UsersDTO updateUsersData(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.loginUsers(usersDTO);
	}
	
	// 회원 탈퇴 메서드(데이터는 남아있으나 resign값을 0으로 만들어 더이상 로그인 하지 못하게 만듬)
	public int deleteAccount(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.deleteAccount(usersDTO);
	}
	
	// 인벤토리에서 내가 보유한 무기를 가져오는 메서드
	// 무기 데이터를 가져와야 하므로 리턴 타입은 weaponDTO가 된다
	public List<WeaponDTO> getInvenList(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.getInvenList(usersDTO);
	}
	
	public UsersDTO checkID(UsersDTO usersDTO) throws Exception{
		
		return usersDAO.checkID(usersDTO);
	}
	
	
	
	// 회원가입시 디폴트 캐릭터를 만들어주는 메서드 4개를 service에서 하나로 합침
	public int setDefaultCharacter(UsersDTO usersDTO) throws Exception{
		
		int result = usersDAO.setDefaultCharacter1(usersDTO);
		result = usersDAO.setDefaultCharacter2(usersDTO);
		result = usersDAO.setDefaultCharacter3(usersDTO);
		result = usersDAO.setDefaultCharacter4(usersDTO);
		
		return result;
	}
	

}
