package com.entity;

/**
 * @author Administrator �û�
 */
public class User {

	/**
	 * �û�ID
	 */
	private Integer uid;
	/**
	 * �û�����
	 */
	private String uname;
	/**
	 * �û���¼�˺�
	 */
	private String ulogin;
	/**
	 * �û�����
	 */
	private String upass;
	/**
	 * �û�ͷ��
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
