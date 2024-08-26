package com.team3.tamagochi.userboard;

import java.sql.Date;

public class UserBoardDTO {
	
	private Long userboard_num;
	private String user_id;
	private String userboard_title;
	private Date userboard_create_date;
	private Long userboard_hit;
	private String userboard_contents;
	
	private Long userboard_ref;
	private Long userboard_step;
	private Long userboard_depth;
	private Integer userboard_del;
	
	public Long getUserboard_num() {
		return userboard_num;
	}
	
	public void setUserboard_num(Long userboard_num) {
		this.userboard_num = userboard_num;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUserboard_title() {
		return userboard_title;
	}
	
	public void setUserboard_title(String userboard_title) {
		this.userboard_title = userboard_title;
	}
	
	public Date getUserboard_create_date() {
		return userboard_create_date;
	}
	
	public void setUserboard_create_date(Date userboard_create_date) {
		this.userboard_create_date = userboard_create_date;
	}
	
	public Long getUserboard_hit() {
		return userboard_hit;
	}
	
	public void setUserboard_hit(Long userboard_hit) {
		this.userboard_hit = userboard_hit;
	}
	
	public String getUserboard_contents() {
		return userboard_contents;
	}
	
	public void setUserboard_contents(String userboard_contents) {
		this.userboard_contents = userboard_contents;
	}
	
	public Long getUserboard_ref() {
		return userboard_ref;
	}
	
	public void setUserboard_ref(Long userboard_ref) {
		this.userboard_ref = userboard_ref;
	}
	
	public Long getUserboard_step() {
		return userboard_step;
	}
	
	public void setUserboard_step(Long userboard_step) {
		this.userboard_step = userboard_step;
	}
	
	public Long getUserboard_depth() {
		return userboard_depth;
	}
	
	public void setUserboard_depth(Long userboard_depth) {
		this.userboard_depth = userboard_depth;
	}
	
	public Integer getUserboard_del() {
		return userboard_del;
	}
	
	public void setUserboard_del(Integer userboard_del) {
		this.userboard_del = userboard_del;
	}

}
