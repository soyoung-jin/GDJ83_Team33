package com.team3.tamagochi.record;

import java.sql.Date;

public class RecordDTO {
	private Long record_num;
	private Long pet_num;
	private Integer record_outcome;
	private Long record_enemy_num;
	private Date record_date;
	
	
	public Long getRecord_num() {
		return record_num;
	}
	public void setRecord_num(Long record_num) {
		this.record_num = record_num;
	}
	public Long getPet_num() {
		return pet_num;
	}
	public void setPet_num(Long pet_num) {
		this.pet_num = pet_num;
	}
	public Integer getRecord_outcome() {
		return record_outcome;
	}
	public void setRecord_outcome(Integer record_outcome) {
		this.record_outcome = record_outcome;
	}
	public Long getRecord_enemy_num() {
		return record_enemy_num;
	}
	public void setRecord_enemy_num(Long record_enemy_num) {
		this.record_enemy_num = record_enemy_num;
	}
	public Date getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}
	
}
