package com.team3.tamagochi.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.team3.tamagochi.admin.AdminDAO.";
	
	// 전체 유저 목록을 조회하는 메서드
	public List<UsersDTO> getUserList()throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getUserList");
	}
	
	// 선택한 유저 상세 정보 조회 메서드
	public UsersDTO getUserDetail(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getUserDetail", usersDTO);
	}
	
	// 선택한 유저 상세 정보 수정 메서드
	public int updateUserDetail(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateUserDetail", usersDTO);
	}
	
	// 유저 정지 및 복구 메서드
	public int updateUserResign(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateUserResign", usersDTO);
	}
	
	// 선택한 유저의 거래 내역 조회 메서드
	public List<TransactionDTO> getUserTradeList(UsersDTO usersDTO) throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getUserTradeList", usersDTO);
	}
	
	// 연간 매출 조회 메서드
	public SalesDTO getSales()throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getSales");
	}
	
	// 연간 환불 조회 메서드
	public SalesDTO getRefund() throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getRefund");
	}
	
	// 월 매출 조회 메서드
	public Long getMonthSales() throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getMonthSales");	
	}
	
	// 월 환불 조회 메서드
	public Long getMonthRefund() throws Exception{
			
		return sqlSession.selectOne(NAMESPACE + "getMonthRefund");	
	}
	
	// 환불 관련 코드 모음
	public MyPetDTO refundCharacter1(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "refundCharacter1", myPetDTO);
	}
	public int refundCharacter2(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "refundCharacter2", myPetDTO);
	}
	public InventoryDTO refundItem1(TransactionDTO transactionDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "refundItem1", transactionDTO);
	}
	public int refundItem2(MyPetDTO myPetDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "refundItem2", myPetDTO);
	}
	public int refundItem3(InventoryDTO inventoryDTO) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "refundItem3", inventoryDTO);
	}
	public TransactionDTO refundTransaction1(TransactionDTO transactionDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "refundTransaction1", transactionDTO);
	}
	public int refundTransaction2(TransactionDTO transactionDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "refundTransaction2", transactionDTO);
	}
	public int refundTransaction3(TransactionDTO transactionDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "refundTransaction3", transactionDTO);
	}
}
