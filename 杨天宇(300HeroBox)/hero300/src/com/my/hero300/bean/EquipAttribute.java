package com.my.hero300.bean;

import java.io.Serializable;

public class EquipAttribute implements Serializable{
	
	public EquipAttribute(){}
			
			//生命值
			public double Hp;
			//魔法值
			public double Mp;
			//生命回复速度/5s
			public double HpRegen;
			//魔法回复速度/5s
			public double MpRegen;
			//攻击力 AttackDamage
			public double AD;
			//护甲穿透 ArmorPenetration
			public double ARP;
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
			//法术吸血 SpellVamp
			public double SV;
			//冷却缩减 CoolDown
			public double CD;
			//护甲  armor
			public double armor;
			//法术抗性 SpellResistance
			public double SR;
			//移动速度 MovementSpeed
			public double MS;
			//韧性 tenacity
			public double tenacity;
			//伤害加深 DamageDeepen
			public double DD;
			//伤害减免  DamageReductionPercent
			public double DRP;
			//护甲穿透 百分比ArmorPenetrationPercent
			public double ARPP;
			//法术穿透百分比 SpellPenetrationPercent
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
