package com.team3.tamagochi.mypet;

import com.team3.tamagochi.users.UsersDTO;

public class MyPetDTO {
	
	private Long pet_num;
	private String user_id;
	private Long item_num;
	private String pet_name;
	private String pet_spc;
	private Long pet_exp;
	private Long pet_level;
	private Long pet_hp;
	private Long pet_atk;
	private Long pet_dod;
	private Long pet_pop;
	private Long pet_hungry;
	private Integer pet_selected;
	private Long pet_washroom;
	private Long add_hp;
	private Long add_atk;
	private Long add_dod;
	private Long equip_num;
	private Long pet_evolution;
	
	public Long getPet_evolution() {
		return pet_evolution;
	}
	public void setPet_evolution(Long pet_evolution) {
		this.pet_evolution = pet_evolution;
	}
	private UsersDTO usersDTO;
	
	
	
	
	public Long getEquip_num() {
		return equip_num;
	}
	public void setEquip_num(Long equip_num) {
		this.equip_num = equip_num;
	}
	public Long getPet_washroom() {
		return pet_washroom;
	}
	public void setPet_washroom(Long pet_washroom) {
		this.pet_washroom = pet_washroom;
	}
	public Long getAdd_hp() {
		return add_hp;
	}
	public void setAdd_hp(Long add_hp) {
		this.add_hp = add_hp;
	}
	public Long getAdd_atk() {
		return add_atk;
	}
	public void setAdd_atk(Long add_atk) {
		this.add_atk = add_atk;
	}
	public Long getAdd_dod() {
		return add_dod;
	}
	public void setAdd_dod(Long add_dod) {
		this.add_dod = add_dod;
	}
	public Integer getPet_selected() {
		return pet_selected;
	}
	public void setPet_selected(Integer pet_selected) {
		this.pet_selected = pet_selected;
	}
	public Long getItem_num() {
		return item_num;
	}
	public void setItem_num(Long item_num) {
		this.item_num = item_num;
	}
	public Long getPet_num() {
		return pet_num;
	}
	public void setPet_num(Long pet_num) {
		this.pet_num = pet_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public String getPet_spc() {
		return pet_spc;
	}
	public void setPet_spc(String pet_spc) {
		this.pet_spc = pet_spc;
	}
	public Long getPet_exp() {
		return pet_exp;
	}
	public void setPet_exp(Long pet_exp) {
		this.pet_exp = pet_exp;
	}
	public Long getPet_level() {
		return pet_level;
	}
	public void setPet_level(Long pet_level) {
		this.pet_level = pet_level;
	}
	public Long getPet_hp() {
		return pet_hp;
	}
	public void setPet_hp(Long pet_hp) {
		this.pet_hp = pet_hp;
	}
	public Long getPet_atk() {
		return pet_atk;
	}
	public void setPet_atk(Long pet_atk) {
		this.pet_atk = pet_atk;
	}
	public Long getPet_dod() {
		return pet_dod;
	}
	public void setPet_dod(Long pet_dod) {
		this.pet_dod = pet_dod;
	}
	public Long getPet_pop() {
		return pet_pop;
	}
	public void setPet_pop(Long pet_pop) {
		this.pet_pop = pet_pop;
	}
	public Long getPet_hungry() {
		return pet_hungry;
	}
	public void setPet_hungry(Long pet_hungry) {
		this.pet_hungry = pet_hungry;
	}
	public UsersDTO getUsersDTO() {
		return usersDTO;
	}
	public void setUsersDTO(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}
	
	
	
	

}
