package com.entity;

/**
 * @author Administrator 用户
 */
public class User {

	/**
	 * 用户ID
	 */
	private Integer uid;
	/**
	 * 用户姓名
	 */
	private String uname;
	/**
	 * 用户登录账号
	 */
	private String ulogin;
	/**
	 * 用户密码
	 */
	private String upass;
	/**
	 * 用户头像
	 */
	private String uimg;
	/**
	 * sessionid
	 */
	private String usessionid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUlogin() {
		return ulogin;
	}

	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getUsessionid() {
		return usessionid;
	}

	public void setUsessionid(String usessionid) {
		this.usessionid = usessionid;
	}

}
