package com.my.hero300.bean;

import java.io.Serializable;

public class EquipAttribute implements Serializable{
	
	public EquipAttribute(){}
			
			//����ֵ
			public double Hp;
			//ħ��ֵ
			public double Mp;
			//�����ظ��ٶ�/5s
			public double HpRegen;
			//ħ���ظ��ٶ�/5s
			public double MpRegen;
			//������ AttackDamage
			public double AD;
			//���״�͸ ArmorPenetration
			public double ARP;
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
			//������Ѫ SpellVamp
			public double SV;
			//��ȴ���� CoolDown
			public double CD;
			//����  armor
			public double armor;
			//�������� SpellResistance
			public double SR;
			//�ƶ��ٶ� MovementSpeed
			public double MS;
			//���� tenacity
			public double tenacity;
			//�˺����� DamageDeepen
			public double DD;
			//�˺�����  DamageReductionPercent
			public double DRP;
			//���״�͸ �ٷֱ�ArmorPenetrationPercent
			public double ARPP;
			//������͸�ٷֱ� SpellPenetrationPercent
			public double SPP;
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
			public double getHpRegen() {
				return HpRegen;
			}
			public void setHpRegen(double hpRegen) {
				HpRegen = hpRegen;
			}
			public double getMpRegen() {
				return MpRegen;
			}
			public void setMpRegen(double mpRegen) {
				MpRegen = mpRegen;
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
			public double getMS() {
				return MS;
			}
			public void setMS(double mS) {
				MS = mS;
			}
			public double getTenacity() {
				return tenacity;
			}
			public void setTenacity(double tenacity) {
				this.tenacity = tenacity;
			}
			public double getDD() {
				return DD;
			}
			public void setDD(double dD) {
				DD = dD;
			}
			public double getDRP() {
				return DRP;
			}
			public void setDRP(double dRP) {
				DRP = dRP;
			}
			
			
}
