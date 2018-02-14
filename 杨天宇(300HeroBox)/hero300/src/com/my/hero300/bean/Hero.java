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

	//Ӣ��id
	public int id;
	//Ӣ������
	public String HeroName;
	//����ƴ��
	public String NamePinyin;
	//Ӣ�ۼ��
	public String HeroDes;
	//Ӣ�۶�λ
	public String HeroPosition;
	//ͼƬ·��
	public int PicPath;
	//���Լ��
	public HeroSimpleAttr HeroSimpleAttr;
	//����
	public HeroAttribute HeroAttr;
	//����
	public List<Skill> Skills;
	//װ��
	public List<Equip> Equips;
	//����
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
