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
		//�ȼ�
		public int level;
		//����ֵ
		public double Hp;
		//ħ��ֵ
		public double Mp;
		//������ AttackDamage
		public double AD;
		//���״�͸ ArmorPenetration
		public double ARP;
		//���״�͸ �ٷֱ�ArmorPenetrationPercent
		public double ARPP;
		//����͵ȡ LifeSteal
		public double LS; 
		//�����ٶ� AttackSpeed
		public double AS;
		//������ CriticalHit
		public double CH;
		//����ǿ�� AbilityPower 
		public double AP;
		//������͸ SpellPenetration
		public double SP;
		//������͸�ٷֱ� SpellPenetrationPercent
		public double SPP;
		//������Ѫ SpellVamp
		public double SV;
		//��ȴ���� CoolDown
		public double CD;
		//����  armor
		public double armor;
		//�������� SpellResistance
		public double SR;
		//�������� AttackRange
		public double AR;
		//�ƶ��ٶ� MovementSpeed
		public double MS;
		
		//������ȼ�����
		public double HpPerLevel;
		//ħ����ȼ�����
		public double MpPerLevel;
		//������ȼ�����
		public double armorPerLevel;
		//����������ȼ�����
		public double SRPerLevel;
		//��������ȼ�����
		public double ADPerLevel;
		//����ǿ����ȼ�����
		public double APPerLevel;
		//��ȴ������ȼ�����
		public double CDPerLevel;
		//�����ٶ���ȼ�����
		public double ASPerLevel;
		//�ƶ��ٶ���ȼ�����
		public double MSPerLevel;
		//���״�͸��ȼ�����
		public double ARPPerLevel;
		//������͸��ȼ�����
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
		//�ȼ�������toLevel
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
