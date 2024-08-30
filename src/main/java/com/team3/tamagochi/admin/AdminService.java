package com.team3.tamagochi.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.mypet.MyPetDAO;
import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private MyPetDAO myPetDAO;

	
	public List<UsersDTO> getUserList() throws Exception{
		
		return adminDAO.getUserList();
	}
	
	public UsersDTO getUserDetail(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.getUserDetail(usersDTO);
	}
	
	public int updateUserDetail(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.updateUserDetail(usersDTO);
	}
	
	public int updateUserResign(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.updateUserResign(usersDTO);
	}
	
	public List<TransactionDTO> getUserTradeList(UsersDTO usersDTO) throws Exception{
		
		return adminDAO.getUserTradeList(usersDTO);
	}
	
	public SalesDTO getSales()throws Exception{
		
		return adminDAO.getSales();
	}
	
	public SalesDTO getRefund() throws Exception{
		
		return adminDAO.getRefund();
	}
	
	public Long getMonthSales() throws Exception{
		
		return adminDAO.getMonthSales();
	}
	
	public Long getMonthRefund() throws Exception{
		
		return adminDAO.getMonthRefund();
	}
	
	// 환불 관련 메서드
	public MyPetDTO refundCharacter1(MyPetDTO myPetDTO) throws Exception{
		
		return adminDAO.refundCharacter1(myPetDTO);
	}
	public int refundCharacter2(MyPetDTO myPetDTO) throws Exception{
		
		return adminDAO.refundCharacter2(myPetDTO);
	}
	public int selectMyPet(MyPetDTO myPetDTO) throws Exception{
		
		return myPetDAO.selectMyPet(myPetDTO);
	}
	public InventoryDTO refundItem1(TransactionDTO transactionDTO) throws Exception{
		
		return adminDAO.refundItem1(transactionDTO);
	}
	public int refundItem2(MyPetDTO myPetDTO) throws Exception{
		
		return adminDAO.refundItem2(myPetDTO);
	}
	public int refundItem3(InventoryDTO inventoryDTO) throws Exception{
		
		return adminDAO.refundItem3(inventoryDTO);
	}
	public TransactionDTO refundTransaction1(TransactionDTO transactionDTO) throws Exception{
		
		return adminDAO.refundTransaction1(transactionDTO);
	}
	public int refundTransaction2(TransactionDTO transactionDTO) throws Exception{
		
		return adminDAO.refundTransaction2(transactionDTO);
	}
	public int refundTransaction3(TransactionDTO transactionDTO) throws Exception{
		
		return adminDAO.refundTransaction3(transactionDTO);
	}
}
