package com.team3.tamagochi.friend;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.UsersDTO;

@Repository
public class FriendDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.friend.FriendDAO.";
	
	public UsersDTO getFriendList(UsersDTO usersDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getFriendList", usersDTO);
	}
	
	public UsersDTO getFriendDetail(FriendDTO friendDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getFriendDetail", friendDTO);
	}
	
	public int deleteFriend(FriendDTO friendDTO) throws Exception{
		return sqlSession.delete(NAMESPACE + "deleteFriend", friendDTO);
	}
	
	public int makeFriends(FriendDTO friendDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"makeFriends", friendDTO);
	}
	
	// 인벤토리에서 내가 보유한 무기를 가져오는 메서드
		// 무기 데이터를 가져와야 하므로 리턴 타입은 weaponDTO가 된다
	public List<ItemDTO> getInvenList(UsersDTO usersDTO) throws Exception{
			
		return sqlSession.selectList(NAMESPACE + "getInvenList", usersDTO);
	}
	
	// 선물 받기
	public int takeGift(InventoryDTO inventoryDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "takeGift", inventoryDTO);
	}
	
	// 선물 주기
	public int sendGift(InventoryDTO inventoryDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "sendGift", inventoryDTO);
	}
	
	// 선물 알람 보내기
	public int sendAlarm(AlarmDTO alarmDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "sendAlarm", alarmDTO);
	}
	
	// 친구 맺기 알람 보내기
	public int sendFriendAlarm(AlarmDTO alarmDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "sendFriendAlarm", alarmDTO);
	}
	
	// 주소창으로 남의 친구 목록에 들어가는걸 방지하기 위한 검증 메서드
	public FriendDTO getFriendID(FriendDTO friendDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getFriendID", friendDTO);
	}
	
	// 알림 리스트 5개
	public List<AlarmDTO> getAlarmList(AlarmDTO alarmDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getAlarmList", alarmDTO);
	}
	
	// 알림 리스트 All
	public List<AlarmDTO> getAlarmListAll(AlarmDTO alarmDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getAlarmListAll", alarmDTO);
	}
	
}
