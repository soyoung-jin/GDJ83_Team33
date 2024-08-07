package com.team3.tamagochi.store;

public class WeaponDTO extends ItemDTO {
	
	private Long weapon_num;
	
	private String weapon_description;
	
	private InventoryDTO inventoryDTO;
	

	public InventoryDTO getInventoryDTO() {
		return inventoryDTO;
	}
	public void setInventoryDTO(InventoryDTO inventoryDTO) {
		this.inventoryDTO = inventoryDTO;
	}
	public Long getWeapon_num() {
		return weapon_num;
	}
	public void setWeapon_num(Long weapon_num) {
		this.weapon_num = weapon_num;
	}
	public String getWeapon_description() {
		return weapon_description;
	}
	public void setWeapon_description(String weapon_description) {
		this.weapon_description = weapon_description;
	}

	
}
