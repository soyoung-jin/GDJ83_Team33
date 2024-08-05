package com.team3.tamagochi.boards;

import java.sql.Date;

public class BoardDTO {
	private Long board_num;
	private String user_id;
	private String board_title;
	private Date board_create_date;
	private Long board_hit;
	private String board_contents;

	public Long getBoard_num() {
		return board_num;
	}

	public void setBoard_num(Long board_num) {
		this.board_num = board_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public Date getBoard_create_date() {
		return board_create_date;
	}

	public void setBoard_create_date(Date board_create_date) {
		this.board_create_date = board_create_date;
	}

	public Long getBoard_hit() {
		return board_hit;
	}

	public void setBoard_hit(Long board_hit) {
		this.board_hit = board_hit;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

}
