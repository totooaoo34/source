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
	//��������
	public String SkillName;
	//����ͼƬ
	public int SkillPath;
	//�����������
	public String SkillDetail;
	//��������
	public String SkillType;
	//��������
	public String SkillConsume;
	//����CD
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
