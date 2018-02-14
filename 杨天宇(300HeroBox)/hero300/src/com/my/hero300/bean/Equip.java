package com.my.hero300.bean;

import java.io.Serializable;
import java.util.List;

public class Equip implements Serializable{

	public Equip(){}
	
	
		

	public Equip(int eid, String equipName, int picPath, int equipPrice,
			String equipDes, String[] equipType, String[] equipData,
			EquipAttribute equipAttr, int[] efrom, int[] eto) {
		super();
		Eid = eid;
		EquipName = equipName;
		PicPath = picPath;
		EquipPrice = equipPrice;
		EquipDes = equipDes;
		EquipType = equipType;
		EquipData = equipData;
		EquipAttr = equipAttr;
		Efrom = efrom;
		Eto = eto;
	}




	//id
	public int Eid;
	//名称
	public String EquipName;
	//图片
	public int PicPath;
	//价格
	public int EquipPrice;
	//说明
	public String EquipDes;
	//分类
	public String[] EquipType;
	//属性数据
	public String[] EquipData;
	//属性值
	public EquipAttribute EquipAttr;
	//由什么合成
	public int[] Efrom;
	//可以合成什么
	public int[] Eto;
	
	public String[] getEquipType() {
		return EquipType;
	}

	public void setEquipType(String[] equipType) {
		EquipType = equipType;
	}

	public int getPicPath() {
		return PicPath;
	}
	public void setPicPath(int picPath) {
		PicPath = picPath;
	}
	public String[] getEquipData() {
		return EquipData;
	}
	public void setEquipData(String[] equipData) {
		EquipData = equipData;
	}
	public int[] getEfrom() {
		return Efrom;
	}
	public void setEfrom(int[] efrom) {
		Efrom = efrom;
	}
	public int[] getEto() {
		return Eto;
	}
	public void setEto(int[] eto) {
		Eto = eto;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEquipName() {
		return EquipName;
	}
	public void setEquipName(String equipName) {
		EquipName = equipName;
	}
	public int getEquipPrice() {
		return EquipPrice;
	}
	public void setEquipPrice(int equipPrice) {
		EquipPrice = equipPrice;
	}
	public String getEquipDes() {
		return EquipDes;
	}
	public void setEquipDes(String equipDes) {
		EquipDes = equipDes;
	}
	public EquipAttribute getEquipAttr() {
		return EquipAttr;
	}
	public void setEquipAttr(EquipAttribute equipAttr) {
		EquipAttr = equipAttr;
	}
	
	
	
}
