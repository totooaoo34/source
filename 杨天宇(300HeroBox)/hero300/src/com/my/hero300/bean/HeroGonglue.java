package com.my.hero300.bean;

import java.io.Serializable;

public class HeroGonglue implements Serializable{
	
	
	
	public HeroGonglue(int gid, String title, String webPath, String type) {
		super();
		Gid = gid;
		this.title = title;
		this.webPath = webPath;
		this.type = type;
	}
	public int Gid;
	public String title;
	public String webPath;
	public String type;
	public int getGid() {
		return Gid;
	}
	public void setGid(int gid) {
		Gid = gid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWebPath() {
		return webPath;
	}
	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
}
