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
		
		
	
	//��ʼ������Ӣ��
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
	
	
	
	//���ݶ�λɸѡӢ��
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

	
	//����Ӣ������
	public static List<Hero> loadAllHero(){
		List<Hero> mlist = new ArrayList<Hero>();
		Hero xiaoniaoyouliuhua = new Hero();
		xiaoniaoyouliuhua.setId(0);
		xiaoniaoyouliuhua.setHeroName("С��������");
		xiaoniaoyouliuhua.setNamePinyin("xiaoniaoyouliuhua");
		xiaoniaoyouliuhua.setHeroPosition("AP");
		xiaoniaoyouliuhua.setHeroDes("���ж�����Ҫ̸�������е����˹��������趨Ϊ��а������ʹ�����ж������ߡ����۴��Ž�ɫ�Ĳ�ͫ�������Ǵ������֡���Ϊ����ɫ�Ĺ�ʵ�ή��ħ�������������ɣ���ϲ������֮���ʳ�����Ϊ��������˹ԭʼ�͵ڶ������Զ�ɡΪ����������ӵ����Ϊ������֮ǹ���Ĺ����͡����֮�ܡ��ķ���������̫���������ա�͹�ء������ȵ����齨ͬ�ûᡰԶ��ħ����˯����֮��.��ʵ��һ����˵Ҫ�ж����Ǿܾ��ġ���Ϊ���㲻�������ж����Ҿ�����ȥ�ж�����һ��Ҫ��һ�£���Ϊ�Ҳ�Ը���ж������Ժ��һЩ�ؼ���ȥ���۾����ۡ�һ�£����ᣬ�������������һ�������ң�����û���������۾�����֤�����Ǹ�����ͫ��������Ҳ����֤ʵ��ȷʵ���ж��ģ����ж��˼��꣬�о��ܲ��������ҿ�а�����۵�ʱ��ҲҪ�����ǲ�Ҫ���ؼ�����Ϊ��Ҫ����̫���������ж��Ժ���������ӣ����ж��Ժ�Ҳ����������ӣ�");
		xiaoniaoyouliuhua.setPicPath(R.drawable.xiaoniaoyouliuhua);
		xiaoniaoyouliuhua.setHeroAttr(new HeroAttribute(1, 566, 0, 51, 0, 0, 0, 0.64, 0, 0, 0, 0, 0, 0, 15, 30, 1.20, 298, 78, 0, 3, 0, 3, 0, 0, 0.03, 0, 0, 0));
		xiaoniaoyouliuhua.setHeroSimpleAttr(new HeroSimpleAttr(4, 1, 9, 5, 8));
		xiaoniaoyouliuhua.setEquips(null);
		List<Skill> skills_xiaoniaoyouliuhua = new ArrayList<Skill>();
		Skill skill_xiaoniaoyouliuhua_b = new Skill("а������ʹ", R.drawable.xiaoniaoyouliuhua_b, "����ʹ���Կ��л����ı��������սģʽ����Avida/NTiģʽ��ÿʹ��һ�μ��ܣ��������Կ��л�������82/����122�ж��ȡ�Avida/NTiģʽ�µ���ͨ��������22/����22�ж��ȡ��ж������Ϊ666��ÿ22�ж�������1%����ǿ�ȡ��Կ��ж�Ҳ�ᱬ�����ж��ȴ����ʱ�������л�ΪOutelģʽ���޷�ʹ��Avida��NTiģʽ�µļ��ܣ�����5�룬ÿ��Ը������ез���λ���42��+0.62AP���ķ����˺����������ж��ȼ���Ϊ222.�����������ж�������", "����", "��", "��");
		Skill skill_xiaoniaoyouliuhua_q = new Skill("��������ɡ��/����֮ǹ", R.drawable.xiaoniaoyouliuhua_q, "Avida����������ɡ�á�������ɡ�Ʒ���ǰ�������������ез���λ��Nti������֮ǹ��а������ʹ��ָ������͸����ҫ�Ĺ�֮��ǹ�������е����ез���λ���62/92/122/152/182�����˺�����Ŀ�괦����Avidaģʽ�����Լ���ʩ�ӵĸ���״̬�У���������22���𲽵ݼӵķ����˺���", "Q", "-88�ж���/+122�ж���", "8/7/6/5/4");
		Skill skill_xiaoniaoyouliuhua_w = new Skill("����������ɡ/���֮��", R.drawable.xiaoniaoyouliuhua_w, "Avida������������ɡ��������ָ�������ӳ�ɡ������1�룬ͣ��1�룬�ڼ����е����ез���λ���°�������42%�ƶ��ٶȣ�����2�롣Nti�����֮�ܣ�а������ʹΪ�����ſ���֮��磬���һ��������22/32/42/52/62%�˺��Ļ��ܣ�����2�롣����Сʱʱ�Ը������ез���λ���62/102/162/222/282�����˺�", "W", "-88�ж���/+122�ж���", "12");
		Skill skill_xiaoniaoyouliuhua_e = new Skill("��������һ��/����¡����", R.drawable.xiaoniaoyouliuhua_e, "Avida����������һ�¡���������ָ���ص㣬���ˤ�������ø������еط���λ�е��ǳ������Ĭ0.5�롣Nti������¡���飡а������ʹӽ��ʥ�ԣ���Ŀ�����������ез���λ���62�����˺�����������5%��25%�������ԣ�����3�롣", "E", "-88�ж���/+122�ж���", "14");
		Skill skill_xiaoniaoyouliuhua_r = new Skill("�Կ��л�", R.drawable.xiaoniaoyouliuhua_r, "������A�����ʺã�N�����ٿ졣������Avidaģʽ�»��5%/10%/20%��ȴ������Ntiģʽ������5%/10%/20%�ƶ��ٶȣ���ͨ������ΪԶ�̣��˺����ͱ�Ϊ�����Ҹ��ӷ����˺�������ģʽ�¼���Ч����ͬ��������������Avida�Կ���Nti�Կ�֮���л���Outelģʽ���޷������л���", "R", "��", "5/4/2");
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_b);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_q);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_w);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_e);
		skills_xiaoniaoyouliuhua.add(skill_xiaoniaoyouliuhua_r);
		xiaoniaoyouliuhua.setSkills(skills_xiaoniaoyouliuhua);
		List<HeroGonglue> heroGonglues_xiaoniaoyouliuhua = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_xiaoniaoyouliuhua1 = new HeroGonglue(1, "С����������·��", "http://data.300hero.net/index.php?/web/heroes_article/100", "����"); 
		heroGonglues_xiaoniaoyouliuhua.add(gonglue_xiaoniaoyouliuhua1);
		xiaoniaoyouliuhua.setHeroGonglues(heroGonglues_xiaoniaoyouliuhua);
		mlist.add(xiaoniaoyouliuhua);
		
		Hero yikaluosi = new Hero();
		yikaluosi.setId(1);
		yikaluosi.setHeroName("������˹");
		yikaluosi.setNamePinyin("yikaluosi");
		yikaluosi.setHeroPosition("AD");
		yikaluosi.setHeroDes("�������������а����Ů�ԣ����ж�Ϊ��ʹ��Ѷ�ʺ�õ��˷񶨵Ĵ𰸡���Ů������ʳ��һ�ֽ����ں�ɫҺ���ڵĿ�״����Ŷ��������������������н���˫���Ů�ԣ����ж�Ϊ��ʹ��ѯ�ʺ�õ��˷񶨵Ĵ𰸡��˽��侭��������Ϊ�����ñ������α���Athena����Ȼ�󱻴��ˡ��������������к����Ů�ԣ����ж�Ϊ��ʹ��ѯ�ʺ�õ��˷񶨵Ĵ𰸡���Ů��������ħ�����ҿ�ʼ����һ�׾ݳ�Ϊ��������鼫�¡���Σ�������ۡ���������������-----�۲��¼��ʱ��ֹ���ָ�ʱ��δ����");
		yikaluosi.setPicPath(R.drawable.yikaluosi);
		yikaluosi.setHeroAttr(new HeroAttribute(1, 560, 298, 53, 0, 0, 0, 0.67, 0, 0, 0, 0, 0, 0, 15, 30, 5.30, 300, 77, 38, 3.5, 0, 3, 0, 0, 0.03, 0, 0, 0));
		yikaluosi.setHeroSimpleAttr(new HeroSimpleAttr(6, 9, 0, 5, 5));
		yikaluosi.setEquips(null);
		List<Skill> skills_yikaluosi = new ArrayList<Skill>();
		Skill skill_yikaluosi_b = new Skill("�ɱ�ʽ����ϵͳ", R.drawable.yikaluosi_b, "������˹ÿ��ʩ�ż���ʱ������ҫ��ɫ������7%�����ٶ���5%�ƶ��ٶȣ�����3�룬��߿ɵ���4�㡣", "����", "��", "��");
		Skill skill_yikaluosi_q = new Skill("Artemis", R.drawable.yikaluosi_q, "����:������˹����ͨ������Ŀ�긽��1��׼����0.06����AD*׼�����������˺������Ա�������׼�ǳ���4�룬������12�㡣������������˹��ָ�����·���һ��Artemis���������ез�Ӣ�ۺ󽫶���������������Artemis������ÿ�����10/15/20/25/30�����˺�������70%���ʸ���1��׼�ǣ���֮�����0.2��ѣ�Ρ�", "Q", "40/45/50/55/60", "16/14/12/10/8");
		Skill skill_yikaluosi_w = new Skill("Aegis", R.drawable.yikaluosi_w, "������������˹ÿ����7����ͨ���������Aegis���ܣ�����ս��6�����ʧ�������6���չ��������˺�ÿ5��˥��1�㡣�����չ�����˥�����û��ܿɵֵ�һ���˺������ڴ˺�1.5���ڳ����ֵ�30%/35%/40%/45%/50%�˺������Ѵ���δ�����Ļ���ʱ��������", "W", "��", "��");
		Skill skill_yikaluosi_e = new Skill("Ecarus", R.drawable.yikaluosi_e, "������˹��ָ���ص���ٻ��裬�˺�3��������20%�����ٶȣ��ڼ��һ����ͨ�������⸽��20/40/60/80/100��+0.4AD���⣩�����˺���1��׼�ǡ�", "E", "50", "10");
		Skill skill_yikaluosi_r = new Skill("Apollon", R.drawable.yikaluosi_r, "������˹��ָ�������������������еĵ�һ���з�Ӣ�����100/175/250��+0.7AD���⣩�����˺���4����ʹ���ܵ��˺�����10%/20%/30%���������Ӣ�ۺ��ѣ�4���ڶԸ������ез���λÿ0.5�����25/35/45��+0.35AD���⣩�����˺�", "R", "100/120/140 ", "100/90/80");
		skills_yikaluosi.add(skill_yikaluosi_b);
		skills_yikaluosi.add(skill_yikaluosi_q);
		skills_yikaluosi.add(skill_yikaluosi_w);
		skills_yikaluosi.add(skill_yikaluosi_e);
		skills_yikaluosi.add(skill_yikaluosi_r);
		yikaluosi.setSkills(skills_yikaluosi);
		List<HeroGonglue> heroGonglues_yikaluosi = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_yikaluosi1 = new HeroGonglue(2, "ǳ̸һЩ����������˹���ĵ�", "http://data.300hero.net/index.php?/web/heroes_article/137", "����"); 
		HeroGonglue gonglue_yikaluosi2 = new HeroGonglue(3, "70%ʤ������˵һ˵���淨", "http://data.300hero.net/index.php?/web/heroes_article/43", "����"); 
		heroGonglues_yikaluosi.add(gonglue_yikaluosi1);
		heroGonglues_yikaluosi.add(gonglue_yikaluosi2);
		yikaluosi.setHeroGonglues(heroGonglues_yikaluosi);
		mlist.add(yikaluosi);
		
		Hero bantianyinshi = new Hero();
		bantianyinshi.setId(2);
		bantianyinshi.setHeroName("������ʱ");
		bantianyinshi.setNamePinyin("bantianyinshi");
		bantianyinshi.setHeroPosition("AD");
		bantianyinshi.setHeroDes("�ձ����������꡷�е����˹���ӵ����Ȼ��׷�����ͫ���������۾�������һ���Ǻ�ɫ�¿�������׵������ͷ���������Զ����д�ж�ү��������ľ��.ƽ��Ϊ�ϲ񣬲�ʱ˵����������Ļ�������ʵ�Ǹ�ӵ����ʿ������ˣ����Ų��᳹�Լ�����ʿ������ȥ��Ծ�ں������Ļ���԰�ҹ��֮��������ң���ν��˵�е��������ɼ����ָ��������ʱ����ϣ������ƺ���óٶۣ���ʵ�����ɼ�ǿ��");
		bantianyinshi.setPicPath(R.drawable.bantianyinshi);
		bantianyinshi.setHeroAttr(new HeroAttribute(1, 565, 322, 55, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 15, 30, 1.40, 300, 85, 42, 3.5, 0, 3.2, 0, 0, 0.03, 0, 0, 0));
		bantianyinshi.setHeroSimpleAttr(new HeroSimpleAttr(5, 8, 0, 5, 3));
		bantianyinshi.setEquips(null);
		List<Skill> skills_bantianyinshi = new ArrayList<Skill>();
		Skill skill_bantianyinshi_b = new Skill("��ҹ��(����)", R.drawable.bantianyinshi_b, "��ʱÿ��ʧ5%����ֵ����1%��������4%�Ĺ����ٶȡ�1%���˺����⡣��Ϊ��tangҹniao��bing����ʱ���������ϸߵļ��ܹ���ʱ�������ܵ�0.4������ȡ������ʵ�˺���", "����", "��", "��");
		Skill skill_bantianyinshi_q = new Skill("��ͻ(��S)", R.drawable.bantianyinshi_q, "��ʱ��һ���з���λ�����㣨�ջ��������棬��Ŀ����������˺�����ʹ��ѣ�Σ���M��", "Q", "55/65/75/85/95", "15");
		Skill skill_bantianyinshi_w = new Skill("����(�²�)", R.drawable.bantianyinshi_w, "��ʱ���ң��²ۣ�һ���з�Ӣ�ۣ���������˺���ʹ�����������������ƣ������м���100.", "W", "50", "17/16/15/14/13");
		Skill skill_bantianyinshi_e = new Skill("�ɽ�(��ʺ)", R.drawable.bantianyinshi_e, "��ʱָ��һ���з���λͶ���ɽ�����ʺ������ɷ����˺�����ʹĿ����Ѫ�����ģ����������ƶ��ٶȡ����ס��������ԡ�", "E", "50", "10/9/8/7/6");
		Skill skill_bantianyinshi_r = new Skill("��ķʩ������", R.drawable.bantianyinshi_r, "��ʱ�ٻ���ķʩ���ʻ�����������ʽ��ķʩ�����ڣ����Լ������ָ���ص㣬�Ը������еط���λ��������˺���", "R", "100/125/150 ", "120");
		skills_bantianyinshi.add(skill_bantianyinshi_b);
		skills_bantianyinshi.add(skill_bantianyinshi_q);
		skills_bantianyinshi.add(skill_bantianyinshi_w);
		skills_bantianyinshi.add(skill_bantianyinshi_e);
		skills_bantianyinshi.add(skill_bantianyinshi_r);
		bantianyinshi.setSkills(skills_bantianyinshi);
		List<HeroGonglue> heroGonglues_bantianyinshi = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_bantianyinshi1 = new HeroGonglue(3, "300Ӣ����ʱ��ѧ��Ƶ", "http://data.300hero.net/index.php?/web/heroes_article/72", "��Ƶ"); 
		heroGonglues_bantianyinshi.add(gonglue_bantianyinshi1);
		bantianyinshi.setHeroGonglues(heroGonglues_bantianyinshi);
		mlist.add(bantianyinshi);
		
		Hero yeye = new Hero();
		yeye.setId(3);
		yeye.setHeroName("ҹҹ");
		yeye.setNamePinyin("yeye");
		yeye.setHeroPosition("Tank");
		yeye.setHeroDes("������Ʒ��������Ů�������ˡ��е�Ů����֮һ�����ǳ�������Ĵ����Ů�������Զ���ż��Ҳ�ǡ�����ի����߼����Ρ�ѩ�»����Ĵ�Ů����֮��Ů�������������������ǿ��������������ӳ�Ϊ�����ʺϱ�����Ҫ֮�ˡ�����ż������������߳������кܴ�̶ȵĻ��룬���׳Դס����ԵĶ����Ƕ�ɳˮ�����ۡ�");
		yeye.setPicPath(R.drawable.yeye);
		yeye.setHeroAttr(new HeroAttribute(1, 615, 295, 54, 0, 0, 0, 0.65, 0, 0, 0, 0, 0, 0, 15, 30, 1.20, 300, 82, 34, 3.3, 0, 3.1, 1.25, 0, 0.03, 0, 0, 0));
		yeye.setHeroSimpleAttr(new HeroSimpleAttr(8, 8, 0, 3, 4));
		yeye.setEquips(null);
		List<Skill> skills_yeye = new ArrayList<Skill>();
		Skill skill_yeye_b = new Skill("�����", R.drawable.yeye_b, "ҹҹ��ĵ�û�·�����������ʹ�Լ������ʳ�Ӳ�ʻ�����������15%�����һ���15%ת��Ϊ���⹥���������������������75�㹥��������ҹҹ������ֵ����30%ʱ������8����������Χ800��Χ���ѷ�Ӣ�۵�ǰ����ֵ��4%���ָ������������ֵ��2%�����ָ�50%������ֵ��û�з���ֵ��Ӣ���޷�Ϊҹҹ�ṩ�����ָ�����", "����", "��", "180");
		Skill skill_yeye_q = new Skill("��ȴˮ��", R.drawable.yeye_q, "ҹҹ��ȭͷ�����ĽӴ������������40/70/100/130/160 +��1.3ȫad���������˺�������Ŀ�����ڱ���һ��ǿ�����������Ŀ����Χ200��Χ�ڵĵ��ˡ�", "Q", "40", "8/7/6/5/4");
		Skill skill_yeye_w = new Skill("�ľ̫��Ӱ", R.drawable.yeye_w, "ҹҹ��һ��������ٳ�棬ײ����һ��Ŀ����ֹͣ����Ŀ����� 80/140/200/260/320 + (0.8����ad) �������˺�����ѣ��Ŀ��1�롣ͬʱ�ڽ�������4���ڣ�ҹҹ���ܵ��˺�����10%/12%/14%/16%/18%��", "W", "80", "18/16/14/12/10");
		Skill skill_yeye_e = new Skill("��ת�ɣ�ѩ�»�/��Ӱ����", R.drawable.yeye_e, "ѩ�»���ҹҹ������һ���ת���ڼ��ܸ�������ͨ�������������ӵ�λ�赲������4����3/4/5/6/7����ͨ��������ת�����л���������ƶ��ٶȣ��������30%����ת�ڼ����ʹ�ö��μ��ܣ���Ӱ������ ��Ӱ������ҹҹ������������ó��ȵ�һ������Ŀ�����50/80/110/140/170 + ��0.6ȫad���������˺�������30%�ƶ��ٶȣ�����2�롣ÿ��һ����ͨ�����������˺����10%����ת�ڼ�ʹ��������ͨ���ܶ����ж���ת��", "E", "30/35/40/45/50", "20/18/16/14/12");
		Skill skill_yeye_r = new Skill("��ɫ�н�������", R.drawable.yeye_r, "ҹҹ������롱��������ģʽ������������п���Ч����ˢ��������ͨ������ȴʱ�䣬���һ��20%/30%/40%����ȴ���������30%/45%/60%�Ĺ����ٶ���20%/30%/40%�ƶ��ٶȣ�����7/9/11�롣", "R", "100/125/150 ", "120/105/90");
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
		shiliuyexiaoye.setHeroName("ʮ��ҹ�Dҹ");
		shiliuyexiaoye.setNamePinyin("shiliuyexiaoye");
		shiliuyexiaoye.setHeroPosition("AP");
		shiliuyexiaoye.setHeroDes("ʮ��ҹ�Dҹ��ϵ����Ʒ������Project���еĽ�ɫ���ڡ�������ħ�硷�״εǳ�������ס�ں�ħ�ݲ������湤����Ů�͡��Ǳ���֮Ϊ��ħ֮�ݵĺ�ħ����Ψһ�����࣬��Ů���ǵ��ͳ�����ӵ�в���ʱ�����������������˵������һ����߼���ǿ���������������ͨ�����о��ܵõ��ġ�");
		shiliuyexiaoye.setPicPath(R.drawable.shiliuyexiaoye);
		shiliuyexiaoye.setHeroAttr(new HeroAttribute(1, 570, 355, 53, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 15, 30, 5.00, 302, 77, 48, 3.2, 0, 3.0, 0, 0, 0.03, 0, 0, 0));
		shiliuyexiaoye.setHeroSimpleAttr(new HeroSimpleAttr(4, 1, 9, 6, 7));
		shiliuyexiaoye.setEquips(null);
		List<Skill> skills_shiliuyexiaoye = new ArrayList<Skill>();
		Skill skill_shiliuyexiaoye_b = new Skill("Ů��������¥��", R.drawable.shiliuyexiaoye_b, "��ɨ�ڼ䣬�Dҹ�ĵ��幥��(��ͨ�������������������硱)������Ч����������֪����ʱͣ�н��������еط���λ͵͵�Ὺ����Ŀ�겻��Ӱ�졣", "����", "��", "60");
		Skill skill_shiliuyexiaoye_q = new Skill("���������ķɵ�", R.drawable.shiliuyexiaoye_q, "�Dҹָ��Ŀ��ص��˦��4���ɵ����Ӳ�ͬ��λ��Ŀ�귢�䣬ÿ���ɵ��ԽӴ������еط���λ��ɷ����˺�����ͬһĿ����˺�˥��70%���˺���40/70/100/130/160��+0.4AP��", "Q", "45/55/65/75/85", "6/5.5/5/4.5/4");
		Skill skill_shiliuyexiaoye_w = new Skill("����������ʱ��", R.drawable.shiliuyexiaoye_w, "�Dҹ��Ŀ������Ͷ��ʱ�ƣ�������������ڷɵ����ƶ��ٶ�����Dҹ���������е�λ���ƶ��ٶȡ������ٶȡ����ɵ������󲿷ַ��е����༼����Զ����ͨ������ʩ�����룺500/550/600/650/700", "W", "80", "22/20/18/16/14");
		Skill skill_shiliuyexiaoye_e = new Skill("����������Ů��", R.drawable.shiliuyexiaoye_e, "�Dҹ�ı�ʱ�����ٿ�ʼ��ɨ��3��������40%�ƶ��ٶȡ��ڼ䡰���������ķɵ����ɽ�����ɨ��ʹ�ɵ���������һ���ҵ�һ���˺���������ʹ�á�����������ʱ�ơ�������ɨ�������������еط���λ���80/120/160/200/240(+0.6AP)", "E", "45/55/65/75/85", "17/16/15/14/13");
		Skill skill_shiliuyexiaoye_r = new Skill("��������������", R.drawable.shiliuyexiaoye_r, "�Dҹֹͣһ���з�Ӣ�۵�ʱ�䣬1.5����ʹĿ���޷��ƶ��������Ƿ������ܱ�������������Լ��⣩����Ŀ��˦�������ɵ���Ȼ��ʱ�俪ʼ�������ɵ�һ���䣬��ɷ����˺����˺�:300/400/500(+0.9AP)", "R", "100/125/150 ", "100/80/60");
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_b);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_q);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_w);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_e);
		skills_shiliuyexiaoye.add(skill_shiliuyexiaoye_r);
		shiliuyexiaoye.setSkills(skills_shiliuyexiaoye);
		List<HeroGonglue> heroGonglues_shiliuyexiaoye = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_shiliuyexiaoye1 = new HeroGonglue(4, "�������ֵ�16��CD�� ", "http://data.300hero.net/index.php?/web/heroes_article/126", "����"); 
		heroGonglues_shiliuyexiaoye.add(gonglue_shiliuyexiaoye1);
		shiliuyexiaoye.setHeroGonglues(heroGonglues_shiliuyexiaoye);
		mlist.add(shiliuyexiaoye);
		
		Hero qiangxiziyou = new Hero();
		qiangxiziyou.setId(5);
		qiangxiziyou.setHeroName("ǿϮ����");
		qiangxiziyou.setNamePinyin("qiangxiziyou");
		qiangxiziyou.setHeroPosition("AD");
		qiangxiziyou.setHeroDes("�������������������¿����������Ǹ��ز���ʶ���Լ�������Ϊ��ȥ���˶����࣬�����򲻹�֮�˶����䡣 ��Ҫ���Ҷ�ȥ����ʹ����������Ҳֻ�ǻ�����ɫ����ľ���ҡҷ�����������������ϵģ������еļ��䣬�ѽ�Զȥ��ָ�ⵯ�����������ɣ����������������ϵĶ�֮ͯ�ģ�����Х�ĳ���������׿���������������˵�̾Ϣ����Ū�������޷�ƽ������δ������մȾ�Ľ����ӳ���ˣ�ҡҷ�ųȻƻ��������֮Ӱ����ʹ���Ӳ������ۣ�Ҳ�ܿ�Խ�Ǳ�Ϧ��Ⱦ���ɳ̲���������ɡ��ڻ���ȼ�մ����Ĵ���ϣ���������ѿ��������������Ŀ�ͷ������г�����ɫ�Ļ����������ںδ�ҡҷ�� ����ӭ�ӹ������ε��������ٴε���֮ǰ����ҪϨ�����еĵƻ𣬳��ְ�����ת�ɡ�");
		qiangxiziyou.setPicPath(R.drawable.qiangxiziyou);
		qiangxiziyou.setHeroAttr(new HeroAttribute(1, 640, 270, 57, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 50, 40, 2.00, 300, 70, 45, 3.5, 0, 0, 0, 0, 0.03, 0, 0, 0));
		qiangxiziyou.setHeroSimpleAttr(new HeroSimpleAttr(5, 8, 5, 7, 5));
		qiangxiziyou.setEquips(null);
		List<Skill> skills_qiangxiziyou = new ArrayList<Skill>();
		Skill skill_qiangxiziyou_b = new Skill("GUNDAM", R.drawable.qiangxiziyou_b, "�ೡװ���ṩ�����õķ�����GUNDAMӵ�и��ߵĳ�ʼ���׺�ħ�������������Բ���ȼ�����", "����", "��", "��");
		Skill skill_qiangxiziyou_q = new Skill("���������ٲ�ǹ", R.drawable.qiangxiziyou_q, "����Ч��:��ͨ������14/18/22/26/30%������ɵ���������˺�(���˺����Ա������л�����ģʽ�����������˺�����)����Ч��:�л�Ϊ����ģʽ�����Զ�̹���������ͬʱ������ѹ�ƽ�ϵͳ�� ����2/4/6/8/10%�ƶ��ٶ������ӵ�λ�赲", "Q", "20", "7");
		Skill skill_qiangxiziyou_w = new Skill("���������ϵͳ", R.drawable.qiangxiziyou_w, "���ѷ�Ӣ��:ʹ�ù���ͻ�������һ������2.5�Ļ��ܣ��ֵ������˺����������˺�����70/100/130/160/190��(ǿϮģʽ�¶��Լ��ͷŵĻ��ܳ���ʱ����Ч�����30%)���򻤶ܱ������ܵ�ȫ���˺����Եз�Ӣ�ۣ��������ͻ���ڣ�ÿ��������15/25/35/45/55�������˺�������8�룬Ŀ���뿪����700��Χ���̽���", "W", "80", "20/19/18/17/16");
		Skill skill_qiangxiziyou_e = new Skill("������λ������", R.drawable.qiangxiziyou_e, "��ǰ�����һ��ǿ�������������60/90/120/150/180����ʵ�˺�", "E", "80/90/100/110/120", "10/9.5/9/8.5/8");
		Skill skill_qiangxiziyou_r = new Skill("FULL BURST MODE", R.drawable.qiangxiziyou_r, "�������У�����ȫ��������Ŀ�����������12����λ��ʩ�Ź�12��С����������Ŀ�귽��ʩ��һ���������ÿ��С�������85/120/155����ʵ�˺�����ͬһ��λ���õĺ���С����ֻ�����10%���˺�����������200/300/400�㷨���˺�", "R", "100/125/150 ", "120/105/90");
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
		xialuote.setHeroName("������");
		xialuote.setNamePinyin("xialuote");
		xialuote.setHeroPosition("Tank");
		xialuote.setHeroDes("��λ��֮Ů����˫����սʤ�����е�׷���ߣ�Ϊ������ߵľ����������̤����׷�󽣵��Ķ���֮�á� ���������۽�֮�塢��������������֮����̤��޶�ȡ�Ƚ�֮�ġ� ������������������ͷ���������޿��ʵ�֮��ʱ����λ���ɾ��޵�Ů��һ��ն����ʱ�ա�����ԭ�������磬õ�彣ʥ�ƿն�ȥ����������֮�أ������߽��µĴ�˵��");
		xialuote.setPicPath(R.drawable.xialuote);
		xialuote.setHeroAttr(new HeroAttribute(1, 586, 260, 54, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 18, 30, 1.30, 307, 80, 40, 3.2, 0, 3.5, 1.25, 0, 0.03, 0, 0, 0));
		xialuote.setHeroSimpleAttr(new HeroSimpleAttr(7, 8, 1, 5, 6));
		xialuote.setEquips(null);
		List<Skill> skills_xialuote = new ArrayList<Skill>();
		Skill skill_xialuote_b = new Skill("��Ѫ����", R.drawable.xialuote_b, "���������صĵ��˽���3�����У����Ե���5�㣬����4�롣", "����", "��", "��");
		Skill skill_xialuote_q = new Skill("�ƿս�", R.drawable.xialuote_q, "��Ŀ�꼰����Χ���3����λ����5��ͻϮ�����ջص�Ŀ����ߣ���ÿ����Χ�ĵ�λ���ֻ�����һ���˺���Ŀ������ʣ������д���(�����˺�ֻ�����10%���˺�)��ÿ�����80/130/180/230/280�������˺�", "Q", "50/60/70/80/90", "16/15/14/13/12");
		Skill skill_xialuote_w = new Skill("Ѹ�����ǽ�", R.drawable.xialuote_w, "����Ч������10%/12.5%/15%/17.5%/20%�ĸ����мܵ����˺��������䷴�����30/55/80/105/130�㷨���˺���(������ȴʱ��0.5�룩", "W", "��", "��");
		Skill skill_xialuote_e = new Skill("�������ǽ�", R.drawable.xialuote_e, "��Ŀ�����30/55/80/105/130�㷨���˺�����Ŀ��4�����ܵ����ƿռ��˺�����䷢��ͻϮ��3������ɵ�ǰ����ֵ6%/9%/12%/15%/18%�������˺�(�Թ���������600�������˺�)�����������20%/30%/40%/50%/60%���ƶ��ٶȣ�����1.5��", "E", "75", "6");
		Skill skill_xialuote_r = new Skill("���ǹ�â��", R.drawable.xialuote_r, "��Ŀ��Ӣ����������˺������Ŀ����������20%��������ɱ��Ŀ�ꡣ���������ɱ���з�Ӣ�ۿ�������ˢ�¼�����ȴ��", "R", "100", "110/100/90");
		skills_xialuote.add(skill_xialuote_b);
		skills_xialuote.add(skill_xialuote_q);
		skills_xialuote.add(skill_xialuote_w);
		skills_xialuote.add(skill_xialuote_e);
		skills_xialuote.add(skill_xialuote_r);
		xialuote.setSkills(skills_xialuote);
		List<HeroGonglue> heroGonglues_xialuote = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_xialuote1 = new HeroGonglue(5, "����õ�彣-�����ش��͹��� ", "http://data.300hero.net/index.php?/web/heroes_article/117", "����"); 
		heroGonglues_xialuote.add(gonglue_xialuote1);
		xialuote.setHeroGonglues(heroGonglues_xialuote);
		mlist.add(xialuote);
		
		Hero jisixiutei = new Hero();
		jisixiutei.setId(1);
		jisixiutei.setHeroName("��˿��߯");
		jisixiutei.setNamePinyin("jisixiutei");
		jisixiutei.setHeroPosition("Tank");
		jisixiutei.setHeroDes("��˿��߯��������Ұ�̺Ͱ�����ľ��֮�󣬿������µ������ߡ���������һ��������Լ��ܹ�����Ҹ�����˿��߯����Ҳ���м���ʱ�����У������Ƿ��ܹ�Ϊ�Լ��ҵ��Ҹ���Ȼ���ڶ��ʱ���У����类������������ʼ���޷��ҵ�����ϣ�����Ҹ�����һ��ʱ�������У���żȻ��Խ��������֮�أ�����������Լ��޷����������ˡ��������ҵ�����Ҫ���Ҹ����������޾���ս������Ѫ��");
		jisixiutei.setPicPath(R.drawable.jisixiutei);
		jisixiutei.setHeroAttr(new HeroAttribute(1, 555, 0, 48, 0, 0, 0, 0.66, 0, 0, 0, 0, 0, 0, 15, 30, 1.90, 302, 80, 40, 3.2, 0, 3.2, 1.25, 0, 0.03, 0, 0, 0));
		jisixiutei.setHeroSimpleAttr(new HeroSimpleAttr(7, 5, 4, 4, 6));
		jisixiutei.setEquips(null);
		List<Skill> skills_jisixiutei = new ArrayList<Skill>();
		Skill skill_jisixiutei_b = new Skill("����ɱ��", R.drawable.jisixiutei_b, "��ͨ���������ʵ�˺�10/15/20/25�����ظ�����ֵ6/9/12/15�����������6/11/16��Ч������", "����", "��", "��");
		Skill skill_jisixiutei_q = new Skill("��Ѫ֮��", R.drawable.jisixiutei_q, "����Ч��:��˿��߯ÿ��ʧ1%����ֵ������0.2%������͵ȡ�ͷ�����Ѫ������Ч��:4�����´���ͨ��������ɶ���30�������˺�������5�������30/50/70/90/110�������˺�������������ͨ������ÿ����ͨ���ή�ͼ�����ȴʱ��1��", "Q", "30/40/50/60/70", "10/9.5/9/8.5/8");
		Skill skill_jisixiutei_w = new Skill("Ѫ�ȷ籩", R.drawable.jisixiutei_w, "��˿��߯���һ��Ѫ����������޵У�Ҳ�޷�������ͨ������ʹ�ü��ܡ����ڼ�ÿ0.4�������ƶ��ٶ�10%/15%/20%/25%/30%������1.6�롣���һ�������ĵз���λ���ÿ0.4��30/40/50/60/70�㷨���˺�", "W", "10%��ǰ����ֵ", "26/24.5/22/20.5/19");
		Skill skill_jisixiutei_e = new Skill("��������", R.drawable.jisixiutei_e, "����Ч��:��˿��߯��Χ�ĵз���λ�������2%/4%/6%/8%/10%���ƶ��ٶȺ�4%/8%/12%/16%/18%�Ĺ����ٶȡ�����Ч��:��˿��߯��Χ�ĵз���λ�ᱻ��֧�䣬��֧��ĵ�λ�Ỻ������˿��߯��Ч������0.75��(����ԽԶʱ��Խ�̣����60%)�������70�㷨���˺�", "E", "50/60/70/80/90", "18/17/16/15/14");
		Skill skill_jisixiutei_r = new Skill("��ʳ", R.drawable.jisixiutei_r, "�˵�Ŀ��Ӣ����ߣ�͵ȡĿ��Ӣ��200/300/400������ֵ������Ŀ�궨������2�롣", "R", "��", "90/80/70");
		skills_jisixiutei.add(skill_jisixiutei_b);
		skills_jisixiutei.add(skill_jisixiutei_q);
		skills_jisixiutei.add(skill_jisixiutei_w);
		skills_jisixiutei.add(skill_jisixiutei_e);
		skills_jisixiutei.add(skill_jisixiutei_r);
		jisixiutei.setSkills(skills_jisixiutei);
		List<HeroGonglue> heroGonglues_jisixiutei = new ArrayList<HeroGonglue>();
		HeroGonglue gonglue_jisixiutei1 = new HeroGonglue(5, "90/80/70 ", "http://data.300hero.net/index.php?/web/heroes_article/76", "����"); 
		heroGonglues_jisixiutei.add(gonglue_jisixiutei1);
		jisixiutei.setHeroGonglues(heroGonglues_jisixiutei);
		mlist.add(jisixiutei);
		
		return mlist;
	}
	
}
