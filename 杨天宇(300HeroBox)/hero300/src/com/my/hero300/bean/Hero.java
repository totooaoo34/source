package com.my.hero300.bean;

import java.io.Serializable;
import java.util.List;

public class Hero implements Serializable{
	
	

	public Hero(int id, String heroName, String namePinyin, String heroDes,
			String heroPosition, int picPath,
			com.my.hero300.bean.HeroSimpleAttr heroSimpleAttr,
			HeroAttribute heroAttr, List<Skill> skills, List<Equip> equips,
			List<HeroGonglue> heroGonglues) {
		super();
		this.id = id;
		HeroName = heroName;
		NamePinyin = namePinyin;
		HeroDes = heroDes;
		HeroPosition = heroPosition;
		PicPath = picPath;
		HeroSimpleAttr = heroSimpleAttr;
		HeroAttr = heroAttr;
		Skills = skills;
		Equips = equips;
		HeroGonglues = heroGonglues;
	}

	//Ó¢ÐÛid
	public int id;
	//Ó¢ÐÛÃû×Ö
	public String HeroName;
	//Ãû×ÖÆ´Òô
	public String NamePinyin;
	//Ó¢ÐÛ¼ò½é
	public String HeroDes;
	//Ó¢ÐÛ¶¨Î»
	public String HeroPosition;
	//Í¼Æ¬Â·¾¶
	public int PicPath;
	//ÊôÐÔ¼ò½é
	public HeroSimpleAttr HeroSimpleAttr;
	//ÊôÐÔ
	public HeroAttribute HeroAttr;
	//¼¼ÄÜ
	public List<Skill> Skills;
	//×°±¸
	public List<Equip> Equips;
	//¹¥ÂÔ
	public List<HeroGonglue> HeroGonglues;
	
	public List<HeroGonglue> getHeroGonglues() {
		return HeroGonglues;
	}

	public void setHeroGonglues(List<HeroGonglue> heroGonglues) {
		HeroGonglues = heroGonglues;
	}

	public Hero(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeroName() {
		return HeroName;
	}

	public void setHeroName(String heroName) {
		HeroName = heroName;
	}

	public String getNamePinyin() {
		return NamePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		NamePinyin = namePinyin;
	}

	public String getHeroDes() {
		return HeroDes;
	}

	public void setHeroDes(String heroDes) {
		HeroDes = heroDes;
	}

	public int getPicPath() {
		return PicPath;
	}

	public void setPicPath(int picPath) {
		PicPath = picPath;
	}

	public HeroAttribute getHeroAttr() {
		return HeroAttr;
	}

	public void setHeroAttr(HeroAttribute heroAttr) {
		HeroAttr = heroAttr;
	}

	public List<Skill> getSkills() {
		return Skills;
	}

	public void setSkills(List<Skill> skills) {
		Skills = skills;
	}

	public List<Equip> getEquips() {
		return Equips;
	}

	public void setEquips(List<Equip> equips) {
		Equips = equips;
	}

	public String getHeroPosition() {
		return HeroPosition;
	}

	public void setHeroPosition(String heroPosition) {
		HeroPosition = heroPosition;
	}

	public HeroSimpleAttr getHeroSimpleAttr() {
		return HeroSimpleAttr;
	}

	public void setHeroSimpleAttr(HeroSimpleAttr heroSimpleAttr) {
		HeroSimpleAttr = heroSimpleAttr;
	}
	
	

}
