package com.team3.tamagochi.friend;

import java.sql.Date;

public class AlarmDTO {
	private Long alarm_num;
	private String user_id;
	private Long item_num;
	private String alarm_sender;
	private Date alarm_received_date;
	private String alarm_contents;
	private int checked;
	
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public Long getAlarm_num() {
		return alarm_num;
	}
	public void setAlarm_num(Long alarm_num) {
		this.alarm_num = alarm_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Long getItem_num() {
		return item_num;
	}
	public void setItem_num(Long item_num) {
		this.item_num = item_num;
	}
	public String getAlarm_sender() {
		return alarm_sender;
	}
	public void setAlarm_sender(String alarm_sender) {
		this.alarm_sender = alarm_sender;
	}
	public Date getAlarm_received_date() {
		return alarm_received_date;
	}
	public void setAlarm_received_date(Date alarm_received_date) {
		this.alarm_received_date = alarm_received_date;
	}
	public String getAlarm_contents() {
		return alarm_contents;
	}
	public void setAlarm_contents(String alarm_contents) {
		this.alarm_contents = alarm_contents;
	}
}
