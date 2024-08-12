package com.team3.tamagochi.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.store.WeaponDTO;

@Repository
public class UsersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.team3.tamagochi.users.UsersDAO.";
	
	
	// 회원가입 메서드
	public int registerUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "registerUsers", usersDTO);		
	}
	
	// 로그인 메서드
	public UsersDTO loginUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "loginUsers", usersDTO);
	}
	
	// 회원정보 수정 메서드
	public int updateUsers(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateUsers", usersDTO);
	}
	
	// 회원 탈퇴 메서드(데이터는 남아있으나 resign값을 0으로 만들어 더이상 로그인 하지 못하게 만듬)
	public int deleteAccount(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "deleteAccount", usersDTO);
	}
	
	// 인벤토리에서 내가 보유한 무기를 가져오는 메서드
	// 무기 데이터를 가져와야 하므로 리턴 타입은 weaponDTO가 된다
	public List<WeaponDTO> getInvenList(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getInvenList", usersDTO);
	}
	
	// 회원가입시 입력한 id값이 중복인지 아닌지 검사하는 JS 이벤트 코드
	public UsersDTO checkID(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "checkID", usersDTO);
	}
	
	
	
	
	// 회원가입시 디폴트 캐릭터를 만들어주는 메서드 4개
	public int setDefaultCharacter1(UsersDTO usersDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setDefaultCharacter1", usersDTO);
	}
	public int setDefaultCharacter2(UsersDTO usersDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setDefaultCharacter2", usersDTO);
	}
	public int setDefaultCharacter3(UsersDTO usersDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setDefaultCharacter3", usersDTO);
	}
	public int setDefaultCharacter4(UsersDTO usersDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setDefaultCharacter4", usersDTO);
	}
}
