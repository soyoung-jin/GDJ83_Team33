package com.team3.tamagochi.store;

public class WishListDTO {
	private Long wishlist_num;
	private String user_id;
	private Long item_num;
	private ItemDTO itemDTO;
	
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public Long getItem_num() {
		return item_num;
	}
	public void setItem_num(Long item_num) {
		this.item_num = item_num;
	}
	public Long getWishlist_num() {
		return wishlist_num;
	}
	public void setWishlist_num(Long wishlist_num) {
		this.wishlist_num = wishlist_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
