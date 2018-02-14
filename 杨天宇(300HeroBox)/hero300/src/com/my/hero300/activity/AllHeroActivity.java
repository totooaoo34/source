package com.my.hero300.activity;

import java.util.ArrayList;
import java.util.List;

import com.my.hero300.R;
import com.my.hero300.adapter.HeroAdapter;
import com.my.hero300.bean.Hero;
import com.my.hero300.bean.HeroAttribute;
import com.my.hero300.bean.HeroGonglue;
import com.my.hero300.bean.HeroSimpleAttr;
import com.my.hero300.bean.Skill;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AllHeroActivity extends Activity {

	List<Hero> list;
	GridView gv;
	RadioButton rb;
	RadioGroup rg;
	
	Button btn_lunhuan;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero);
		list = loadAllHero();
		init();
		
		rg = (RadioGroup) this.findViewById(R.id.rg_selectposition);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int rbId = group.getCheckedRadioButtonId();
				rb = (RadioButton) AllHeroActivity.this.findViewById(rbId);
				String position =  rb.getText().toString();
				select(position);
				init();
			}
		});
		
		btn_lunhuan = (Button) this.findViewById(R.id.btn_lunhuan);
		btn_lunhuan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(AllHeroActivity.this, AllHero2Activity.class);
				startActivity(intent);
			}
		});
	}
		
		
	
	//初始化加载英雄
	public void init(){
		gv = (GridView) this.findViewById(R.id.gv_hero);
		HeroAdapter adapter = new HeroAdapter(this, list);
		gv.setAdapter(adapter);
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("Hero", list.get(position));
				intent.setClass(AllHeroActivity.this, HeroDetailActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
	
	//根据定位筛选英雄
	public List<Hero> select(String position){
		list = loadAllHero();
		if(position.equals("All")){
			return list;
		}
		for (int i = list.size()-1; i >= 0 ; i--) {
			if(!list.get(i).getHeroPosition().equals(position)){
				list.remove(i);
			}
		}
		return list;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_hero, menu);
		return true;
	}

	
	//加载英雄数据
	public static List<Hero> loadAllHero(){
		List<Hero> mlist = new ArrayList<Hero>();
		Hero xiaoniaoyouliuhua = new Hero();
		xiaoniaoyouliuhua.setId(0);
		xiaoniaoyouliuhua.setHeroName("小鸟游六花");
		xiaoniaoyouliuhua.setNamePinyin("xiaoniaoyouliuhua");
		xiaoniaoyouliuhua.setHeroPosition("AP");
		xiaoniaoyouliuhua.setHeroDes("《中二病而要谈恋爱》中的主人公，自我设定为“邪王真眼使”的中二病患者。右眼戴着金色的彩瞳，并总是戴着眼罩。因为“红色的果实会降低魔力”这样的理由，不喜欢番茄之类的食物。以名为“漆黑泽克斯原始型第二”的自动伞为“武器”，拥有名为“永恒之枪”的攻击和“漆黑之盾”的防御。与勇太、五月七日、凸守、丹生谷等人组建同好会“远东魔法午睡结社之夏.其实第一次听说要中二我是拒绝的。因为，你不能让我中二，我就马上去中二。第一我要试一下，因为我不愿意中二完了以后加一些特技上去，眼睛“咣”一下，很柔，很亮。这样姐姐一定会骂我，根本没有这样的眼睛，就证明你那个是美瞳。后来我也经过证实我确实是中二的，我中二了几年，感觉很不错。后来我开邪王真眼的时候也要求他们不要加特技，因为我要让勇太看到，我中二以后是这个样子，你中二以后也会是这个样子！");
		xiaoniaoyouliuhua.setPicPath(R.drawable.xiaoniaoyouliuhua);
		xiaoniaoyouliuhua.setHeroAttr(new HeroAttribute(1, 566, 0, 51, 0, 0, 0, 0.64, 0, 0, 0, 0, 0, 0, 15, 30, 1.20, 298, 78, 0, 3, 0, 3, 0, 0, 0.03, 0, 0, 0));
		xiaoniaoyouliuhua.setHeroSimpleAttr(new HeroSimpleAttr(4, 1, 9, 5, 8));
		xiaoniaoyouliuhua.setEquips(null);
		List<Skill> skills_xiaoniaoyouliuhua = new ArrayList<Skill>();
		Skill skill_xiaoniaoyouliuhua_b = new Skill("邪王真眼使", R.drawable.xiaoniaoyouliuhua_b, "六花使用显卡切换来改变自身的作战模式。在Avida/NTi模式下每使用一次技能（不包括显卡切换）减少82/增加122中二度。Avida/NTi模式下的普通攻击减少22/增加22中二度。中二度最高为666，每22中二度增加1%法术强度。显卡切多也会爆，当中二度打到最高时，六花切换为Outel模式，无法使用Avida与NTi模式下的技能，持续5秒，每秒对附近所有敌方单位造成42（+0.62AP）的法术伤害。结束后中二度减少为222.六花死亡后中二度清零", "被动", "无", "无");
		Skill skill_xiaoniaoyouliuhua_q = new Skill("六花，用伞敲/永恒之枪", R.drawable.xiaoniaoyouliuhua_q, "Avida：六花，用伞敲。六花挥伞计费面前扇形区域内所有敌方单位。Nti：永恒之枪！邪王真眼使向指定方向透出闪耀的光之长枪，对命中的所有敌方单位造成62/92/122/152/182法术伤害，若目标处于由Avida模式任意以技能施加的负面状态中，则额外造成22并逐步递加的法术伤害。", "Q", "-88中二度/+122中二度", "8/7/6/5/4");
		Skill skill_xiaoniaoyouliuhua_w = new Skill("六花，丢个伞/漆黑之盾", R.drawable.xiaoniaoyouliuhua_w, "Avida：六花，丢个伞。六花向指定方向扔出伞，飞行1秒，停留1秒，期间命中的所有敌方单位因害怕绊倒而减少42%移动速度，持续2秒。Nti：漆黑之盾！邪王真眼使为自身张开暗之结界，获得一个能吸收22/32/42/52/62%伤害的护盾，持续2秒。护盾小时时对附近所有敌方单位造成62/102/162/222/282法术伤害", "W", "-88中二度/+122中二度", "12");
		Skill skill_xiaoniaoyouliuhua_e = new Skill("六花，跳一下/阿瓦隆粉碎", R.drawable.xiaoniaoyouliuhua_e, "Avida：六花，跳一下。六花跳向指定地点，差点摔倒。这让附近所有地反单位感到非常无语，沉默0.5秒。Nti：阿瓦隆粉碎！邪王真眼使咏唱圣言，对目标区域内所有敌方单位造成62法术伤害，并减少其5%—25%法术抗性，持续3秒。", "E", "-88中二度/+122中二度", "14");
		Skill skill_xiaoniaoyouliuhua_r = new Skill("显卡切换", R.drawable.xiaoniaoyouliuhua_r, "被动：A卡音质好，N卡网速快。六花在Avida模式下获得5%/10%/20%冷却缩减，Nti模式下增加5%/10%/20%移动速度，普通攻击变为远程，伤害类型变为法术且附加法术伤害。两种模式下技能效果不同。主动：六花在Avida显卡与Nti显卡之间切换。Outel模式下无法进行切换。", "R", "无", "5/4/2");
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_b);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_q);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_w);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_e);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_r);
		xiaoniaoyouliuhua.setSkills(skills_xiaoniaoyouliuhua);
		List<HeroGonglue> heroGonglues_xiaoniaoyouliuhua = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_xiaoniaoyouliuhua1 = new HeroGonglue(1, "小鸟游六花边路打法", "http://data.300hero.net/index.php?/web/heroes_article/100", "攻略"); 
		heroGonglues_xiaoniaoyouliuhua.add(gonglue_xiaoniaoyouliuhua1);
		xiaoniaoyouliuhua.setHeroGonglues(heroGonglues_xiaoniaoyouliuhua);
		mlist.add(xiaoniaoyouliuhua);
		
		Hero yikaluosi = new Hero();
		yikaluosi.setId(1);
		yikaluosi.setHeroName("伊卡洛斯");
		yikaluosi.setNamePinyin("yikaluosi");
		yikaluosi.setHeroPosition("AD");
		yikaluosi.setHeroDes("【※】发现身有白翼的女性，拟判断为天使，讯问后得到了否定的答案。该女性正在食用一种浸泡于红色液体内的块状物（麻婆豆腐）。【※】发现身有金属双翼的女性，拟判断为天使，询问后得到了否定的答案。了解其经历后命名为“永久被俘人形兵器Athena”。然后被打了。【※】发现身有黑翼的女性，拟判断为天使，询问后得到了否定的答案。该女性自名恶魔，并且开始宣传一套据称为“人类感情极致”的危险恋爱观。【※】发现西瓜-----观察记录暂时终止，恢复时间未定。");
		yikaluosi.setPicPath(R.drawable.yikaluosi);
		yikaluosi.setHeroAttr(new HeroAttribute(1, 560, 298, 53, 0, 0, 0, 0.67, 0, 0, 0, 0, 0, 0, 15, 30, 5.30, 300, 77, 38, 3.5, 0, 3, 0, 0, 0.03, 0, 0, 0));
		yikaluosi.setHeroSimpleAttr(new HeroSimpleAttr(6, 9, 0, 5, 5));
		yikaluosi.setEquips(null);
		List<Skill> skills_yikaluosi = new ArrayList<Skill>();
		Skill skill_yikaluosi_b = new Skill("可变式羽翼系统", R.drawable.yikaluosi_b, "伊卡洛斯每次施放技能时羽翼闪耀变色，增加7%攻击速度与5%移动速度，持续3秒，最高可叠加4层。", "被动", "无", "无");
		Skill skill_yikaluosi_q = new Skill("Artemis", R.drawable.yikaluosi_q, "被动:伊卡洛斯的普通攻击对目标附加1层准星与0.06额外AD*准星数的物理伤害（可以暴击），准星持续4秒，最多叠加12层。主动：伊卡洛斯向指定放下发射一组Artemis导弹，命中敌方英雄后将对其连续发射四组Artemis导弹，每组造成10/15/20/25/30物理伤害，且有70%几率附加1层准星，反之则造成0.2秒眩晕。", "Q", "40/45/50/55/60", "16/14/12/10/8");
		Skill skill_yikaluosi_w = new Skill("Aegis", R.drawable.yikaluosi_w, "被动：伊卡洛斯每进行7次普通攻击，获得Aegis护盾，脱离战斗6秒后消失，并获得6次普攻计数，此后每5秒衰减1层。进行普攻后不再衰减。该护盾可抵挡一次伤害，并在此后1.5秒内持续抵挡30%/35%/40%/45%/50%伤害。（已存在未触发的护盾时不计数）", "W", "无", "无");
		Skill skill_yikaluosi_e = new Skill("Ecarus", R.drawable.yikaluosi_e, "伊卡洛斯向指定地点高速滑翔，此后3秒内增加20%攻击速度，期间第一次普通攻击额外附加20/40/60/80/100（+0.4AD额外）物理伤害与1层准星。", "E", "50", "10");
		Skill skill_yikaluosi_r = new Skill("Apollon", R.drawable.yikaluosi_r, "伊卡洛斯向指定方向射出光箭，对命中的第一个敌方英雄造成100/175/250（+0.7AD额外）物理伤害，4秒内使其受到伤害加深10%/20%/30%。光箭命中英雄后爆裂，4秒内对附近所有敌方单位每0.5秒造成25/35/45（+0.35AD额外）物理伤害", "R", "100/120/140 ", "100/90/80");
		skills_yikaluosi.add(skill_yikaluosi_b);
		skills_yikaluosi.add(skill_yikaluosi_q);
		skills_yikaluosi.add(skill_yikaluosi_w);
		skills_yikaluosi.add(skill_yikaluosi_e);
		skills_yikaluosi.add(skill_yikaluosi_r);
		yikaluosi.setSkills(skills_yikaluosi);
		List<HeroGonglue> heroGonglues_yikaluosi = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_yikaluosi1 = new HeroGonglue(2, "浅谈一些关于伊卡洛斯的心得", "http://data.300hero.net/index.php?/web/heroes_article/137", "攻略"); 
		HeroGonglue gonglue_yikaluosi2 = new HeroGonglue(3, "70%胜率伊卡说一说简单玩法", "http://data.300hero.net/index.php?/web/heroes_article/43", "攻略"); 
		heroGonglues_yikaluosi.add(gonglue_yikaluosi1);
		heroGonglues_yikaluosi.add(gonglue_yikaluosi2);
		yikaluosi.setHeroGonglues(heroGonglues_yikaluosi);
		mlist.add(yikaluosi);
		
		Hero bantianyinshi = new Hero();
		bantianyinshi.setId(2);
		bantianyinshi.setHeroName("坂田银时");
		bantianyinshi.setNamePinyin("bantianyinshi");
		bantianyinshi.setHeroPosition("AD");
		bantianyinshi.setHeroDes("日本动漫《银魂》中的主人公。拥有天然卷白发、红瞳和死鱼般的眼睛。衣着一般是黑色衣裤外罩配白底蓝花和服，腰上永远别着写有洞爷湖字样的木刀.平常为废柴，不时说出肮脏猥亵的话，但其实是个拥有武士魂的男人，坚信并贯彻自己的武士道。过去活跃于后期攘夷活动，以白夜叉之名威震敌我，可谓传说中的人物。被高杉晋助指出与攘夷时代相较，身手似乎变得迟钝，但实力依旧坚强。");
		bantianyinshi.setPicPath(R.drawable.bantianyinshi);
		bantianyinshi.setHeroAttr(new HeroAttribute(1, 565, 322, 55, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 15, 30, 1.40, 300, 85, 42, 3.5, 0, 3.2, 0, 0, 0.03, 0, 0, 0));
		bantianyinshi.setHeroSimpleAttr(new HeroSimpleAttr(5, 8, 0, 5, 3));
		bantianyinshi.setEquips(null);
		List<Skill> skills_bantianyinshi = new ArrayList<Skill>();
		Skill skill_bantianyinshi_b = new Skill("白夜叉(糖尿病)", R.drawable.bantianyinshi_b, "银时每损失5%生命值增加1%攻击力、4%的攻击速度、1%的伤害减免。身为白tang夜niao叉bing，银时被含糖量较高的技能攻击时，额外受到0.4（向下取整）真实伤害。", "被动", "无", "无");
		Skill skill_bantianyinshi_q = new Skill("牙突(抖S)", R.drawable.bantianyinshi_q, "银时向一个敌方单位的弱点（菊花）发起冲锋，对目标造成物理伤害，并使其眩晕（抖M）", "Q", "55/65/75/85/95", "15");
		Skill skill_bantianyinshi_w = new Skill("扰乱(吐槽)", R.drawable.bantianyinshi_w, "银时扰乱（吐槽）一个敌方英雄，造成真是伤害并使其心神不宁（放弃治疗），命中减少100.", "W", "50", "17/16/15/14/13");
		Skill skill_bantianyinshi_e = new Skill("飞剑(鼻屎)", R.drawable.bantianyinshi_e, "银时指定一个敌方单位投出飞剑（鼻屎），造成法术伤害，并使目标流血（恶心），降低其移动速度、护甲、法术抗性。", "E", "50", "10/9/8/7/6");
		Skill skill_bantianyinshi_r = new Skill("阿姆施特朗炮", R.drawable.bantianyinshi_r, "银时召唤阿姆施特朗回旋加速喷气式阿姆施特朗炮，将自己轰击至指定地点，对附近所有地方单位造成物理伤害。", "R", "100/125/150 ", "120");
		skills_bantianyinshi.add(skill_bantianyinshi_b);
		skills_bantianyinshi.add(skill_bantianyinshi_q);
		skills_bantianyinshi.add(skill_bantianyinshi_w);
		skills_bantianyinshi.add(skill_bantianyinshi_e);
		skills_bantianyinshi.add(skill_bantianyinshi_r);
		bantianyinshi.setSkills(skills_bantianyinshi);
		List<HeroGonglue> heroGonglues_bantianyinshi = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_bantianyinshi1 = new HeroGonglue(3, "300英雄银时教学视频", "http://data.300hero.net/index.php?/web/heroes_article/72", "视频"); 
		heroGonglues_bantianyinshi.add(gonglue_bantianyinshi1);
		bantianyinshi.setHeroGonglues(heroGonglues_bantianyinshi);
		mlist.add(bantianyinshi);
		
		Hero yeye = new Hero();
		yeye.setId(3);
		yeye.setHeroName("夜夜");
		yeye.setNamePinyin("yeye");
		yeye.setHeroPosition("Tank");
		yeye.setHeroDes("动漫作品《机巧少女不会受伤》中的女主角之一。她是赤羽雷真的搭档，少女型人形自动人偶，也是“花柳斋”最高级人形“雪月花”的次女“月之少女”。华丽的外表下有着强大的力量，被硝子称为“最适合保护重要之人”的人偶。对雷真毫无羞耻心且有很大程度的幻想，容易吃醋。爱吃的东西是豆沙水果凉粉。");
		yeye.setPicPath(R.drawable.yeye);
		yeye.setHeroAttr(new HeroAttribute(1, 615, 295, 54, 0, 0, 0, 0.65, 0, 0, 0, 0, 0, 0, 15, 30, 1.20, 300, 82, 34, 3.3, 0, 3.1, 1.25, 0, 0.03, 0, 0, 0));
		yeye.setHeroSimpleAttr(new HeroSimpleAttr(8, 8, 0, 3, 4));
		yeye.setEquips(null);
		List<Skill> skills_yeye = new ArrayList<Skill>();
		Skill skill_yeye_b = new Skill("金刚力", R.drawable.yeye_b, "夜夜的牡蛎回路“金刚力”能使自己的体质超硬质化，护甲提升15%，并且护甲15%转化为额外攻击力，竞技场中最多增加75点攻击力。当夜夜的生命值低于30%时，会在8秒内吸收周围800范围内友方英雄当前法力值的4%来恢复自身最大生命值的2%（最多恢复50%的生命值，没有法力值的英雄无法为夜夜提供生命恢复）。", "被动", "无", "180");
		Skill skill_yeye_q = new Skill("破却水月", R.drawable.yeye_q, "夜夜用拳头缓慢的接触敌人身体造成40/70/100/130/160 +（1.3全ad）点物理伤害，并在目标体内爆发一股强力冲击，击退目标周围200范围内的敌人。", "Q", "40", "8/7/6/5/4");
		Skill skill_yeye_w = new Skill("楸木太刀影", R.drawable.yeye_w, "夜夜朝一个方向高速冲锋，撞到第一个目标后会停止，对目标造成 80/140/200/260/320 + (0.8额外ad) 点物理伤害，并眩晕目标1秒。同时在接下来的4秒内，夜夜承受的伤害降低10%/12%/14%/16%/18%。", "W", "80", "18/16/14/12/10");
		Skill skill_yeye_e = new Skill("旋转吧！雪月花/月影红莲", R.drawable.yeye_e, "雪月花：夜夜像旋风一般回转，期间能格挡所有普通攻击，并且无视单位阻挡，持续4秒或格挡3/4/5/6/7次普通攻击。旋转过程中会持续提升移动速度，最高提升30%。旋转期间可以使用二段技能：月影红莲。 月影红莲：夜夜提出令空气都变得炽热的一击，对目标造成50/80/110/140/170 + （0.6全ad）点物理伤害并降低30%移动速度，持续2秒。每格挡一次普通攻击，二段伤害提高10%，旋转期间使用任意普通技能都会中断旋转。", "E", "30/35/40/45/50", "20/18/16/14/12");
		Skill skill_yeye_r = new Skill("红色有角三倍速", R.drawable.yeye_r, "夜夜变身进入”红有三“模式，解除身上所有控制效果，刷新所有普通技能冷却时间，并且获得20%/30%/40%的冷却缩减，提高30%/45%/60%的攻击速度与20%/30%/40%移动速度，持续7/9/11秒。", "R", "100/125/150 ", "120/105/90");
		skills_yeye.add(skill_yeye_b);
		skills_yeye.add(skill_yeye_q);
		skills_yeye.add(skill_yeye_w);
		skills_yeye.add(skill_yeye_e);
		skills_yeye.add(skill_yeye_r);
		yeye.setSkills(skills_yeye);
		List<HeroGonglue> heroGonglues_yeye = new ArrayList<HeroGonglue>();
		yeye.setHeroGonglues(heroGonglues_yeye);
		mlist.add(yeye);
		
		Hero shiliuyexiaoye = new Hero();
		shiliuyexiaoye.setId(4);
		shiliuyexiaoye.setHeroName("十六夜咲夜");
		shiliuyexiaoye.setNamePinyin("shiliuyexiaoye");
		shiliuyexiaoye.setHeroPosition("AP");
		shiliuyexiaoye.setHeroDes("十六夜咲夜是系列作品《东方Project》中的角色，于《东方红魔乡》首次登场。她是住在红魔馆并在里面工作的女仆。是被称之为恶魔之馆的红魔馆中唯一的人类，是女仆们的仆长。她拥有操纵时间的能力。对人类来说，这是一种最高级的强大的能力，并不是通过修行就能得到的。");
		shiliuyexiaoye.setPicPath(R.drawable.shiliuyexiaoye);
		shiliuyexiaoye.setHeroAttr(new HeroAttribute(1, 570, 355, 53, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 15, 30, 5.00, 302, 77, 48, 3.2, 0, 3.0, 0, 0, 0.03, 0, 0, 0));
		shiliuyexiaoye.setHeroSimpleAttr(new HeroSimpleAttr(4, 1, 9, 6, 7));
		shiliuyexiaoye.setEquips(null);
		List<Skill> skills_shiliuyexiaoye = new ArrayList<Skill>();
		Skill skill_shiliuyexiaoye_b = new Skill("女仆助您下楼梯", R.drawable.shiliuyexiaoye_b, "清扫期间，咲夜的单体攻击(普通攻击或“完美潇洒的世界”)将附带效果：在无人知晓的时停中将附近所有地方单位偷偷搬开，但目标不受影响。", "被动", "无", "60");
		Skill skill_shiliuyexiaoye_q = new Skill("完美潇洒的飞刀", R.drawable.shiliuyexiaoye_q, "咲夜指定目标地点后甩出4柄飞刀，从不同方位向目标发射，每柄飞刀对接触的所有地方单位造成法术伤害，对同一目标的伤害衰减70%。伤害：40/70/100/130/160（+0.4AP）", "Q", "45/55/65/75/85", "6/5.5/5/4.5/4");
		Skill skill_shiliuyexiaoye_w = new Skill("完美潇洒的时计", R.drawable.shiliuyexiaoye_w, "咲夜在目标区域投放时计，大幅减少区域内飞弹的移动速度与除咲夜本人外所有单位的移动速度、攻击速度。（飞弹包括大部分飞行道具类技能与远程普通攻击）施法距离：500/550/600/650/700", "W", "80", "22/20/18/16/14");
		Skill skill_shiliuyexiaoye_e = new Skill("完美潇洒的女仆", R.drawable.shiliuyexiaoye_e, "咲夜改变时间流速开始清扫，3秒内增加40%移动速度。期间“完美潇洒的飞刀“可结束清扫，使飞到数量增加一半且第一刀伤害倍增；或使用“完美潇洒的时计”结束清扫，对区域内所有地方单位造成80/120/160/200/240(+0.6AP)", "E", "45/55/65/75/85", "17/16/15/14/13");
		Skill skill_shiliuyexiaoye_r = new Skill("完美潇洒的世界", R.drawable.shiliuyexiaoye_r, "咲夜停止一个敌方英雄的时间，1.5秒内使目标无法移动攻击或是发（不能被解除，不受韧性减免）并对目标甩出大量飞刀。然后时间开始流动，飞刀一起发射，造成法术伤害。伤害:300/400/500(+0.9AP)", "R", "100/125/150 ", "100/80/60");
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_b);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_q);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_w);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_e);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_r);
		shiliuyexiaoye.setSkills(skills_shiliuyexiaoye);
		List<HeroGonglue> heroGonglues_shiliuyexiaoye = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_shiliuyexiaoye1 = new HeroGonglue(4, "容易上手的16，CD流 ", "http://data.300hero.net/index.php?/web/heroes_article/126", "攻略"); 
		heroGonglues_shiliuyexiaoye.add(gonglue_shiliuyexiaoye1);
		shiliuyexiaoye.setHeroGonglues(heroGonglues_shiliuyexiaoye);
		mlist.add(shiliuyexiaoye);
		
		Hero qiangxiziyou = new Hero();
		qiangxiziyou.setId(5);
		qiangxiziyou.setHeroName("强袭自由");
		qiangxiziyou.setNamePinyin("qiangxiziyou");
		qiangxiziyou.setHeroPosition("AD");
		qiangxiziyou.setHeroDes("俯卧在随风起舞的树阴下哭泣，望着那个素不相识的自己：吉他为逝去的人而弹奏，流行因不归之人而陨落。 不要离我而去，即使是这样恳求，也只是换来橙色花瓣的静静摇曳：遗留在稚嫩脸庞上的，掌心中的记忆，已渐远去，指尖弹奏出别离的旋律，依靠在你温柔肩膀上的儿童之心，被呼啸的车轮无情的抛开。吉他弹奏出逝人的叹息，拨弄着心弦无法平静，再未被悲伤沾染的洁白上映出了，摇曳着橙黄花瓣的夏日之影。即使脸庞不再稚嫩，也能跨越那被夕阳染红的沙滩，离别的旋律。在回忆燃烧殆尽的大地上，怀恋的嫩芽正在破土而出，目送拂晓的列车，橙色的花瓣现在又在何处摇曳。 在已迎接过无数次的黎明，再次到来之前，不要熄灭手中的灯火，车轮啊，旋转吧。");
		qiangxiziyou.setPicPath(R.drawable.qiangxiziyou);
		qiangxiziyou.setHeroAttr(new HeroAttribute(1, 640, 270, 57, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 50, 40, 2.00, 300, 70, 45, 3.5, 0, 0, 0, 0, 0.03, 0, 0, 0));
		qiangxiziyou.setHeroSimpleAttr(new HeroSimpleAttr(5, 8, 5, 7, 5));
		qiangxiziyou.setEquips(null);
		List<Skill> skills_qiangxiziyou = new ArrayList<Skill>();
		Skill skill_qiangxiziyou_b = new Skill("GUNDAM", R.drawable.qiangxiziyou_b, "相场装甲提供了良好的防护，GUNDAM拥有更高的初始护甲和魔抗，但防御属性不随等级增长", "被动", "无", "无");
		Skill skill_qiangxiziyou_q = new Skill("高能量高速步枪", R.drawable.qiangxiziyou_q, "被动效果:普通攻击有14/18/22/26/30%概率造成点额外物理伤害(该伤害可以暴击，切换自由模式后概率与额外伤害降低)主动效果:切换为自由模式，获得远程攻击能力，同时开启光压推进系统， 提升2/4/6/8/10%移动速度且无视单位阻挡", "Q", "20", "7");
		Skill skill_qiangxiziyou_w = new Skill("超级龙骑兵系统", R.drawable.qiangxiziyou_w, "对已方英雄:使用光束突击炮组成一个持续2.5的护盾，抵挡所有伤害，若单次伤害大于70/100/130/160/190点(强袭模式下对自己释放的护盾持续时间与效果提高30%)，则护盾崩溃，受到全额伤害。对敌方英雄：发射光束突击炮，每秒持续造成15/25/35/45/55点物理伤害，持续8秒，目标离开自身700范围立刻结束", "W", "80", "20/19/18/17/16");
		Skill skill_qiangxiziyou_e = new Skill("复列相位高速炮", R.drawable.qiangxiziyou_e, "对前方造成一次强光束攻击，造成60/90/120/150/180点真实伤害", "E", "80/90/100/110/120", "10/9.5/9/8.5/8");
		Skill skill_qiangxiziyou_r = new Skill("FULL BURST MODE", R.drawable.qiangxiziyou_r, "多重锁敌，火力全开，锁定目标区域内最多12个单位，施放共12道小光束，并向目标方向施放一道大光束，每道小光束造成85/120/155点真实伤害，对同一单位作用的后续小光束只能造成10%的伤害，大光束造成200/300/400点法术伤害", "R", "100/125/150 ", "120/105/90");
		skills_qiangxiziyou.add(skill_qiangxiziyou_b);
		skills_qiangxiziyou.add(skill_qiangxiziyou_q);
		skills_qiangxiziyou.add(skill_qiangxiziyou_w);
		skills_qiangxiziyou.add(skill_qiangxiziyou_e);
		skills_qiangxiziyou.add(skill_qiangxiziyou_r);
		qiangxiziyou.setSkills(skills_qiangxiziyou);
		List<HeroGonglue> heroGonglues_qiangxiziyou = new ArrayList<HeroGonglue>();
		qiangxiziyou.setHeroGonglues(heroGonglues_qiangxiziyou);
		mlist.add(qiangxiziyou);
		
		Hero xialuote = new Hero();
		xialuote.setId(6);
		xialuote.setHeroName("夏洛特");
		xialuote.setNamePinyin("xialuote");
		xialuote.setHeroPosition("Tank");
		xialuote.setHeroDes("这位大公之女以无双剑技战胜了所有的追求者，为了向更高的境界进军，她踏上了追求剑道的东游之旅。 往佛国参悟慧剑之义、登昆仑领略御剑之道、踏瀛洲夺取奕剑之心。 当她发现世界已至尽头，天下再无可问道之人时，这位惊采绝艳的女子一剑斩开了时空——在原来的世界，玫瑰剑圣破空而去，而在永恒之地，她将走进新的传说。");
		xialuote.setPicPath(R.drawable.xialuote);
		xialuote.setHeroAttr(new HeroAttribute(1, 586, 260, 54, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 18, 30, 1.30, 307, 80, 40, 3.2, 0, 3.5, 1.25, 0, 0.03, 0, 0, 0));
		xialuote.setHeroSimpleAttr(new HeroSimpleAttr(7, 8, 1, 5, 6));
		xialuote.setEquips(null);
		List<Skill> skills_xialuote = new ArrayList<Skill>();
		Skill skill_xialuote_b = new Skill("嗜血修罗", R.drawable.xialuote_b, "攻击夏洛特的敌人降低3点命中，可以叠加5层，持续4秒。", "被动", "无", "无");
		Skill skill_xialuote_q = new Skill("破空剑", R.drawable.xialuote_q, "对目标及其周围最多3个单位发起5次突袭，最终回到目标身边，对每个周围的单位最多只会造成一次伤害，目标会承受剩余的所有次数(后续伤害只会造成10%的伤害)，每次造成80/130/180/230/280点物理伤害", "Q", "50/60/70/80/90", "16/15/14/13/12");
		Skill skill_xialuote_w = new Skill("迅光三角剑", R.drawable.xialuote_w, "被动效果：有10%/12.5%/15%/17.5%/20%的概率招架掉点伤害，并对其反击造成30/55/80/105/130点法术伤害。(内置冷却时间0.5秒）", "W", "无", "无");
		Skill skill_xialuote_e = new Skill("致命三角剑", R.drawable.xialuote_e, "对目标造成30/55/80/105/130点法术伤害。若目标4秒内受到过破空间伤害则对其发起突袭，3秒内造成当前生命值6%/9%/12%/15%/18%的物理伤害(对怪物最多造成600点物理伤害)；否则则减少20%/30%/40%/50%/60%的移动速度，持续1.5秒", "E", "75", "6");
		Skill skill_xialuote_r = new Skill("七星光芒剑", R.drawable.xialuote_r, "对目标英雄造成物理伤害。如果目标生命低于20%，会立刻杀死目标。用这个技能杀死敌方英雄可以立刻刷新技能冷却。", "R", "100", "110/100/90");
		skills_xialuote.add(skill_xialuote_b);
		skills_xialuote.add(skill_xialuote_q);
		skills_xialuote.add(skill_xialuote_w);
		skills_xialuote.add(skill_xialuote_e);
		skills_xialuote.add(skill_xialuote_r);
		xialuote.setSkills(skills_xialuote);
		List<HeroGonglue> heroGonglues_xialuote = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_xialuote1 = new HeroGonglue(5, "浪漫玫瑰剑-夏洛特大型攻略 ", "http://data.300hero.net/index.php?/web/heroes_article/117", "攻略"); 
		heroGonglues_xialuote.add(gonglue_xialuote1);
		xialuote.setHeroGonglues(heroGonglues_xialuote);
		mlist.add(xialuote);
		
		Hero jisixiutei = new Hero();
		jisixiutei.setId(1);
		jisixiutei.setHeroName("姬丝秀忒");
		jisixiutei.setNamePinyin("jisixiutei");
		jisixiutei.setHeroPosition("Tank");
		jisixiutei.setHeroDes("姬丝秀忒送走了忍野忍和阿良良木历之后，开启了新的世界线。她看到另一个世界的自己能够获得幸福，姬丝秀忒决定也进行几次时间旅行，看看是否能够为自己找到幸福。然而在多个时空中，世界被她反复毁灭，她始终无法找到她所希望的幸福。在一次时间旅行中，她偶然穿越到了永恒之地，这次她发现自己无法毁灭世界了。她终于找到了想要的幸福——无穷无尽的战斗与鲜血。");
		jisixiutei.setPicPath(R.drawable.jisixiutei);
		jisixiutei.setHeroAttr(new HeroAttribute(1, 555, 0, 48, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 15, 30, 1.90, 302, 80, 40, 3.2, 0, 3.2, 1.25, 0, 0.03, 0, 0, 0));
		jisixiutei.setHeroSimpleAttr(new HeroSimpleAttr(7, 5, 4, 4, 6));
		jisixiutei.setEquips(null);
		List<Skill> skills_jisixiutei = new ArrayList<Skill>();
		Skill skill_jisixiutei_b = new Skill("怪异杀手", R.drawable.jisixiutei_b, "普通攻击造成真实伤害10/15/20/25，并回复生命值6/9/12/15，这个技能在6/11/16的效果提升", "被动", "无", "无");
		Skill skill_jisixiutei_q = new Skill("鲜血之吻", R.drawable.jisixiutei_q, "被动效果:姬丝秀忒每损失1%生命值，增加0.2%的生命偷取和法术吸血。主动效果:4秒内下次普通攻击会造成额外30点物理伤害，并在5秒内造成30/50/70/90/110点物理伤害，可以重置普通攻击，每次普通级会降低技能冷却时间1秒", "Q", "30/40/50/60/70", "10/9.5/9/8.5/8");
		Skill skill_jisixiutei_w = new Skill("血腥风暴", R.drawable.jisixiutei_w, "姬丝秀忒变成一团血雾，起见自身无敌，也无法进行普通攻击和使用技能。雾化期间每0.4秒增加移动速度10%/15%/20%/25%/30%，持续1.6秒。并且会对碰到的敌方单位造成每0.4秒30/40/50/60/70点法术伤害", "W", "10%当前生命值", "26/24.5/22/20.5/19");
		Skill skill_jisixiutei_e = new Skill("夺魄凝视", R.drawable.jisixiutei_e, "被动效果:姬丝秀忒周围的敌方单位都会减少2%/4%/6%/8%/10%的移动速度和4%/8%/12%/16%/18%的攻击速度。主动效果:姬丝秀忒周围的敌方单位会被她支配，被支配的单位会缓慢走向姬丝秀忒，效果持续0.75秒(距离越远时间越短，最低60%)。并造成70点法术伤害", "E", "50/60/70/80/90", "18/17/16/15/14");
		Skill skill_jisixiutei_r = new Skill("进食", R.drawable.jisixiutei_r, "扑到目标英雄身边，偷取目标英雄200/300/400点生命值，并将目标定身，持续2秒。", "R", "无", "90/80/70");
		skills_jisixiutei.add(skill_jisixiutei_b);
		skills_jisixiutei.add(skill_jisixiutei_q);
		skills_jisixiutei.add(skill_jisixiutei_w);
		skills_jisixiutei.add(skill_jisixiutei_e);
		skills_jisixiutei.add(skill_jisixiutei_r);
		jisixiutei.setSkills(skills_jisixiutei);
		List<HeroGonglue> heroGonglues_jisixiutei = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_jisixiutei1 = new HeroGonglue(5, "90/80/70 ", "http://data.300hero.net/index.php?/web/heroes_article/76", "攻略"); 
		heroGonglues_jisixiutei.add(gonglue_jisixiutei1);
		jisixiutei.setHeroGonglues(heroGonglues_jisixiutei);
		mlist.add(jisixiutei);
		
		return mlist;
	}
	
}
