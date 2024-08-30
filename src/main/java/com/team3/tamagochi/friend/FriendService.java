package com.team3.tamagochi.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class FriendService {
	
	@Autowired
	private FriendDAO friendDAO;
	
	public UsersDTO getFriendList(UsersDTO usersDTO) throws Exception{
		return friendDAO.getFriendList(usersDTO);
	}
	
	public UsersDTO getFriendDetail(FriendDTO friendDTO) throws Exception{
		return friendDAO.getFriendDetail(friendDTO);
	}
	
	public int makeFriends(FriendDTO friendDTO) throws Exception{
		return friendDAO.makeFriends(friendDTO);
	}
	
	public int deleteFriend(FriendDTO friendDTO) throws Exception{
		return friendDAO.deleteFriend(friendDTO);
	}
	
	// 인벤토리에서 내가 보유한 무기를 가져오는 메서드
	// 무기 데이터를 가져와야 하므로 리턴 타입은 weaponDTO가 된다
	public List<ItemDTO> getInvenList(UsersDTO usersDTO) throws Exception{
			
		return friendDAO.getInvenList(usersDTO);
	}
	
	// 선물 받기
	public int takeGift(InventoryDTO inventoryDTO) throws Exception {
		return friendDAO.takeGift(inventoryDTO);
	}
	
	// 선물 주기
	public int sendGift (InventoryDTO inventoryDTO) throws Exception {
		return friendDAO.sendGift(inventoryDTO);
	}
	
	// 선물 알람 보내기
	public int sendAlarm(AlarmDTO alarmDTO) throws Exception {
		return friendDAO.sendAlarm(alarmDTO);
	}
	
	// 친구 알람 보내기
	public int sendFriendAlarm(AlarmDTO alarmDTO) throws Exception {
		return friendDAO.sendFriendAlarm(alarmDTO);
	}
	
	// 주소창으로 남의 친구 목록에 들어가는걸 방지하기 위한 검증 메서드
	public FriendDTO getFriendID(FriendDTO friendDTO) throws Exception{
		return friendDAO.getFriendID(friendDTO);
	}
	
	// 알림 리스트 5개
	public List<AlarmDTO> getAlarmList(AlarmDTO alarmDTO) throws Exception{
		return friendDAO.getAlarmList(alarmDTO);
	}
	
	// 알림 리스트 All
	public List<AlarmDTO> getAlarmListAll(AlarmDTO alarmDTO) throws Exception{
		return friendDAO.getAlarmListAll(alarmDTO);
	}
}
