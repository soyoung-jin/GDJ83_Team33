package com.team3.tamagochi.store;

public class WishlistDTO {
	private Long wishlist_num;
	private String user_id;
	private Long character_num;
	private Long weapon_num;
	
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
	public Long getCharacter_num() {
		return character_num;
	}
	public void setCharacter_num(Long character_num) {
		this.character_num = character_num;
	}
	public Long getWeapon_num() {
		return weapon_num;
	}
	public void setWeapon_num(Long weapon_num) {
		this.weapon_num = weapon_num;
	}
	
	
}
