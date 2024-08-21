package com.team3.tamagochi.store;

import java.util.List;

import com.team3.tamagochi.users.InventoryDTO;

public class ItemDTO {

	private Long item_num;
	private Long category_num;
	private String item_name;
	private String item_description;
	private Long item_hp;
	private Long item_atk;
	private Long item_dod;
	private Long item_price;
	private Long item_del;
	private InventoryDTO inventoryDTO;
	private List<ItemFileDTO> itemFileDTOs;

	public List<ItemFileDTO> getItemFileDTOs() {
		return itemFileDTOs;
	}

	public void setItemFileDTOs(List<ItemFileDTO> itemFileDTOs) {
		this.itemFileDTOs = itemFileDTOs;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public InventoryDTO getInventoryDTO() {
		return inventoryDTO;
	}

	public void setInventoryDTO(InventoryDTO inventoryDTO) {
		this.inventoryDTO = inventoryDTO;
	}

	public Long getItem_num() {
		return item_num;
	}

	public void setItem_num(Long item_num) {
		this.item_num = item_num;
	}

	public Long getCategory_num() {
		return category_num;
	}

	public void setCategory_num(Long category_num) {
		this.category_num = category_num;
	}

	public Long getItem_del() {
		return item_del;
	}

	public void setItem_del(Long item_del) {
		this.item_del = item_del;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Long getItem_hp() {
		return item_hp;
	}

	public void setItem_hp(Long item_hp) {
		this.item_hp = item_hp;
	}

	public Long getItem_atk() {
		return item_atk;
	}

	public void setItem_atk(Long item_atk) {
		this.item_atk = item_atk;
	}

	public Long getItem_dod() {
		return item_dod;
	}

	public void setItem_dod(Long item_dod) {
		this.item_dod = item_dod;
	}

	public Long getItem_price() {
		return item_price;
	}

	public void setItem_price(Long item_price) {
		this.item_price = item_price;
	}

}
