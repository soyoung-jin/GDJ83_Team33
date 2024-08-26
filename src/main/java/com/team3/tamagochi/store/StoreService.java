package com.team3.tamagochi.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team3.tamagochi.boards.util.Pager;
import com.team3.tamagochi.files.FileManager;
import com.team3.tamagochi.users.TransactionDTO;
import com.team3.tamagochi.users.UsersDTO;

@Service
public class StoreService {

	@Autowired
	StoreDAO storeDAO;

	@Autowired
	FileManager fileManager;

	public int addTransaction(TransactionDTO transactionDTO) {
		int result = storeDAO.addTransaction(transactionDTO);

		if (result > 0) {
			ItemDTO itemDTO = new ItemDTO();

			itemDTO.setItem_num(transactionDTO.getItem_num());

			itemDTO = storeDAO.getItemDetail(itemDTO);
			String id = transactionDTO.getUser_id();

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", id);
			map.put("itemDTO", itemDTO);

			System.out.println(itemDTO.getItem_hp());

			// 결제내역 DB저장 정상 > 캐릭터, 무기 저장
			result = storeDAO.addBag(map);
		}

		return result;
	}

	public List<WishListDTO> getWishList(UsersDTO usersDTO) {
		return storeDAO.getWishList(usersDTO);
	}
	
	public WishListDTO getWishListDetail(WishListDTO wishListDTO) {
		
	    wishListDTO = storeDAO.getWishListDetail(wishListDTO);
	    ItemDTO itemDTO =  new ItemDTO();
	    
	    itemDTO.setItem_num(wishListDTO.getItem_num());
	    
	    itemDTO = storeDAO.getItemDetail(itemDTO);
	    
	    wishListDTO.setItemDTO(itemDTO);
		
		return wishListDTO;
	}

	public int deleteWishList(WishListDTO wishListDTO) {
		return storeDAO.deleteWishList(wishListDTO);
	}


	public List<ItemDTO> getItemList(ItemDTO itemDTO, Pager pager) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("itemDTO", itemDTO);
		map.put("pager", pager);

		pager.makerow();

		Integer totalCount = storeDAO.getTotalCount(map);

		if (totalCount == 0) {
			return null;
		}

		pager.makeNum(totalCount);
		
		List<ItemDTO> result = storeDAO.getItemList(map);
		
		//아이템 이미지 파일 정보를 따로 조회 가져옴
		for(ItemDTO dto: result) {
			dto.setItemFileDTOs(storeDAO.filedetail(dto));
		}

		return result;
	}

	public ItemDTO getItemDetail(ItemDTO itemDTO) throws Exception {

		return storeDAO.getItemDetail(itemDTO);
	}

	public int addItem(ItemDTO itemDTO, MultipartFile[] files, HttpSession session) throws Exception {

		Long num = storeDAO.getNum();
		itemDTO.setItem_num(num);
		int result = storeDAO.addItem(itemDTO);

		for (MultipartFile file : files) {

			if (file == null) {
				return result;
			}

			ServletContext servletContext = session.getServletContext();
			String path = servletContext.getRealPath("/resources/img/item");

			String filename = fileManager.fileSave(file, path);

			ItemFileDTO itemFileDTO = new ItemFileDTO();

			itemFileDTO.setFile_name(filename);
			itemFileDTO.setOri_name(file.getOriginalFilename());
			itemFileDTO.setItem_num(num);

			result = storeDAO.addfile(itemFileDTO);
		}

		return result;
	}

	public int updateItem(ItemDTO itemDTO, MultipartFile[] files, HttpSession session) throws Exception {
		
		int result = storeDAO.updateItem(itemDTO);
		
		//위의 아이템 내용 업데이트 완료 > 이미지 파일 처리
			
			//이미지 저장될 실제 경로
			String path = session.getServletContext().getRealPath("/resources/img/item");
			
			//수정할 아이템의 이미지파일 경로 가져오기
			List<ItemFileDTO> itemFileDTO = storeDAO.filedetail(itemDTO);
			
			//매개변수로 받아온 이미지 파일 개수만큼 반복
			for(int i=0;i<files.length;i++) {
				String filename="";
				ItemFileDTO dto = new ItemFileDTO();
				
				filename = fileManager.fileSave(files[i], path);
				
				dto.setOri_name(files[i].getOriginalFilename());
				dto.setFile_name(filename);
				dto.setItem_num(itemDTO.getItem_num());
			
				//매개변수로 받아오는 이미지 개수와 파일테이블의 개수가 다르면 새로 추가 같으면 업데이트
				
				if(itemFileDTO.size()!= files.length) {
					if(!itemFileDTO.isEmpty()) {
						dto.setFile_num(itemFileDTO.get(i).getFile_num());
						result = storeDAO.updateItemFile(dto);
					} else {
						result = storeDAO.addfile(dto);
					}
				} else {
					dto.setFile_num(itemFileDTO.get(i).getFile_num());
					fileManager.fileDelete(itemFileDTO.get(i), path);
					result = storeDAO.updateItemFile(dto);
				}
				
			}
			//매개변수로 받아온 이미지 파일 개수만큼 반복
		//위의 아이템 내용 업데이트 완료 > 이미지 파일 처리
		
		return result;
	}

	public int deleteItem(ItemDTO itemDTO) {

		return storeDAO.deleteItem(itemDTO);
	}

	public int addWishList(WishListDTO wishListDTO) {
		return storeDAO.addWishList(wishListDTO);
	}

}
