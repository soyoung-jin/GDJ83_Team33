package com.team3.tamagochi.users;

public class InventoryDTO {
	
	private Long inventory_num;
	private Long weapon_num;
	private String user_id;
	
	
	public Long getInventory_num() {
		return inventory_num;
	}
	public void setInventory_num(Long inventory_num) {
		this.inventory_num = inventory_num;
	}
	public Long getWeapon_num() {
		return weapon_num;
	}
	public void setWeapon_num(Long weapon_num) {
		this.weapon_num = weapon_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
