package com.team3.tamagochi.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Repository
public class StoreDAO {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.team3.tamagochi.store.StoreDAO.";
	
	public Integer checkEquip (ItemDTO itemDTO) {
		int result = 1;
		
		if(itemDTO.getCategory_num()==0) {
			
			result = sqlSession.selectOne(NAMESPACE+"checkPet", itemDTO);
			
			if(result>0) {
				return -1;
			}
			
		} else {
			List<InventoryDTO> invenList = sqlSession.selectList(NAMESPACE+"getInven", itemDTO);
			
			for(InventoryDTO i:invenList) {
				result = sqlSession.selectOne(NAMESPACE+"checkInven", i);
				
				if(result>0) {
					return -1;
				}
			}
		}
		
		return result;
		
	}
	
	public int checkDuplication(WishListDTO wishlistDTO) {
		
		List<WishListDTO> result = sqlSession.selectList(NAMESPACE+"checkDuplication", wishlistDTO);		
		
		if(result.size()>0) {
			return result.size();
		}
		result = sqlSession.selectList(NAMESPACE+"checkMyWish", wishlistDTO);
		if(result.size()>0) {
			return -1;
		}
		
		return result.size();
	}
	
	public int addBag (Map<String, Object> map) {
		
		WishListDTO wishListDTO = new WishListDTO();
		
		wishListDTO.setUser_id((String)map.get("id"));
		
		ItemDTO itemDTO = (ItemDTO) map.get("itemDTO");
		
		wishListDTO.setItem_num(itemDTO.getItem_num());
		wishListDTO.setWishlist_num(0L);
		
		sqlSession.delete(NAMESPACE+"deleteWishList", wishListDTO);
		
		return sqlSession.insert(NAMESPACE+"addBag", map);
	}
	
	public int addTransaction (TransactionDTO transactionDTO) {
		return sqlSession.insert(NAMESPACE+"addTransaction", transactionDTO);
	}
	
	public int addfile(ItemFileDTO itemFileDTO) {
		return sqlSession.insert(NAMESPACE+"addfile", itemFileDTO);
	}
	
	public Long getNum () {
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}
	
	public int deleteWishList (WishListDTO wishListDTO) {
		return sqlSession.delete(NAMESPACE+"deleteWishList", wishListDTO);
	}
	
	public List<ItemFileDTO> filedetail(ItemDTO itemDTO){
		
		return sqlSession.selectList(NAMESPACE+"filedetail", itemDTO);
	}
	
	public List<WishListDTO> getWishList(UsersDTO usersDTO) {
		return sqlSession.selectList(NAMESPACE+"getWishList", usersDTO);
	}
	
	public WishListDTO getWishListDetail(WishListDTO wishListDTO) {
		return sqlSession.selectOne(NAMESPACE+"getWishListDetail", wishListDTO);
	}

	public List<ItemDTO> getItemList(Map<String, Object> map) {
	
		return sqlSession.selectList(NAMESPACE + "getItemList", map);
	}

	public Integer getTotalCount(Map<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", map);
	}

	public ItemDTO getItemDetail(ItemDTO itemDTO) {
		return sqlSession.selectOne(NAMESPACE + "getItemDetail", itemDTO);
	}

	public int addItem(ItemDTO itemDTO) {
		return sqlSession.insert(NAMESPACE + "addItem", itemDTO);
	}
	
	public List<ItemDTO> checkItemName(ItemDTO itemDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"checkItemName", itemDTO);
	}

	public int updateItem(ItemDTO itemDTO) {
		return sqlSession.update(NAMESPACE + "updateItem", itemDTO);
	}
	
	public int updateItemFile(ItemFileDTO itemFileDTO) {
		return sqlSession.update(NAMESPACE+"updateItemFile", itemFileDTO);
	}

	public int deleteItem(ItemDTO itemDTO) {
		return sqlSession.update(NAMESPACE + "deleteItem", itemDTO);
	}
	
	public int addWishList(WishListDTO wishListDTO) {
		return sqlSession.insert(NAMESPACE+"addWishList", wishListDTO);
	}

}
