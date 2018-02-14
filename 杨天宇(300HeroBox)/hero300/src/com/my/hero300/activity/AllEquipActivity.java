package com.my.hero300.activity;

import java.util.ArrayList;
import java.util.List;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.my.hero300.R;
import com.my.hero300.adapter.EquipAdapter;
import com.my.hero300.bean.Equip;
import com.my.hero300.bean.EquipAttribute;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class AllEquipActivity extends SlidingActivity {

	List<Equip> list;
	GridView gv;
	
	List<TextView> listAll;
	TextView tv_left_menu_gongjilei;
	List<TextView> list_gongjilei;
	TextView tv_left_menu_gongjili;
	TextView tv_left_menu_baojilv;
	TextView tv_left_menu_gongjisudu;
	TextView tv_left_menu_hujiachuantou;
	TextView tv_left_menu_shengmingtouqu;
	
	TextView tv_left_menu_fashulei;
	List<TextView> list_fashulei;
	TextView tv_left_menu_fashuqiangdu;
	TextView tv_left_menu_lengquesuojian;
	TextView tv_left_menu_falihuifu;
	TextView tv_left_menu_falizhi;
	TextView tv_left_menu_fashuchuantou;
	
	TextView tv_left_menu_fangyulei;
	List<TextView> list_fangyulei;
	TextView tv_left_menu_shengmingzhi;
	TextView tv_left_menu_hujiazhi;
	TextView tv_left_menu_fashukangxing;
	TextView tv_left_menu_shengminghuifu;
	TextView tv_left_menu_renxing;
	
	TextView tv_left_menu_qita;
	List<TextView> list_qita;
	TextView tv_left_menu_yidongsudu;
	TextView tv_left_menu_ewaijinqian;
	TextView tv_left_menu_chengchanglei;
	TextView tv_left_menu_kongzhilei;
	TextView tv_left_menu_guanghuanlei;
	
	TextView tv_left_menu_all;
	
	SlidingMenu menu;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_equip);
		list = loadAllEquip();
		init();
		initEquipLeftMenu();
		
	}

	private void initEquipLeftMenu() {
		setBehindContentView(R.layout.equip_left_menu);
		// configure the SlidingMenu
		menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT);
		// 设置触摸屏幕的模式
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);

		// 设置滑动菜单视图的宽度
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 设置渐入渐出效果的值
		menu.setFadeDegree(0.35f);
		
		//初始化控件
		//攻击类栏
		tv_left_menu_gongjilei = (TextView) this.findViewById(R.id.tv_left_menu_gongjilei);
		tv_left_menu_gongjili = (TextView) this.findViewById(R.id.tv_left_menu_gongjili);
		tv_left_menu_baojilv = (TextView) this.findViewById(R.id.tv_left_menu_baojilv);
		tv_left_menu_gongjisudu = (TextView) this.findViewById(R.id.tv_left_menu_gongjisudu);
		tv_left_menu_hujiachuantou = (TextView) this.findViewById(R.id.tv_left_menu_hujiachuantou);
		tv_left_menu_shengmingtouqu = (TextView) this.findViewById(R.id.tv_left_menu_shengmingtouqu);
		list_gongjilei = new ArrayList<TextView>();
		list_gongjilei.add(tv_left_menu_gongjili);
		list_gongjilei.add(tv_left_menu_baojilv);
		list_gongjilei.add(tv_left_menu_gongjisudu);
		list_gongjilei.add(tv_left_menu_hujiachuantou);
		list_gongjilei.add(tv_left_menu_shengmingtouqu);
		ViewGONE(list_gongjilei);
		tv_left_menu_gongjilei.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tv_left_menu_gongjilei.getTag().equals("0")){
					tv_left_menu_gongjilei.setTag("1");
					ViewVISIBLE(list_gongjilei);
				}else{
					tv_left_menu_gongjilei.setTag("0");
					ViewGONE(list_gongjilei);
				}
			}
		});
		
		//法术类栏
		tv_left_menu_fashulei = (TextView) this.findViewById(R.id.tv_left_menu_fashulei);
		tv_left_menu_fashuqiangdu = (TextView) this.findViewById(R.id.tv_left_menu_fashuqiangdu);
		tv_left_menu_lengquesuojian = (TextView) this.findViewById(R.id.tv_left_menu_lengquesuojian);
		tv_left_menu_falihuifu = (TextView) this.findViewById(R.id.tv_left_menu_falihuifu);
		tv_left_menu_falizhi = (TextView) this.findViewById(R.id.tv_left_menu_falizhi);
		tv_left_menu_fashuchuantou = (TextView) this.findViewById(R.id.tv_left_menu_fashuchuantou);
		list_fashulei = new ArrayList<TextView>();
		list_fashulei.add(tv_left_menu_fashuqiangdu);
		list_fashulei.add(tv_left_menu_lengquesuojian);
		list_fashulei.add(tv_left_menu_falihuifu);
		list_fashulei.add(tv_left_menu_falizhi);
		list_fashulei.add(tv_left_menu_fashuchuantou);
		ViewGONE(list_fashulei);
		tv_left_menu_fashulei.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tv_left_menu_fashulei.getTag().equals("0")){
					tv_left_menu_fashulei.setTag("1");
					ViewVISIBLE(list_fashulei);
				}else{
					tv_left_menu_fashulei.setTag("0");
					ViewGONE(list_fashulei);
				}
			}
		});
		
		//防御类栏
		tv_left_menu_fangyulei = (TextView) this.findViewById(R.id.tv_left_menu_fangyulei);
		tv_left_menu_shengmingzhi = (TextView) this.findViewById(R.id.tv_left_menu_shengmingzhi);
		tv_left_menu_hujiazhi = (TextView) this.findViewById(R.id.tv_left_menu_hujiazhi);
		tv_left_menu_fashukangxing = (TextView) this.findViewById(R.id.tv_left_menu_fashukangxing);
		tv_left_menu_shengminghuifu = (TextView) this.findViewById(R.id.tv_left_menu_shengminghuifu);
		tv_left_menu_renxing = (TextView) this.findViewById(R.id.tv_left_menu_renxing);
		list_fangyulei = new ArrayList<TextView>();
		list_fangyulei.add(tv_left_menu_shengmingzhi);
		list_fangyulei.add(tv_left_menu_hujiazhi);
		list_fangyulei.add(tv_left_menu_fashukangxing);
		list_fangyulei.add(tv_left_menu_shengminghuifu);
		list_fangyulei.add(tv_left_menu_renxing);
		ViewGONE(list_fangyulei);
		tv_left_menu_fangyulei.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tv_left_menu_fangyulei.getTag().equals("0")){
					tv_left_menu_fangyulei.setTag("1");
					ViewVISIBLE(list_fangyulei);
				}else{
					tv_left_menu_fangyulei.setTag("0");
					ViewGONE(list_fangyulei);
				}
			}
		});
		
		//其他栏
		tv_left_menu_qita = (TextView) this.findViewById(R.id.tv_left_menu_qita);
		tv_left_menu_yidongsudu = (TextView) this.findViewById(R.id.tv_left_menu_yidongsudu);
		tv_left_menu_ewaijinqian = (TextView) this.findViewById(R.id.tv_left_menu_ewaijinqian);
		tv_left_menu_chengchanglei = (TextView) this.findViewById(R.id.tv_left_menu_chengchanglei);
		tv_left_menu_kongzhilei = (TextView) this.findViewById(R.id.tv_left_menu_kongzhilei);
		tv_left_menu_guanghuanlei = (TextView) this.findViewById(R.id.tv_left_menu_guanghuanlei);
		list_qita = new ArrayList<TextView>();
		list_qita.add(tv_left_menu_yidongsudu);
		list_qita.add(tv_left_menu_ewaijinqian);
		list_qita.add(tv_left_menu_chengchanglei);
		list_qita.add(tv_left_menu_kongzhilei);
		list_qita.add(tv_left_menu_guanghuanlei);
		ViewGONE(list_qita);
		tv_left_menu_qita.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tv_left_menu_qita.getTag().equals("0")){
					tv_left_menu_qita.setTag("1");
					ViewVISIBLE(list_qita);
				}else{
					tv_left_menu_qita.setTag("0");
					ViewGONE(list_qita);
				}
			}
		});
		
		listAll = new ArrayList<TextView>();
		tv_left_menu_all = (TextView) this.findViewById(R.id.tv_left_menu_all);
		listAll.add(tv_left_menu_all);
		for (int i = 0; i < list_gongjilei.size(); i++) {
			listAll.add(list_gongjilei.get(i));
		}
		for (int i = 0; i < list_fashulei.size(); i++) {
			listAll.add(list_fashulei.get(i));
		}
		for (int i = 0; i < list_fangyulei.size(); i++) {
			listAll.add(list_fangyulei.get(i));
		}
		for (int i = 0; i < list_qita.size(); i++) {
			listAll.add(list_qita.get(i));
		}
		
		for (int i = 0; i < listAll.size(); i++) {
			listAll.get(i).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String type = (String) v.getTag();
					list = select(type);
					init();
					menu.toggle(false);
				}
			});
		}
	}
	
	//侧滑点击事件隐藏子菜单
	public void ViewGONE(List<TextView> list){
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setVisibility(View.GONE);
		}
	}
	//侧滑点击事件显示子菜单
	public void ViewVISIBLE(List<TextView> list){
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setVisibility(View.VISIBLE);
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_equip, menu);
		return true;
	}
	
	
	//初始化加载装备
	public void init(){
		gv = (GridView) this.findViewById(R.id.gv_equip);
		EquipAdapter adapter = new EquipAdapter(this, list);
		gv.setAdapter(adapter);
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("Equip", list.get(position));
				intent.setClass(AllEquipActivity.this, EquipDetailActivity.class);
				startActivity(intent);
			}
		});
	}
	
	//根据定位筛选装备
	public List<Equip> select(String type){
		list = loadAllEquip();
		if(!type.equals("All")){
			List<Equip> listSelect = new ArrayList<Equip>();
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).getEquipType().length; j++) {
					if(list.get(i).getEquipType()[j].equals(type)){
						listSelect.add(list.get(i));
					}
				}
			}
			list = listSelect;
		}
		return list;
	}
	
	//侧滑里的ExpandableListAdapter
	class MyAdapter extends BaseExpandableListAdapter{
		String[] mGroupList;
		Context mContext;
		List<String[]> mChirldList;
		//将数据传递进来
		public MyAdapter(String[] groupString,List<String[]> chirldList,Context context ){
			mGroupList = groupString;
			mContext = context;
			mChirldList = chirldList;
		}
		
		//获取一个子元素
		@Override
		public Object getChild(
				int arg0, //在那个组中
				int arg1) {//在组中的那个位置
			
			return mChirldList.get(arg0)[arg1];
		}

		@Override
		public long getChildId(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return arg1;
		}
		
		@Override
		public View getChildView(
				int arg0, //在哪一个组
				int arg1, //在组里的哪一个
				boolean isLastChild, //  当前子条目是否是最后一条 
				View view,//传递过来的View
				ViewGroup arg4) {
			// TODO Auto-generated method stub
			
			if(view == null)
			{
				view = new TextView(mContext);
				
			}
			TextView tv = (TextView) view;
			
			tv.setTextSize(25);
			tv.setText(mChirldList.get(arg0)[arg1]);
			
			return view;
		}

		//每一组有多少个子元素
		@Override
		public int getChildrenCount(
				int arg0//在哪一个组
				) {
			// TODO Auto-generated method stub
			return mChirldList.get(arg0).length;
		}

		
		
		@Override
		public Object getGroup(int arg0) {
			// TODO Auto-generated method stub
			return mGroupList[arg0];
		}

		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return mGroupList.length;
		}

		@Override
		public long getGroupId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getGroupView(
				int arg0, //第几个group
				boolean arg1,//判断当前的group是否展开的状态
				View view, //传递过来的view
				ViewGroup arg3) {//父类视图
			// TODO Auto-generated method stub
			if(view == null){
				view = new TextView(mContext);
			}
			TextView tv = (TextView) view;
			
			tv.setText(mGroupList[arg0]);
			tv.setTextSize(30);
			
			tv.setTextColor(Color.BLACK);
			
			if(arg1){
				tv.setTextColor(Color.RED);
				
			}else{
				tv.setTextColor(Color.BLACK);
			}
			
			return view;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}

		
		//返回的是true
		@Override
		public boolean isChildSelectable(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return true;
		}
	}

	
	//加载装备数据
	public static List<Equip> loadAllEquip(){
		List<Equip> list = new ArrayList<Equip>();
		EquipAttribute shifu_attr = new EquipAttribute();
		shifu_attr.setAD(8);
		Equip shifu = new Equip(0, "石斧", R.drawable.shifu, 400, null, new String[]{"AD"}, new String[]{"+8攻击力"}, shifu_attr, new int[]{}, new int[]{1,3,17,19,20,21,27,29});
		list.add(shifu);
		
		EquipAttribute kuangbaozhedejujian_attr = new EquipAttribute();
		kuangbaozhedejujian_attr.setAD(21);
		kuangbaozhedejujian_attr.setCD(10);
		kuangbaozhedejujian_attr.setARP(20);
		Equip kuangbaozhedejujian = new Equip(1, "狂暴者的巨剑", R.drawable.kuangbaozhedejujian, 1300, "唯一被动：增加10%的冷却缩减，增加护甲穿透20点。", new String[]{"AD","CD","ARP"}, new String[]{"+21攻击力"}, kuangbaozhedejujian_attr, new int[]{0,0}, new int[]{31,35});
		list.add(kuangbaozhedejujian);
		
		EquipAttribute shengmingjiejing_attr = new EquipAttribute();
		shengmingjiejing_attr.setHp(180);
		Equip shengmingjiejing = new Equip(2, "生命结晶", R.drawable.shengmingjiejing, 475, null, new String[]{"Hp"}, new String[]{"+180点生命值"}, shengmingjiejing_attr, new int[]{}, new int[]{3,30});
		list.add(shengmingjiejing);
		
		EquipAttribute canfeizhichui_attr = new EquipAttribute();
		canfeizhichui_attr.setHp(220);
		canfeizhichui_attr.setAD(15);
		Equip canfeizhichui = new Equip(3, "残废之锤", R.drawable.canfeizhichui, 1275, "唯一被动：普通攻击时有20%的几率降低目标30%移动速度，持续2.5秒", new String[]{"Hp","AD"}, new String[]{"+15攻击力","+220点生命值"}, canfeizhichui_attr, new int[]{0,2}, new int[]{10,41});
		list.add(canfeizhichui);
		
		EquipAttribute zhimingquantao_attr = new EquipAttribute();
		zhimingquantao_attr.setCH(7);
		Equip zhimingquantao = new Equip(4, "致命拳套", R.drawable.zhimingquantao, 400, null, new String[]{"CH"}, new String[]{"+7%暴击几率"}, zhimingquantao_attr, new int[]{}, new int[]{6,30,32});
		list.add(zhimingquantao);
		
		EquipAttribute jifengbi_attr = new EquipAttribute();
		jifengbi_attr.setAS(0.13);
		Equip jifengbi = new Equip(5, "疾风匕", R.drawable.jifengbi, 400, null, new String[]{"CH"}, new String[]{"+13%攻击速度"}, jifengbi_attr, new int[]{}, new int[]{6,23,36,37,42});
		list.add(jifengbi);
		
		EquipAttribute xiongbaoshuangdao_attr = new EquipAttribute();
		xiongbaoshuangdao_attr.setAS(0.13);
		xiongbaoshuangdao_attr.setMS(0.06);
		xiongbaoshuangdao_attr.setCH(9);
		Equip xiongbaoshuangdao = new Equip(6, "凶暴双刀", R.drawable.xiongbaoshuangdao, 1195, null, new String[]{"CH","AS","MS"}, new String[]{"+9%暴击几率","+18%攻击速度","+6%移动速度"}, xiongbaoshuangdao_attr, new int[]{4,5}, new int[]{10,37,39});
		list.add(xiongbaoshuangdao);
		
		EquipAttribute fashujuanzhou_attr = new EquipAttribute();
		fashujuanzhou_attr.setAP(20);
		Equip fashujuanzhou = new Equip(7, "法术卷轴", R.drawable.fashujuanzhou, 435, null, new String[]{"AP"}, new String[]{"+20法术强度"}, fashujuanzhou_attr, new int[]{}, new int[]{9,33});
		list.add(fashujuanzhou);
		
		EquipAttribute falijiejing_attr = new EquipAttribute();
		falijiejing_attr.setMp(200);
		Equip falijiejing = new Equip(8, "法力结晶", R.drawable.falijiejing, 400, null, new String[]{"Mp"}, new String[]{"+200法力值"}, falijiejing_attr, new int[]{}, new int[]{9});
		list.add(falijiejing);
		
		EquipAttribute xulizhijian_attr = new EquipAttribute();
		xulizhijian_attr.setMp(200);
		xulizhijian_attr.setAP(25);
		Equip xulizhijian = new Equip(9, "蓄力之剑", R.drawable.xulizhijian, 1260, "唯一被动：每次使用技能，下次普通攻击的基础攻击力提高100%。（不与三圣器、魔剑瓦莱丁叠加）", new String[]{"Mp","AP"}, new String[]{"+200法力值","+25法术强度"}, xulizhijian_attr, new int[]{7,8}, new int[]{10});
		list.add(xulizhijian);
		
		EquipAttribute sanshengqi_attr = new EquipAttribute();
		sanshengqi_attr.setHp(250);
		sanshengqi_attr.setMp(250);
		sanshengqi_attr.setAD(30);
		sanshengqi_attr.setAP(30);
		sanshengqi_attr.setMS(0.1);
		sanshengqi_attr.setCH(15);
		sanshengqi_attr.setAS(0.3);
		Equip sanshengqi = new Equip(10, "三圣器", R.drawable.sanshengqi, 4030, "唯一被动：每次使用技能，下次普通攻击的基础攻击力提高150%，(不与蓄力之剑、魔剑瓦莱丁叠加）。唯一被动：普通攻击时有20%的几率降低目标30%移动速度，持续2.5秒。", new String[]{"Hp","Mp","AD","AP","MS","CH","AS"}, new String[]{"+250生命值","+250法力值","+30攻击力","+30法术强度","+15%暴击率","+10%移动速度"}, sanshengqi_attr, new int[]{3,6,9}, new int[]{});
		list.add(sanshengqi);
		
		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
		qiyuezhijian_attr.setHp(70);
		qiyuezhijian_attr.setAD(8);
		qiyuezhijian_attr.setLS(3);
		Equip qiyuezhijian = new Equip(11, "契约之剑", R.drawable.qiyuezhijian, 440, "唯一被动：攻击中立生物和敌方非英雄单位时额外造成15点法术伤害", new String[]{"Hp","AD","LS"}, new String[]{"+70生命值","+8攻击力","+3%生命偷取"}, qiyuezhijian_attr, new int[]{}, new int[]{});
		list.add(qiyuezhijian);
		
		EquipAttribute wuxianqiangzhishoutao_attr = new EquipAttribute();
		wuxianqiangzhishoutao_attr.setAD(10);
		Equip wuxianqiangzhishoutao = new Equip(12, "无限枪制手套", R.drawable.wuxianqiangzhishoutao, 440, "唯一主动：射出一把立场标枪，最大射程4，对命中的目标非英雄单位造成等同于攻击力的物理伤害，冷却时间6秒，可以直接击杀带有杀字的小兵。 被动：每次升级为你的英雄永久增加1点攻击力，最多增加10点。", new String[]{"AD","UP"}, new String[]{}, wuxianqiangzhishoutao_attr, new int[]{}, new int[]{});
		list.add(wuxianqiangzhishoutao);
		
		EquipAttribute tongjian_attr = new EquipAttribute();
		tongjian_attr.setAD(22);
		Equip tongjian = new Equip(13, "铜剑", R.drawable.tongjian, 440, null, new String[]{"AD"}, new String[]{"+22攻击力"}, tongjian_attr, new int[]{}, new int[]{24,28,29,30,39});
		list.add(tongjian);
		
		EquipAttribute jiaozhiwen_attr = new EquipAttribute();
		jiaozhiwen_attr.setLS(10);
		Equip jiaozhiwen = new Equip(14, "蚊之吻", R.drawable.jiaozhiwen, 450, null, new String[]{"LS"}, new String[]{"+10%生命偷取"}, jiaozhiwen_attr, new int[]{}, new int[]{18,21,31,38});
		list.add(jiaozhiwen);
		
		EquipAttribute zhuijizhigong_attr = new EquipAttribute();
		zhuijizhigong_attr.setAS(0.4);
		Equip zhuijizhigong = new Equip(15, "追击之弓", R.drawable.zhuijizhigong, 1050, null, new String[]{"Hp","AD","LS"}, new String[]{"+40%攻击速度"}, zhuijizhigong_attr, new int[]{}, new int[]{});
		list.add(zhuijizhigong);
		
		EquipAttribute xuantiejian_attr = new EquipAttribute();
		xuantiejian_attr.setAD(45);
		Equip xuantiejian = new Equip(16, "玄铁剑", R.drawable.xuantiejian, 1650, null, new String[]{"AD"}, new String[]{"+45攻击力"}, xuantiejian_attr, new int[]{}, new int[]{36,38});
		list.add(xuantiejian);
		
		EquipAttribute tuzaizhe_attr = new EquipAttribute();
		tuzaizhe_attr.setAD(15);
		tuzaizhe_attr.setArmor(23);
		Equip tuzaizhe = new Equip(17, "屠宰者", R.drawable.tuzaizhe, 1000, "唯一被动： 普通攻击非英雄单位和中立单位有20%几率对目标造成300点法术伤害。", new String[]{"AD","Armor"}, new String[]{"+15攻击力","+23护甲"}, tuzaizhe_attr, new int[]{0}, new int[]{18});
		list.add(tuzaizhe);
		
		EquipAttribute baobodefeixingchihou_attr = new EquipAttribute();
		baobodefeixingchihou_attr.setArmor(30);
		baobodefeixingchihou_attr.setAD(23);
		baobodefeixingchihou_attr.setLS(12);
		Equip baobodefeixingchihou = new Equip(18, "鲍勃的飞行斥候", R.drawable.baobodefeixingchihou, 1600, "唯一被动：攻击中立生物和敌方非英雄单位时有20%几率对其造成425点法术伤害。 唯一主动：向目标方向释放一盏会飞行的飞行斥候，飞行斥候具有7的空中视野，飞行速度为0.5。飞行斥候碰到敌方英雄就会立即熄灭并且造成3秒的33%减速效果。飞行斥候会在60秒后自动熄灭，冷却时间60秒。", new String[]{"Armor","AD","LS"}, new String[]{"+30护甲","+23攻击力","+12%生命偷取"}, baobodefeixingchihou_attr, new int[]{17,14}, new int[]{});
		list.add(baobodefeixingchihou);
		
		EquipAttribute baobodeanquanqinang_attr = new EquipAttribute();
		baobodeanquanqinang_attr.setAD(25);
		baobodeanquanqinang_attr.setSR(30);
		Equip baobodeanquanqinang = new Equip(19, "鲍勃的安全气囊", R.drawable.baobodeanquanqinang, 1300, "唯一被动：生命值降低到35%以下时收到法术伤害，可以产生一个吸收300点法术伤害的护盾，持续5秒。这个效果60秒最多触发一次。", new String[]{"SR","AD"}, new String[]{"+30法术抗性","+8攻击力"}, baobodeanquanqinang_attr, new int[]{0}, new int[]{40});
		list.add(baobodeanquanqinang);
		
		EquipAttribute feixiangzhijian_attr = new EquipAttribute();
		feixiangzhijian_attr.setAD(68);
		Equip feixiangzhijian = new Equip(20, "绯想之剑", R.drawable.feixiangzhijian, 1350, "唯一被动：击杀或助攻获得叠加状态，（击杀2层助攻1层），每层状态增加3点攻击力，最多叠加32层，死亡时减少1/3，叠满32层后英雄移动速度增加15%。(模拟计算时算20层)", new String[]{"AD","UP"}, new String[]{"+8攻击力"}, feixiangzhijian_attr, new int[]{0}, new int[]{});
		list.add(feixiangzhijian);
		
		EquipAttribute jiqunengliangdao_attr = new EquipAttribute();
		jiqunengliangdao_attr.setAD(32);
		jiqunengliangdao_attr.setLS(12);
		Equip jiqunengliangdao = new Equip(21, "汲取能量刀", R.drawable.jiqunengliangdao, 1700, "唯一主动：为目标英雄造成150点法术伤害，并减缓其50%移动速度，持续3秒。施法距离4，冷却60秒。", new String[]{"AD","LS"}, new String[]{"+32攻击力","+12%生命偷取"}, jiqunengliangdao_attr, new int[]{0,14}, new int[]{22,23});
		list.add(jiqunengliangdao);
		
		EquipAttribute zhipeizhe_attr = new EquipAttribute();
		zhipeizhe_attr.setAP(70);
		zhipeizhe_attr.setAD(40);
		zhipeizhe_attr.setLS(13);
		zhipeizhe_attr.setSV(20);
		Equip zhipeizhe = new Equip(22, "支配者", R.drawable.zhipeizhe, 3425, "【原：先知量子枪】。对目标敌方英雄射出一发子弹，如果该英雄击杀数高于或等于你，则启动歼灭模式，对其造成最大生命值20%加150法术伤害，如果该英雄击杀数低于你，则启动麻醉模式，造成150法术伤害并且让其眩晕1.5秒，冷却时间90秒。 唯一被动：增加20%法术吸血", new String[]{"AP","AD","LS"}, new String[]{"+70法术强度","+40攻击力","+15%生命偷取"}, zhipeizhe_attr, new int[]{21}, new int[]{});
		list.add(zhipeizhe);
		
		EquipAttribute porenzhijian_attr = new EquipAttribute();
		porenzhijian_attr.setAS(0.4);
		porenzhijian_attr.setAD(45);
		porenzhijian_attr.setLS(15);
		Equip porenzhijian = new Equip(23, "破刃之剑", R.drawable.porenzhijian, 3500, "唯一被动：你的普通攻击会造成相当于目标当前生命值的5%的额外物理伤害（对野怪最多造成60点伤害） 唯一主动：对目标英雄使用。造成相当于目标最大生命值的15%（最低100点）的物理伤害，并恢复自己相当于该伤害值的生命值。同时偷取目标30%的移动速度，持续3秒（冷却时间90秒）", new String[]{"AS","AD","LS","MS"}, new String[]{"+40%攻击速度","+45攻击力","+15%生命偷取"}, porenzhijian_attr, new int[]{5,5,21}, new int[]{});
		list.add(porenzhijian);
		
		EquipAttribute hongqiangwei_attr = new EquipAttribute();
		hongqiangwei_attr.setSR(30);
		hongqiangwei_attr.setAD(32);
		Equip hongqiangwei = new Equip(24, "红蔷薇", R.drawable.hongqiangwei, 1750, "唯一被动：普通攻击可以让目标法术强度降低15%，持续1.5秒。", new String[]{"SR","AD"}, new String[]{"+30法术抗性","+32攻击力","+3%生命偷取"}, hongqiangwei_attr, new int[]{13}, new int[]{26});
		list.add(hongqiangwei);
		
		EquipAttribute huangqiangwei_attr = new EquipAttribute();
		huangqiangwei_attr.setAS(0.23);
		huangqiangwei_attr.setLS(11);
		Equip huangqiangwei = new Equip(25, "黄蔷薇", R.drawable.huangqiangwei, 1370, "唯一被动：普通攻击可以让目标获得创伤状态，生命恢复和所有治疗效果减少50%，持续1.5秒。", new String[]{"AS","LS"}, new String[]{"+23%攻击速度","+11%生命偷取"}, huangqiangwei_attr, new int[]{5,14}, new int[]{26});
		list.add(huangqiangwei);
		
		EquipAttribute qiangweishuangqiang_attr = new EquipAttribute();
		qiangweishuangqiang_attr.setAS(0.3);
		qiangweishuangqiang_attr.setAD(40);
		qiangweishuangqiang_attr.setSR(35);
		qiangweishuangqiang_attr.setLS(12);
		Equip qiangweishuangqiang = new Equip(26, "蔷薇双枪", R.drawable.qiangweishuangqiang, 3620, "唯一被动：普通攻击可以让目标获得创伤状态，生命恢复和所有治疗效果减少50%，持续1.5秒。唯一被动：普通攻击可以让目标法术强度降低15%，持续1.5秒。", new String[]{"AS","SR","AD","LS"}, new String[]{"+40攻击力","+35法术抗性","+30%攻击速度","+12%生命偷取"}, qiangweishuangqiang_attr, new int[]{24,25}, new int[]{});
		list.add(qiangweishuangqiang);
		
		EquipAttribute ganggenierzhiqiang_attr = new EquipAttribute();
		ganggenierzhiqiang_attr.setMp(350);
		ganggenierzhiqiang_attr.setAD(18);
		ganggenierzhiqiang_attr.setMpRegen(7);
		Equip ganggenierzhiqiang = new Equip(27, "刚格尼尔之枪", R.drawable.ganggenierzhiqiang, 2095, "被动：2%法力值最大值转化为攻击力。 唯一被动：每次普通攻击会增加1点法力值最大值（3秒内置冷却时间）；每次使用技能增加4点法力值最大值（3秒内置冷却时间），最多增加1000点法力值。", new String[]{"Mp","AD","MpRegen","UP"}, new String[]{"+350法力值","+18攻击力","+7法力回复/5秒"}, ganggenierzhiqiang_attr, new int[]{0}, new int[]{});
		list.add(ganggenierzhiqiang);
		
		EquipAttribute shouzhihuimiezhe_attr = new EquipAttribute();
		shouzhihuimiezhe_attr.setAP(45);
		shouzhihuimiezhe_attr.setAD(35);
		Equip shouzhihuimiezhe = new Equip(28, "手指毁灭者", R.drawable.shouzhihuimiezhe, 2235, "唯一被动：每次攻击或施法增加4%攻击速度和6点法术强度，持续8秒，最多叠加8次。", new String[]{"AP","AD","AS"}, new String[]{"+45法术强度","+35攻击力"}, shouzhihuimiezhe_attr, new int[]{13}, new int[]{});
		list.add(shouzhihuimiezhe);
		
		EquipAttribute qinghongjian_attr = new EquipAttribute();
		qinghongjian_attr.setAD(36);
		qinghongjian_attr.setARPP(40);
		Equip qinghongjian = new Equip(29, "青釭剑", R.drawable.qinghongjian, 2250, "唯一被动：增加40%护甲穿透。", new String[]{"ARP","AD"}, new String[]{"+36攻击力"}, qinghongjian_attr, new int[]{0,13}, new int[]{});
		list.add(qinghongjian);
		
		EquipAttribute canfeizhiqiu_attr = new EquipAttribute();
		canfeizhiqiu_attr.setHp(200);
		canfeizhiqiu_attr.setAD(40);
		canfeizhiqiu_attr.setCH(10);
		Equip canfeizhiqiu = new Equip(30, "残废之球", R.drawable.canfeizhiqiu, 2525, "唯一被动：普通攻击降低目标15点攻击和25法术强度，持续3秒，最多可叠加3层。", new String[]{"Hp","AD","CH"}, new String[]{"+200生命值","+40攻击力","+10%暴击几率"}, canfeizhiqiu_attr, new int[]{2,4,13}, new int[]{});
		list.add(canfeizhiqiu);
		
		EquipAttribute haonanzhiyan_attr = new EquipAttribute();
		haonanzhiyan_attr.setARP(20);
		haonanzhiyan_attr.setCD(10);
		haonanzhiyan_attr.setAD(30);
		haonanzhiyan_attr.setLS(12);
		Equip haonanzhiyan = new Equip(31, "浩南之眼", R.drawable.haonanzhiyan, 2350, "唯一被动：20护甲穿透，加10%冷却缩减。唯一主动：降低目标英雄25%护甲并且获取目标视野，持续4秒，施法距离7，冷却时间60秒。", new String[]{"ARP","CD","AD","LS"}, new String[]{"+30攻击力","+12%生命偷取"}, haonanzhiyan_attr, new int[]{1,14}, new int[]{});
		list.add(haonanzhiyan);

		EquipAttribute limingzhiren_attr = new EquipAttribute();
		limingzhiren_attr.setCH(11);
		Equip limingzhiren = new Equip(32, "立命之刃", R.drawable.limingzhiren, 750, "被动：每次击杀英雄获得30额外金钱奖励，每次助攻获得12额外金钱奖励。", new String[]{"CH","money"}, new String[]{"+11%暴击几率"}, limingzhiren_attr, new int[]{4}, new int[]{35});
		list.add(limingzhiren);
		
		EquipAttribute zhenmingfadian_attr = new EquipAttribute();
		zhenmingfadian_attr.setAP(30);
		zhenmingfadian_attr.setMpRegen(7);
		zhenmingfadian_attr.setCD(10);
		Equip zhenmingfadian = new Equip(33, "真名法典", R.drawable.zhenmingfadian, 1125, "唯一被动：增加10%冷却缩减。", new String[]{"CD","AP","MpRegen"}, new String[]{"+30法术强度","+7法力回复/5秒"}, zhenmingfadian_attr, new int[]{7}, new int[]{34});
		list.add(zhenmingfadian);
		
		EquipAttribute yuanhuanzhili_attr = new EquipAttribute();
		yuanhuanzhili_attr.setAP(35);
		yuanhuanzhili_attr.setAS(0.45);
		yuanhuanzhili_attr.setMpRegen(8);
		yuanhuanzhili_attr.setCD(15);
		Equip yuanhuanzhili = new Equip(34, "圆环之理", R.drawable.yuanhuanzhili, 2700, "唯一被动：增加15%冷却缩减。唯一被动：你的普通攻击对目标造成额外32点法术伤害并减少6点法术抗性，减少法术抗性的状态最多叠加4次。", new String[]{"AP","AS","CD","MpRegen","SP"}, new String[]{"+35法术强度","+45%攻击速度","+8法力回复/5秒"}, yuanhuanzhili_attr, new int[]{33,42}, new int[]{});
		list.add(yuanhuanzhili);
		
		EquipAttribute caotijian_attr = new EquipAttribute();
		caotijian_attr.setCD(15);
		caotijian_attr.setARP(20);
		caotijian_attr.setAD(30);
		caotijian_attr.setCH(15);
		Equip caotijian = new Equip(35, "草薙剑", R.drawable.caotijian, 2895, "唯一主动：增加移动速度20%，攻击速度50%，持续8秒，冷却60秒。 唯一被动：增加15%冷却缩减。唯一被动：增加20护甲穿透。", new String[]{"AS","AD","MS","CD","ARP","CH"}, new String[]{"+30攻击力","+15%暴击几率"}, caotijian_attr, new int[]{1,32}, new int[]{});
		list.add(caotijian);
		
		EquipAttribute tiansuozhanyue_attr = new EquipAttribute();
		tiansuozhanyue_attr.setAD(55);
		tiansuozhanyue_attr.setAS(0.3);
		Equip tiansuozhanyue = new Equip(36, "天锁斩月", R.drawable.tiansuozhanyue, 2865, "唯一被动：物理攻击可以降低目标10点护甲，持续5秒，最多叠加4次。", new String[]{"AS","AD","ARP"}, new String[]{"+55攻击力","+30%攻击速度"}, tiansuozhanyue_attr, new int[]{5,16}, new int[]{});
		list.add(tiansuozhanyue);
		
		EquipAttribute yinsushouren_attr = new EquipAttribute();
		yinsushouren_attr.setMS(0.1);
		yinsushouren_attr.setAS(0.55);
		yinsushouren_attr.setCH(30);
		Equip yinsushouren = new Equip(37, "音速手刃", R.drawable.yinsushouren, 2895, null, new String[]{"CH","AS","MS"}, new String[]{"+10%移动速度","+55%攻击速度","+30%暴击几率"}, yinsushouren_attr, new int[]{5,6}, new int[]{});
		list.add(yinsushouren);
		
		EquipAttribute yaodaocunzheng_attr = new EquipAttribute();
		yaodaocunzheng_attr.setAD(60);
		yaodaocunzheng_attr.setLS(12);
		Equip yaodaocunzheng = new Equip(38, "妖刀村正", R.drawable.yaodaocunzheng, 3000, "被动：每杀一个敌方单位获得1点攻击力和0.2%生命偷取，最多40攻击力和8%生命偷取，额外获得加成会在英雄死亡后减半。", new String[]{"Hp","AD","LS","UP"}, new String[]{"+60攻击力","+12%生命偷取"}, yaodaocunzheng_attr, new int[]{14,16}, new int[]{});
		list.add(yaodaocunzheng);
		
		EquipAttribute hushenbishou_attr = new EquipAttribute();
		hushenbishou_attr.setAD(40);
		hushenbishou_attr.setMS(0.06);
		hushenbishou_attr.setAS(0.3);
		hushenbishou_attr.setCH(15);
		Equip hushenbishou = new Equip(39, "护身匕首", R.drawable.hushenbishou, 3000, "唯一主动：使用后披上三层护盾，每层护盾可以抵消一次伤害，护盾3秒后会消失，冷却时间90秒", new String[]{"AS","AD","MS","CH"}, new String[]{"+40生命值","+6%移动速度","+30%攻击速度","+15%暴击几率"}, hushenbishou_attr, new int[]{6,13}, new int[]{});
		list.add(hushenbishou);
		
		EquipAttribute huanxiangshashou_attr = new EquipAttribute();
		huanxiangshashou_attr.setHp(450);
		huanxiangshashou_attr.setSR(35);
		huanxiangshashou_attr.setAD(35);
		Equip huanxiangshashou = new Equip(40, "幻想杀手", R.drawable.huanxiangshashou, 3130, "唯一被动：每次受到来自敌方的法术伤害，可以提高5点攻击力和2%移动速度，持续5秒，最多可叠加7次。唯一被动：当生命值降低到35%以下时受到法术伤害可以产生一个吸收350点法术伤害的护盾，持续5秒，这个效果每60秒最多触发一次。", new String[]{"Hp","AD","SR","MS"}, new String[]{"+450生命值","+35攻击力","+35法术抗性"}, huanxiangshashou_attr, new int[]{19}, new int[]{});
		list.add(huanxiangshashou);
		
		EquipAttribute shuangzhiaishang_attr = new EquipAttribute();
		shuangzhiaishang_attr.setHp(700);
		shuangzhiaishang_attr.setAD(20);
		Equip shuangzhiaishang = new Equip(41, "霜之哀伤", R.drawable.shuangzhiaishang, 3150, "唯一被动：普通攻击降低目标40%（远程30%）移动速度，持续2.5秒", new String[]{"Hp","AD"}, new String[]{"+70生命值","+8攻击力","+3%生命偷取"}, shuangzhiaishang_attr, new int[]{3}, new int[]{});
		list.add(shuangzhiaishang);
		
		EquipAttribute heilongpibian_attr = new EquipAttribute();
		heilongpibian_attr.setAS(35);
		Equip heilongpibian = new Equip(42, "黑龙皮鞭", R.drawable.heilongpibian, 1240, "唯一被动：你的普通攻击可以对目标造成额外20点法术伤害", new String[]{"AS"}, new String[]{"+35%攻击速度"}, heilongpibian_attr, new int[]{5,5}, new int[]{34});
		list.add(heilongpibian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "契约之剑", R.drawable.qiyuezhijian, 440, "唯一被动：攻击中立生物和敌方非英雄单位时额外造成15点法术伤害", new String[]{"Hp","AD","LS"}, new String[]{"+70生命值","+8攻击力","+3%生命偷取"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "契约之剑", R.drawable.qiyuezhijian, 440, "唯一被动：攻击中立生物和敌方非英雄单位时额外造成15点法术伤害", new String[]{"Hp","AD","LS"}, new String[]{"+70生命值","+8攻击力","+3%生命偷取"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "契约之剑", R.drawable.qiyuezhijian, 440, "唯一被动：攻击中立生物和敌方非英雄单位时额外造成15点法术伤害", new String[]{"Hp","AD","LS"}, new String[]{"+70生命值","+8攻击力","+3%生命偷取"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "契约之剑", R.drawable.qiyuezhijian, 440, "唯一被动：攻击中立生物和敌方非英雄单位时额外造成15点法术伤害", new String[]{"Hp","AD","LS"}, new String[]{"+70生命值","+8攻击力","+3%生命偷取"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
		return list;
	}
}
