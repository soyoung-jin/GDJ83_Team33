package com.team3.tamagochi.ingame;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.tamagochi.mypet.MyPetDTO;
import com.team3.tamagochi.store.ItemDTO;
import com.team3.tamagochi.store.ItemFileDTO;
import com.team3.tamagochi.store.StoreService;
import com.team3.tamagochi.users.InventoryDTO;
import com.team3.tamagochi.users.UsersDTO;

@Controller
@RequestMapping("/ingame/*")
public class InGameController {
	
	@Autowired
	private InGameService inGameService;
	
	@Autowired
	private StoreService storeService;
	
	// 캐릭터 이미지 가져오기
	@GetMapping("getImage")
	public ResponseEntity<byte[]> getImage(ItemFileDTO itemFileDTO, HttpSession session) throws Exception {
		System.out.println(itemFileDTO);

		String realPath = session.getServletContext().getRealPath("/resources/img/item");

		File file = new File(realPath, itemFileDTO.getFile_name());

		ResponseEntity<byte[]> result = null;

		HttpHeaders header = new HttpHeaders();

		header.add("Content-type", Files.probeContentType(file.toPath()));

		result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

		return result;
	}
	
	@GetMapping("fight")
	public void fight(HttpSession session, ItemDTO itemDTO, MyPetDTO enemyPetDTO, Model model) throws Exception{
		
		itemDTO = storeService.getItemDetail(itemDTO);
		UsersDTO tempDTO = (UsersDTO) session.getAttribute("users_info");
		// 내 캐릭터
		MyPetDTO myPetDTO = new MyPetDTO();
		myPetDTO.setUser_id(tempDTO.getUser_id());
		myPetDTO = inGameService.getPetStatus(myPetDTO);
		model.addAttribute("myDTO", myPetDTO);
		
		// 내 캐릭터 이미지
		ItemDTO myItemDTO = new ItemDTO();
		itemDTO.setItem_num(myPetDTO.getItem_num());
		itemDTO = storeService.getItemDetail(itemDTO);
		model.addAttribute("myItemFile", itemDTO);
		
		
		
		// 내 무기
		if(myPetDTO.getEquip_num() != null) {
			// myPet에서 equip_num 가져오기
			// inventory_num에 equip_num 넣기
			// inventory_num으로 item_num 찾아오기
			InventoryDTO myInventoryDTO = new InventoryDTO();
			myInventoryDTO.setInventory_num(myPetDTO.getEquip_num());
			
			ItemDTO myWeaponDTO = new ItemDTO();
			myWeaponDTO = inGameService.getItemNumForWeapon(myInventoryDTO);
			myWeaponDTO = storeService.getItemDetail(myWeaponDTO);
			model.addAttribute("myWeaponFile", myWeaponDTO);
			
		}
		
		// 상대 캐릭터
		enemyPetDTO = inGameService.getPetStatus(enemyPetDTO);
		model.addAttribute("enemyDTO", enemyPetDTO);
		ItemDTO enemyItemDTO = new ItemDTO();
		enemyItemDTO.setItem_num(enemyPetDTO.getItem_num());
		enemyItemDTO = storeService.getItemDetail(enemyItemDTO);
		model.addAttribute("enemyItemFile", enemyItemDTO);
		
		// 상대 무기
		if(enemyPetDTO.getEquip_num() != null) {
			// enemyPetDTO에서 equip_num 가져오기
			// inventory_num에 equip_num 넣기
			// inventory_num으로 item_num 찾아오기
			InventoryDTO EnemyInventoryDTO = new InventoryDTO();
			EnemyInventoryDTO.setInventory_num(enemyPetDTO.getEquip_num());
			
			ItemDTO enemyWeaponDTO = new ItemDTO();
			enemyWeaponDTO = inGameService.getItemNumForWeapon(EnemyInventoryDTO);
			enemyWeaponDTO = storeService.getItemDetail(enemyWeaponDTO);
			model.addAttribute("enemyWeaponFile", enemyWeaponDTO);
			
		}
		
		
	}
	
//	
//	@GetMapping("fight")
//	public ResponseEntity<byte[]> fight(ItemFileDTO itemFileDTO, HttpSession session) throws Exception {
//		String realPath = session.getServletContext().getRealPath("/resources/img/item");
//		
//				File file = new File(realPath, itemFileDTO.getFile_name());
//		
//				ResponseEntity<byte[]> result = null;
//		
//				HttpHeaders header = new HttpHeaders();
//		
//				header.add("Content-type", Files.probeContentType(file.toPath()));
//		
//				result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//		
//				return result;
//		
//	}
	
	//<====================펫 정보======================>
	@GetMapping("ingame")
	public void getPetStatus(MyPetDTO myPetDTO, Model model, HttpSession session) throws Exception {
		UsersDTO tempDTO = (UsersDTO) session.getAttribute("users_info");
		myPetDTO.setUser_id(tempDTO.getUser_id());
		myPetDTO = inGameService.getPetStatus(myPetDTO);
		
		
		model.addAttribute("myPetDTO", myPetDTO);
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setItem_num(myPetDTO.getItem_num());
		itemDTO = storeService.getItemDetail(itemDTO);
		model.addAttribute("itemFile", itemDTO);
		
		
	}
	
	//<====================펫 경험치 가져오기, 펫 체크 다시 불러오기======================>
	@GetMapping("checkPetStatus")
	@ResponseBody
	public MyPetDTO getPetExp(MyPetDTO myPetDTO, Model model) throws Exception {
		myPetDTO = inGameService.checkPetStatus(myPetDTO);
		
		return myPetDTO;
	}
	
	
	
	//<====================펫 행동, 펫 체크 다시 불러오기======================>
	//1. 밥
	@GetMapping("feed")
	@ResponseBody
	public MyPetDTO feedPet(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.feedPet(myPetDTO);
		//펫 상태 다시 불러오기
		myPetDTO =inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
	}
	
	//2. 산책
	@GetMapping("stroll")
	@ResponseBody
	public MyPetDTO strollPet(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.strollPet(myPetDTO);
		//펫 상태 다시 불러오기
		myPetDTO =inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
	}
	
	//3. 청소
	@GetMapping("clean")
	@ResponseBody
	public MyPetDTO cleanPet(MyPetDTO myPetDTO) throws Exception {
		int result = inGameService.cleanPet(myPetDTO);
		//펫 상태 다시 불러오기
		myPetDTO = inGameService.checkPetStatus(myPetDTO);
		return myPetDTO;
	}
	
	
	//<====================펫 진화======================>
	@GetMapping("levelUp")
	@ResponseBody
	public MyPetDTO levelUp(MyPetDTO myPetDTO) throws Exception {
		myPetDTO = inGameService.checkPetStatus(myPetDTO);
		
		int result = 0;
		
		if(myPetDTO.getPet_level() == 9 && myPetDTO.getPet_evolution() == 0) {
			result = inGameService.evolutionUp(myPetDTO);
			result = inGameService.levelUp(myPetDTO);
		} else if(myPetDTO.getPet_level() == 29 && myPetDTO.getPet_evolution() == 1) {
			result = inGameService.evolutionUp(myPetDTO);
			result = inGameService.levelUp(myPetDTO);
		} else if(myPetDTO.getPet_level() == 59 && myPetDTO.getPet_evolution() == 2) {
			result = inGameService.evolutionUp(myPetDTO);
			result = inGameService.levelUp(myPetDTO);
		} else {
			result = inGameService.levelUp(myPetDTO);
			
		}

		
		
		return myPetDTO;
		
	}
	
	
	
	
}
