package com.team3.tamagochi.users;


public class InventoryDTO {
	
	private Long inventory_num;
	private Long item_num;
	private String user_id;

	
	
	public Long getItem_num() {
		return item_num;
	}
	public void setItem_num(Long item_num) {
		this.item_num = item_num;
	}
	public Long getInventory_num() {
		return inventory_num;
	}
	public void setInventory_num(Long inventory_num) {
		this.inventory_num = inventory_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
