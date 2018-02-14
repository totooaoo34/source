package com.my.hero300.bean;

import java.io.Serializable;

public class HeroSimpleAttr implements Serializable{
	
	
	
	public HeroSimpleAttr(int shengming, int gongji, int fashu, int tuandui,
			int caozuo) {
		super();
		this.shengming = shengming;
		this.gongji = gongji;
		this.fashu = fashu;
		this.tuandui = tuandui;
		this.caozuo = caozuo;
	}
	public int shengming;
	public int gongji;
	public int fashu;
	public int tuandui;
	public int caozuo;
	public int getShengming() {
		return shengming;
	}
	public void setShengming(int shengming) {
		this.shengming = shengming;
	}
	public int getGongji() {
		return gongji;
	}
	public void setGongji(int gongji) {
		this.gongji = gongji;
	}
	public int getFashu() {
		return fashu;
	}
	public void setFashu(int fashu) {
		this.fashu = fashu;
	}
	public int getTuandui() {
		return tuandui;
	}
	public void setTuandui(int tuandui) {
		this.tuandui = tuandui;
	}
	public int getCaozuo() {
		return caozuo;
	}
	public void setCaozuo(int caozuo) {
		this.caozuo = caozuo;
	}
	
	
}
