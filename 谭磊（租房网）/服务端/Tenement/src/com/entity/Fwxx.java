package com.entity;

/**
 * @author Administrator ������Ϣ
 */
public class Fwxx {

	/**
	 * ����ID
	 */
	private Integer fwid;
	/**
	 * �û�ID
	 */
	private Integer uid;
	/**
	 * �ֵ�ID
	 */
	private Integer jdid;
	/**
	 * ����DI
	 */
	private Integer lxid;
	/**
	 * ��
	 */
	private Integer shi;
	/**
	 * ��
	 */
	private Integer ting;
	/**
	 * ������Ϣ
	 */
	private String fwxx;
	/**
	 * �ʽ�
	 */
	private Integer zj;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ʱ��
	 */
	private String date;
	/**
	 * �ֻ�
	 */
	private String telephone;
	/**
	 * ��ϵ��
	 */
	private String lxr;
	/**
	 * ����ͼƬ
	 */
	private String img;

	public Integer getFwid() {
		return fwid;
	}

	public void setFwid(Integer fwid) {
		this.fwid = fwid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getJdid() {
		return jdid;
	}

	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}

	public Integer getLxid() {
		return lxid;
	}

	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}

	public Integer getShi() {
		return shi;
	}

	public void setShi(Integer shi) {
		this.shi = shi;
	}

	public Integer getTing() {
		return ting;
	}

	public void setTing(Integer ting) {
		this.ting = ting;
	}

	public String getFwxx() {
		return fwxx;
	}

	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}

	public Integer getZj() {
		return zj;
	}

	public void setZj(Integer zj) {
		this.zj = zj;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Fwxx [date=" + date + ", fwid=" + fwid + ", fwxx=" + fwxx
				+ ", img=" + img + ", jdid=" + jdid + ", lxid=" + lxid
				+ ", lxr=" + lxr + ", shi=" + shi + ", telephone=" + telephone
				+ ", ting=" + ting + ", title=" + title + ", uid=" + uid
				+ ", zj=" + zj + "]";
	}

}
