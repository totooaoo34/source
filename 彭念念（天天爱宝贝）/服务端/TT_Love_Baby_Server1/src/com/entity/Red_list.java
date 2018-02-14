package com.entity;

import java.sql.Date;

public class Red_list {
	private int Red_id;
	private int U_id;
	private String Red_content;
	private Date Red_date;
	public int getRed_id() {
		return Red_id;
	}
	public void setRed_id(int redId) {
		Red_id = redId;
	}
	public int getU_id() {
		return U_id;
	}
	public void setU_id(int uId) {
		U_id = uId;
	}
	public String getRed_content() {
		return Red_content;
	}
	public void setRed_content(String redContent) {
		Red_content = redContent;
	}
	public Date getRed_date() {
		return Red_date;
	}
	public void setRed_date(Date redDate) {
		Red_date = redDate;
	}
	@Override
	public String toString() {
		return "Red_list [Red_content=" + Red_content + ", Red_date="
				+ Red_date + ", Red_id=" + Red_id + ", U_id=" + U_id + "]";
	}
	
	
}
