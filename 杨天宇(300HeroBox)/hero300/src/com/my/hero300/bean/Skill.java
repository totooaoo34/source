package com.my.hero300.bean;


import java.io.Serializable;


public class Skill implements Serializable{
	
	public Skill(String skillName, int skillPath, String skillDetail,
			String skillType, String skillConsume, String skillCD) {
		super();
		SkillName = skillName;
		SkillPath = skillPath;
		SkillDetail = skillDetail;
		SkillType = skillType;
		SkillConsume = skillConsume;
		SkillCD = skillCD;
	}
	//技能名字
	public String SkillName;
	//技能图片
	public int SkillPath;
	//技能详情介绍
	public String SkillDetail;
	//技能类型
	public String SkillType;
	//技能消耗
	public String SkillConsume;
	//技能CD
	public String SkillCD;
	public String getSkillName() {
		return SkillName;
	}
	public void setSkillName(String skillName) {
		SkillName = skillName;
	}
	public int getSkillPath() {
		return SkillPath;
	}
	public void setSkillPath(int skillPath) {
		SkillPath = skillPath;
	}
	public String getSkillDetail() {
		return SkillDetail;
	}
	public void setSkillDetail(String skillDetail) {
		SkillDetail = skillDetail;
	}
	public String getSkillType() {
		return SkillType;
	}
	public void setSkillType(String skillType) {
		SkillType = skillType;
	}
	public String getSkillConsume() {
		return SkillConsume;
	}
	public void setSkillConsume(String skillConsume) {
		SkillConsume = skillConsume;
	}
	public String getSkillCD() {
		return SkillCD;
	}
	public void setSkillCD(String skillCD) {
		SkillCD = skillCD;
	}
	
}
