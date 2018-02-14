package com.entity;

import java.sql.Date;

public class Ai_student {
	private int S_id;
	private String S_name;
	private String S_sex;
	private int S_age;
	private String S_phone;
	private String S_address;
	private Date S_indate;
	private Date S_outdate;
	private String S_image;
	
	public String getS_image() {
		return S_image;
	}
	public void setS_image(String sImage) {
		S_image = sImage;
	}
	public int getS_id() {
		return S_id;
	}
	public void setS_id(int sId) {
		S_id = sId;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String sName) {
		S_name = sName;
	}
	public String getS_sex() {
		return S_sex;
	}
	public void setS_sex(String sSex) {
		S_sex = sSex;
	}
	public int getS_age() {
		return S_age;
	}
	public void setS_age(int sAge) {
		S_age = sAge;
	}
	public String getS_phone() {
		return S_phone;
	}
	public void setS_phone(String sPhone) {
		S_phone = sPhone;
	}
	public String getS_address() {
		return S_address;
	}
	public void setS_address(String sAddress) {
		S_address = sAddress;
	}
	public Date getS_indate() {
		return S_indate;
	}
	public void setS_indate(Date sIndate) {
		S_indate = sIndate;
	}
	public Date getS_outdate() {
		return S_outdate;
	}
	public void setS_outdate(Date sOutdate) {
		S_outdate = sOutdate;
	}
	@Override
	public String toString() {
		return "Ai_student [S_address=" + S_address + ", S_age=" + S_age
				+ ", S_id=" + S_id + ", S_indate=" + S_indate + ", S_name="
				+ S_name + ", S_outdate=" + S_outdate + ", S_phone=" + S_phone
				+ ", S_sex=" + S_sex + "]";
	}
	
	
}
