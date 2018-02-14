package com.my.hero300.bean;

import java.io.Serializable;

public class HeroAttribute implements Serializable{

	
		
		public HeroAttribute(int level, double hp, double mp, double aD,
			double aRP, double aRPP, double lS, double aS, double cH,
			double aP, double sP, double sPP, double sV, double cD,
			double armor, double sR, double aR, double mS, double hpPerLevel,
			double mpPerLevel, double armorPerLevel, double sRPerLevel,
			double aDPerLevel, double aPPerLevel, double cDPerLevel,
			double aSPerLevel, double mSPerLevel, double aRPPerLevel,
			double sPPerLevel) {
		super();
		this.level = level;
		Hp = hp;
		Mp = mp;
		AD = aD;
		ARP = aRP;
		ARPP = aRPP;
		LS = lS;
		AS = aS;
		CH = cH;
		AP = aP;
		SP = sP;
		SPP = sPP;
		SV = sV;
		CD = cD;
		this.armor = armor;
		SR = sR;
		AR = aR;
		MS = mS;
		HpPerLevel = hpPerLevel;
		MpPerLevel = mpPerLevel;
		this.armorPerLevel = armorPerLevel;
		SRPerLevel = sRPerLevel;
		ADPerLevel = aDPerLevel;
		APPerLevel = aPPerLevel;
		CDPerLevel = cDPerLevel;
		ASPerLevel = aSPerLevel;
		MSPerLevel = mSPerLevel;
		ARPPerLevel = aRPPerLevel;
		SPPerLevel = sPPerLevel;
	}
		//等级
		public int level;
		//生命值
		public double Hp;
		//魔法值
		public double Mp;
		//攻击力 AttackDamage
		public double AD;
		//护甲穿透 ArmorPenetration
		public double ARP;
		//护甲穿透 百分比ArmorPenetrationPercent
		public double ARPP;
		//生命偷取 LifeSteal
		public double LS; 
		//攻击速度 AttackSpeed
		public double AS;
		//暴击率 CriticalHit
		public double CH;
		//法术强度 AbilityPower 
		public double AP;
		//法术穿透 SpellPenetration
		public double SP;
		//法术穿透百分比 SpellPenetrationPercent
		public double SPP;
		//法术吸血 SpellVamp
		public double SV;
		//冷却缩减 CoolDown
		public double CD;
		//护甲  armor
		public double armor;
		//法术抗性 SpellResistance
		public double SR;
		//攻击距离 AttackRange
		public double AR;
		//移动速度 MovementSpeed
		public double MS;
		
		//生命随等级增加
		public double HpPerLevel;
		//魔法随等级增加
		public double MpPerLevel;
		//护甲随等级增加
		public double armorPerLevel;
		//法术抗性随等级增加
		public double SRPerLevel;
		//物理攻击随等级增加
		public double ADPerLevel;
		//法术强度随等级增加
		public double APPerLevel;
		//冷却缩减随等级增加
		public double CDPerLevel;
		//攻击速度随等级增加
		public double ASPerLevel;
		//移动速度随等级增加
		public double MSPerLevel;
		//护甲穿透随等级增加
		public double ARPPerLevel;
		//法术穿透随等级增加
		public double SPPerLevel;
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public double getHp() {
			return Hp;
		}
		public void setHp(double hp) {
			Hp = hp;
		}
		public double getMp() {
			return Mp;
		}
		public void setMp(double mp) {
			Mp = mp;
		}
		public double getAD() {
			return AD;
		}
		public void setAD(double aD) {
			AD = aD;
		}
		public double getARP() {
			return ARP;
		}
		public void setARP(double aRP) {
			ARP = aRP;
		}
		public double getLS() {
			return LS;
		}
		public void setLS(double lS) {
			LS = lS;
		}
		public double getAS() {
			return AS;
		}
		public void setAS(double aS) {
			AS = aS;
		}
		public double getCH() {
			return CH;
		}
		public void setCH(double cH) {
			CH = cH;
		}
		public double getAP() {
			return AP;
		}
		public void setAP(double aP) {
			AP = aP;
		}
		public double getSP() {
			return SP;
		}
		public void setSP(double sP) {
			SP = sP;
		}
		public double getSV() {
			return SV;
		}
		public void setSV(double sV) {
			SV = sV;
		}
		public double getCD() {
			return CD;
		}
		public void setCD(double cD) {
			CD = cD;
		}
		public double getArmor() {
			return armor;
		}
		public void setArmor(double armor) {
			this.armor = armor;
		}
		public double getSR() {
			return SR;
		}
		public void setSR(double sR) {
			SR = sR;
		}
		public double getAR() {
			return AR;
		}
		public void setAR(double aR) {
			AR = aR;
		}
		public double getMS() {
			return MS;
		}
		public void setMS(double mS) {
			MS = mS;
		}
		
		public double getHpPerLevel() {
			return HpPerLevel;
		}
		public void setHpPerLevel(double hpPerLevel) {
			HpPerLevel = hpPerLevel;
		}
		public double getMpPerLevel() {
			return MpPerLevel;
		}
		public void setMpPerLevel(double mpPerLevel) {
			MpPerLevel = mpPerLevel;
		}
		public double getArmorPerLevel() {
			return armorPerLevel;
		}
		public void setArmorPerLevel(double armorPerLevel) {
			this.armorPerLevel = armorPerLevel;
		}
		public double getSRPerLevel() {
			return SRPerLevel;
		}
		public void setSRPerLevel(double sRPerLevel) {
			SRPerLevel = sRPerLevel;
		}
		public double getADPerLevel() {
			return ADPerLevel;
		}
		public void setADPerLevel(double aDPerLevel) {
			ADPerLevel = aDPerLevel;
		}
		public double getAPPerLevel() {
			return APPerLevel;
		}
		public void setAPPerLevel(double aPPerLevel) {
			APPerLevel = aPPerLevel;
		}
		public double getCDPerLevel() {
			return CDPerLevel;
		}
		public void setCDPerLevel(double cDPerLevel) {
			CDPerLevel = cDPerLevel;
		}
		public double getASPerLevel() {
			return ASPerLevel;
		}
		public void setASPerLevel(double aSPerLevel) {
			ASPerLevel = aSPerLevel;
		}
		public double getMSPerLevel() {
			return MSPerLevel;
		}
		public void setMSPerLevel(double mSPerLevel) {
			MSPerLevel = mSPerLevel;
		}
		public double getARPPerLevel() {
			return ARPPerLevel;
		}
		public void setARPPerLevel(double aRPPerLevel) {
			ARPPerLevel = aRPPerLevel;
		}
		public double getSPPerLevel() {
			return SPPerLevel;
		}
		public void setSPPerLevel(double sPPerLevel) {
			SPPerLevel = sPPerLevel;
		}
		
	
		public double getARPP() {
			return ARPP;
		}
		public void setARPP(double aRPP) {
			ARPP = aRPP;
		}
		public double getSPP() {
			return SPP;
		}
		public void setSPP(double sPP) {
			SPP = sPP;
		}
		//等级提升到toLevel
		public void Level(int toLevel){
			Hp = Hp+HpPerLevel*(toLevel-1);
			Mp = Mp+MpPerLevel*(toLevel-1);
			armor = armor+armorPerLevel*(toLevel-1);
			SR = SR+SRPerLevel*(toLevel-1);
			AD = AD+ADPerLevel*(toLevel-1);
			AP = AP+APPerLevel*(toLevel-1);
			CD = CD+CDPerLevel*(toLevel-1);
			AS = AS+ASPerLevel*(toLevel-1);
			MS = MS+MSPerLevel*(toLevel-1);
			ARP = ARP+ARPPerLevel*(toLevel-1);
			SP = SP+SPPerLevel*(toLevel-1);
		}
}
