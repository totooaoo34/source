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
		// ���ô�����Ļ��ģʽ
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);

		// ���û����˵���ͼ�Ŀ��
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// ���ý��뽥��Ч����ֵ
		menu.setFadeDegree(0.35f);
		
		//��ʼ���ؼ�
		//��������
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
		
		//��������
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
		
		//��������
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
		
		//������
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
	
	//�໬����¼������Ӳ˵�
	public void ViewGONE(List<TextView> list){
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setVisibility(View.GONE);
		}
	}
	//�໬����¼���ʾ�Ӳ˵�
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
	
	
	//��ʼ������װ��
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
	
	//���ݶ�λɸѡװ��
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
	
	//�໬���ExpandableListAdapter
	class MyAdapter extends BaseExpandableListAdapter{
		String[] mGroupList;
		Context mContext;
		List<String[]> mChirldList;
		//�����ݴ��ݽ���
		public MyAdapter(String[] groupString,List<String[]> chirldList,Context context ){
			mGroupList = groupString;
			mContext = context;
			mChirldList = chirldList;
		}
		
		//��ȡһ����Ԫ��
		@Override
		public Object getChild(
				int arg0, //���Ǹ�����
				int arg1) {//�����е��Ǹ�λ��
			
			return mChirldList.get(arg0)[arg1];
		}

		@Override
		public long getChildId(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return arg1;
		}
		
		@Override
		public View getChildView(
				int arg0, //����һ����
				int arg1, //���������һ��
				boolean isLastChild, //  ��ǰ����Ŀ�Ƿ������һ�� 
				View view,//���ݹ�����View
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

		//ÿһ���ж��ٸ���Ԫ��
		@Override
		public int getChildrenCount(
				int arg0//����һ����
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
				int arg0, //�ڼ���group
				boolean arg1,//�жϵ�ǰ��group�Ƿ�չ����״̬
				View view, //���ݹ�����view
				ViewGroup arg3) {//������ͼ
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

		
		//���ص���true
		@Override
		public boolean isChildSelectable(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return true;
		}
	}

	
	//����װ������
	public static List<Equip> loadAllEquip(){
		List<Equip> list = new ArrayList<Equip>();
		EquipAttribute shifu_attr = new EquipAttribute();
		shifu_attr.setAD(8);
		Equip shifu = new Equip(0, "ʯ��", R.drawable.shifu, 400, null, new String[]{"AD"}, new String[]{"+8������"}, shifu_attr, new int[]{}, new int[]{1,3,17,19,20,21,27,29});
		list.add(shifu);
		
		EquipAttribute kuangbaozhedejujian_attr = new EquipAttribute();
		kuangbaozhedejujian_attr.setAD(21);
		kuangbaozhedejujian_attr.setCD(10);
		kuangbaozhedejujian_attr.setARP(20);
		Equip kuangbaozhedejujian = new Equip(1, "���ߵľ޽�", R.drawable.kuangbaozhedejujian, 1300, "Ψһ����������10%����ȴ���������ӻ��״�͸20�㡣", new String[]{"AD","CD","ARP"}, new String[]{"+21������"}, kuangbaozhedejujian_attr, new int[]{0,0}, new int[]{31,35});
		list.add(kuangbaozhedejujian);
		
		EquipAttribute shengmingjiejing_attr = new EquipAttribute();
		shengmingjiejing_attr.setHp(180);
		Equip shengmingjiejing = new Equip(2, "�����ᾧ", R.drawable.shengmingjiejing, 475, null, new String[]{"Hp"}, new String[]{"+180������ֵ"}, shengmingjiejing_attr, new int[]{}, new int[]{3,30});
		list.add(shengmingjiejing);
		
		EquipAttribute canfeizhichui_attr = new EquipAttribute();
		canfeizhichui_attr.setHp(220);
		canfeizhichui_attr.setAD(15);
		Equip canfeizhichui = new Equip(3, "�з�֮��", R.drawable.canfeizhichui, 1275, "Ψһ��������ͨ����ʱ��20%�ļ��ʽ���Ŀ��30%�ƶ��ٶȣ�����2.5��", new String[]{"Hp","AD"}, new String[]{"+15������","+220������ֵ"}, canfeizhichui_attr, new int[]{0,2}, new int[]{10,41});
		list.add(canfeizhichui);
		
		EquipAttribute zhimingquantao_attr = new EquipAttribute();
		zhimingquantao_attr.setCH(7);
		Equip zhimingquantao = new Equip(4, "����ȭ��", R.drawable.zhimingquantao, 400, null, new String[]{"CH"}, new String[]{"+7%��������"}, zhimingquantao_attr, new int[]{}, new int[]{6,30,32});
		list.add(zhimingquantao);
		
		EquipAttribute jifengbi_attr = new EquipAttribute();
		jifengbi_attr.setAS(0.13);
		Equip jifengbi = new Equip(5, "����ذ", R.drawable.jifengbi, 400, null, new String[]{"CH"}, new String[]{"+13%�����ٶ�"}, jifengbi_attr, new int[]{}, new int[]{6,23,36,37,42});
		list.add(jifengbi);
		
		EquipAttribute xiongbaoshuangdao_attr = new EquipAttribute();
		xiongbaoshuangdao_attr.setAS(0.13);
		xiongbaoshuangdao_attr.setMS(0.06);
		xiongbaoshuangdao_attr.setCH(9);
		Equip xiongbaoshuangdao = new Equip(6, "�ױ�˫��", R.drawable.xiongbaoshuangdao, 1195, null, new String[]{"CH","AS","MS"}, new String[]{"+9%��������","+18%�����ٶ�","+6%�ƶ��ٶ�"}, xiongbaoshuangdao_attr, new int[]{4,5}, new int[]{10,37,39});
		list.add(xiongbaoshuangdao);
		
		EquipAttribute fashujuanzhou_attr = new EquipAttribute();
		fashujuanzhou_attr.setAP(20);
		Equip fashujuanzhou = new Equip(7, "��������", R.drawable.fashujuanzhou, 435, null, new String[]{"AP"}, new String[]{"+20����ǿ��"}, fashujuanzhou_attr, new int[]{}, new int[]{9,33});
		list.add(fashujuanzhou);
		
		EquipAttribute falijiejing_attr = new EquipAttribute();
		falijiejing_attr.setMp(200);
		Equip falijiejing = new Equip(8, "�����ᾧ", R.drawable.falijiejing, 400, null, new String[]{"Mp"}, new String[]{"+200����ֵ"}, falijiejing_attr, new int[]{}, new int[]{9});
		list.add(falijiejing);
		
		EquipAttribute xulizhijian_attr = new EquipAttribute();
		xulizhijian_attr.setMp(200);
		xulizhijian_attr.setAP(25);
		Equip xulizhijian = new Equip(9, "����֮��", R.drawable.xulizhijian, 1260, "Ψһ������ÿ��ʹ�ü��ܣ��´���ͨ�����Ļ������������100%����������ʥ����ħ�����������ӣ�", new String[]{"Mp","AP"}, new String[]{"+200����ֵ","+25����ǿ��"}, xulizhijian_attr, new int[]{7,8}, new int[]{10});
		list.add(xulizhijian);
		
		EquipAttribute sanshengqi_attr = new EquipAttribute();
		sanshengqi_attr.setHp(250);
		sanshengqi_attr.setMp(250);
		sanshengqi_attr.setAD(30);
		sanshengqi_attr.setAP(30);
		sanshengqi_attr.setMS(0.1);
		sanshengqi_attr.setCH(15);
		sanshengqi_attr.setAS(0.3);
		Equip sanshengqi = new Equip(10, "��ʥ��", R.drawable.sanshengqi, 4030, "Ψһ������ÿ��ʹ�ü��ܣ��´���ͨ�����Ļ������������150%��(��������֮����ħ�����������ӣ���Ψһ��������ͨ����ʱ��20%�ļ��ʽ���Ŀ��30%�ƶ��ٶȣ�����2.5�롣", new String[]{"Hp","Mp","AD","AP","MS","CH","AS"}, new String[]{"+250����ֵ","+250����ֵ","+30������","+30����ǿ��","+15%������","+10%�ƶ��ٶ�"}, sanshengqi_attr, new int[]{3,6,9}, new int[]{});
		list.add(sanshengqi);
		
		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
		qiyuezhijian_attr.setHp(70);
		qiyuezhijian_attr.setAD(8);
		qiyuezhijian_attr.setLS(3);
		Equip qiyuezhijian = new Equip(11, "��Լ֮��", R.drawable.qiyuezhijian, 440, "Ψһ������������������͵з���Ӣ�۵�λʱ�������15�㷨���˺�", new String[]{"Hp","AD","LS"}, new String[]{"+70����ֵ","+8������","+3%����͵ȡ"}, qiyuezhijian_attr, new int[]{}, new int[]{});
		list.add(qiyuezhijian);
		
		EquipAttribute wuxianqiangzhishoutao_attr = new EquipAttribute();
		wuxianqiangzhishoutao_attr.setAD(10);
		Equip wuxianqiangzhishoutao = new Equip(12, "����ǹ������", R.drawable.wuxianqiangzhishoutao, 440, "Ψһ���������һ��������ǹ��������4�������е�Ŀ���Ӣ�۵�λ��ɵ�ͬ�ڹ������������˺�����ȴʱ��6�룬����ֱ�ӻ�ɱ����ɱ�ֵ�С���� ������ÿ������Ϊ���Ӣ����������1�㹥�������������10�㡣", new String[]{"AD","UP"}, new String[]{}, wuxianqiangzhishoutao_attr, new int[]{}, new int[]{});
		list.add(wuxianqiangzhishoutao);
		
		EquipAttribute tongjian_attr = new EquipAttribute();
		tongjian_attr.setAD(22);
		Equip tongjian = new Equip(13, "ͭ��", R.drawable.tongjian, 440, null, new String[]{"AD"}, new String[]{"+22������"}, tongjian_attr, new int[]{}, new int[]{24,28,29,30,39});
		list.add(tongjian);
		
		EquipAttribute jiaozhiwen_attr = new EquipAttribute();
		jiaozhiwen_attr.setLS(10);
		Equip jiaozhiwen = new Equip(14, "��֮��", R.drawable.jiaozhiwen, 450, null, new String[]{"LS"}, new String[]{"+10%����͵ȡ"}, jiaozhiwen_attr, new int[]{}, new int[]{18,21,31,38});
		list.add(jiaozhiwen);
		
		EquipAttribute zhuijizhigong_attr = new EquipAttribute();
		zhuijizhigong_attr.setAS(0.4);
		Equip zhuijizhigong = new Equip(15, "׷��֮��", R.drawable.zhuijizhigong, 1050, null, new String[]{"Hp","AD","LS"}, new String[]{"+40%�����ٶ�"}, zhuijizhigong_attr, new int[]{}, new int[]{});
		list.add(zhuijizhigong);
		
		EquipAttribute xuantiejian_attr = new EquipAttribute();
		xuantiejian_attr.setAD(45);
		Equip xuantiejian = new Equip(16, "������", R.drawable.xuantiejian, 1650, null, new String[]{"AD"}, new String[]{"+45������"}, xuantiejian_attr, new int[]{}, new int[]{36,38});
		list.add(xuantiejian);
		
		EquipAttribute tuzaizhe_attr = new EquipAttribute();
		tuzaizhe_attr.setAD(15);
		tuzaizhe_attr.setArmor(23);
		Equip tuzaizhe = new Equip(17, "������", R.drawable.tuzaizhe, 1000, "Ψһ������ ��ͨ������Ӣ�۵�λ��������λ��20%���ʶ�Ŀ�����300�㷨���˺���", new String[]{"AD","Armor"}, new String[]{"+15������","+23����"}, tuzaizhe_attr, new int[]{0}, new int[]{18});
		list.add(tuzaizhe);
		
		EquipAttribute baobodefeixingchihou_attr = new EquipAttribute();
		baobodefeixingchihou_attr.setArmor(30);
		baobodefeixingchihou_attr.setAD(23);
		baobodefeixingchihou_attr.setLS(12);
		Equip baobodefeixingchihou = new Equip(18, "�����ķ��г��", R.drawable.baobodefeixingchihou, 1600, "Ψһ������������������͵з���Ӣ�۵�λʱ��20%���ʶ������425�㷨���˺��� Ψһ��������Ŀ�귽���ͷ�һյ����еķ��г�򣬷��г�����7�Ŀ�����Ұ�������ٶ�Ϊ0.5�����г�������з�Ӣ�۾ͻ�����Ϩ�������3���33%����Ч�������г�����60����Զ�Ϩ����ȴʱ��60�롣", new String[]{"Armor","AD","LS"}, new String[]{"+30����","+23������","+12%����͵ȡ"}, baobodefeixingchihou_attr, new int[]{17,14}, new int[]{});
		list.add(baobodefeixingchihou);
		
		EquipAttribute baobodeanquanqinang_attr = new EquipAttribute();
		baobodeanquanqinang_attr.setAD(25);
		baobodeanquanqinang_attr.setSR(30);
		Equip baobodeanquanqinang = new Equip(19, "�����İ�ȫ����", R.drawable.baobodeanquanqinang, 1300, "Ψһ����������ֵ���͵�35%����ʱ�յ������˺������Բ���һ������300�㷨���˺��Ļ��ܣ�����5�롣���Ч��60����ഥ��һ�Ρ�", new String[]{"SR","AD"}, new String[]{"+30��������","+8������"}, baobodeanquanqinang_attr, new int[]{0}, new int[]{40});
		list.add(baobodeanquanqinang);
		
		EquipAttribute feixiangzhijian_attr = new EquipAttribute();
		feixiangzhijian_attr.setAD(68);
		Equip feixiangzhijian = new Equip(20, "���֮��", R.drawable.feixiangzhijian, 1350, "Ψһ��������ɱ��������õ���״̬������ɱ2������1�㣩��ÿ��״̬����3�㹥������������32�㣬����ʱ����1/3������32���Ӣ���ƶ��ٶ�����15%��(ģ�����ʱ��20��)", new String[]{"AD","UP"}, new String[]{"+8������"}, feixiangzhijian_attr, new int[]{0}, new int[]{});
		list.add(feixiangzhijian);
		
		EquipAttribute jiqunengliangdao_attr = new EquipAttribute();
		jiqunengliangdao_attr.setAD(32);
		jiqunengliangdao_attr.setLS(12);
		Equip jiqunengliangdao = new Equip(21, "��ȡ������", R.drawable.jiqunengliangdao, 1700, "Ψһ������ΪĿ��Ӣ�����150�㷨���˺�����������50%�ƶ��ٶȣ�����3�롣ʩ������4����ȴ60�롣", new String[]{"AD","LS"}, new String[]{"+32������","+12%����͵ȡ"}, jiqunengliangdao_attr, new int[]{0,14}, new int[]{22,23});
		list.add(jiqunengliangdao);
		
		EquipAttribute zhipeizhe_attr = new EquipAttribute();
		zhipeizhe_attr.setAP(70);
		zhipeizhe_attr.setAD(40);
		zhipeizhe_attr.setLS(13);
		zhipeizhe_attr.setSV(20);
		Equip zhipeizhe = new Equip(22, "֧����", R.drawable.zhipeizhe, 3425, "��ԭ����֪����ǹ������Ŀ��з�Ӣ�����һ���ӵ��������Ӣ�ۻ�ɱ�����ڻ�����㣬����������ģʽ����������������ֵ20%��150�����˺��������Ӣ�ۻ�ɱ�������㣬����������ģʽ�����150�����˺���������ѣ��1.5�룬��ȴʱ��90�롣 Ψһ����������20%������Ѫ", new String[]{"AP","AD","LS"}, new String[]{"+70����ǿ��","+40������","+15%����͵ȡ"}, zhipeizhe_attr, new int[]{21}, new int[]{});
		list.add(zhipeizhe);
		
		EquipAttribute porenzhijian_attr = new EquipAttribute();
		porenzhijian_attr.setAS(0.4);
		porenzhijian_attr.setAD(45);
		porenzhijian_attr.setLS(15);
		Equip porenzhijian = new Equip(23, "����֮��", R.drawable.porenzhijian, 3500, "Ψһ�����������ͨ����������൱��Ŀ�굱ǰ����ֵ��5%�Ķ��������˺�����Ұ��������60���˺��� Ψһ��������Ŀ��Ӣ��ʹ�á�����൱��Ŀ���������ֵ��15%�����100�㣩�������˺������ָ��Լ��൱�ڸ��˺�ֵ������ֵ��ͬʱ͵ȡĿ��30%���ƶ��ٶȣ�����3�루��ȴʱ��90�룩", new String[]{"AS","AD","LS","MS"}, new String[]{"+40%�����ٶ�","+45������","+15%����͵ȡ"}, porenzhijian_attr, new int[]{5,5,21}, new int[]{});
		list.add(porenzhijian);
		
		EquipAttribute hongqiangwei_attr = new EquipAttribute();
		hongqiangwei_attr.setSR(30);
		hongqiangwei_attr.setAD(32);
		Equip hongqiangwei = new Equip(24, "��Ǿޱ", R.drawable.hongqiangwei, 1750, "Ψһ��������ͨ����������Ŀ�귨��ǿ�Ƚ���15%������1.5�롣", new String[]{"SR","AD"}, new String[]{"+30��������","+32������","+3%����͵ȡ"}, hongqiangwei_attr, new int[]{13}, new int[]{26});
		list.add(hongqiangwei);
		
		EquipAttribute huangqiangwei_attr = new EquipAttribute();
		huangqiangwei_attr.setAS(0.23);
		huangqiangwei_attr.setLS(11);
		Equip huangqiangwei = new Equip(25, "��Ǿޱ", R.drawable.huangqiangwei, 1370, "Ψһ��������ͨ����������Ŀ���ô���״̬�������ָ�����������Ч������50%������1.5�롣", new String[]{"AS","LS"}, new String[]{"+23%�����ٶ�","+11%����͵ȡ"}, huangqiangwei_attr, new int[]{5,14}, new int[]{26});
		list.add(huangqiangwei);
		
		EquipAttribute qiangweishuangqiang_attr = new EquipAttribute();
		qiangweishuangqiang_attr.setAS(0.3);
		qiangweishuangqiang_attr.setAD(40);
		qiangweishuangqiang_attr.setSR(35);
		qiangweishuangqiang_attr.setLS(12);
		Equip qiangweishuangqiang = new Equip(26, "Ǿޱ˫ǹ", R.drawable.qiangweishuangqiang, 3620, "Ψһ��������ͨ����������Ŀ���ô���״̬�������ָ�����������Ч������50%������1.5�롣Ψһ��������ͨ����������Ŀ�귨��ǿ�Ƚ���15%������1.5�롣", new String[]{"AS","SR","AD","LS"}, new String[]{"+40������","+35��������","+30%�����ٶ�","+12%����͵ȡ"}, qiangweishuangqiang_attr, new int[]{24,25}, new int[]{});
		list.add(qiangweishuangqiang);
		
		EquipAttribute ganggenierzhiqiang_attr = new EquipAttribute();
		ganggenierzhiqiang_attr.setMp(350);
		ganggenierzhiqiang_attr.setAD(18);
		ganggenierzhiqiang_attr.setMpRegen(7);
		Equip ganggenierzhiqiang = new Equip(27, "�ո����֮ǹ", R.drawable.ganggenierzhiqiang, 2095, "������2%����ֵ���ֵת��Ϊ�������� Ψһ������ÿ����ͨ����������1�㷨��ֵ���ֵ��3��������ȴʱ�䣩��ÿ��ʹ�ü�������4�㷨��ֵ���ֵ��3��������ȴʱ�䣩���������1000�㷨��ֵ��", new String[]{"Mp","AD","MpRegen","UP"}, new String[]{"+350����ֵ","+18������","+7�����ظ�/5��"}, ganggenierzhiqiang_attr, new int[]{0}, new int[]{});
		list.add(ganggenierzhiqiang);
		
		EquipAttribute shouzhihuimiezhe_attr = new EquipAttribute();
		shouzhihuimiezhe_attr.setAP(45);
		shouzhihuimiezhe_attr.setAD(35);
		Equip shouzhihuimiezhe = new Equip(28, "��ָ������", R.drawable.shouzhihuimiezhe, 2235, "Ψһ������ÿ�ι�����ʩ������4%�����ٶȺ�6�㷨��ǿ�ȣ�����8�룬������8�Ρ�", new String[]{"AP","AD","AS"}, new String[]{"+45����ǿ��","+35������"}, shouzhihuimiezhe_attr, new int[]{13}, new int[]{});
		list.add(shouzhihuimiezhe);
		
		EquipAttribute qinghongjian_attr = new EquipAttribute();
		qinghongjian_attr.setAD(36);
		qinghongjian_attr.setARPP(40);
		Equip qinghongjian = new Equip(29, "���G��", R.drawable.qinghongjian, 2250, "Ψһ����������40%���״�͸��", new String[]{"ARP","AD"}, new String[]{"+36������"}, qinghongjian_attr, new int[]{0,13}, new int[]{});
		list.add(qinghongjian);
		
		EquipAttribute canfeizhiqiu_attr = new EquipAttribute();
		canfeizhiqiu_attr.setHp(200);
		canfeizhiqiu_attr.setAD(40);
		canfeizhiqiu_attr.setCH(10);
		Equip canfeizhiqiu = new Equip(30, "�з�֮��", R.drawable.canfeizhiqiu, 2525, "Ψһ��������ͨ��������Ŀ��15�㹥����25����ǿ�ȣ�����3�룬���ɵ���3�㡣", new String[]{"Hp","AD","CH"}, new String[]{"+200����ֵ","+40������","+10%��������"}, canfeizhiqiu_attr, new int[]{2,4,13}, new int[]{});
		list.add(canfeizhiqiu);
		
		EquipAttribute haonanzhiyan_attr = new EquipAttribute();
		haonanzhiyan_attr.setARP(20);
		haonanzhiyan_attr.setCD(10);
		haonanzhiyan_attr.setAD(30);
		haonanzhiyan_attr.setLS(12);
		Equip haonanzhiyan = new Equip(31, "����֮��", R.drawable.haonanzhiyan, 2350, "Ψһ������20���״�͸����10%��ȴ������Ψһ����������Ŀ��Ӣ��25%���ײ��һ�ȡĿ����Ұ������4�룬ʩ������7����ȴʱ��60�롣", new String[]{"ARP","CD","AD","LS"}, new String[]{"+30������","+12%����͵ȡ"}, haonanzhiyan_attr, new int[]{1,14}, new int[]{});
		list.add(haonanzhiyan);

		EquipAttribute limingzhiren_attr = new EquipAttribute();
		limingzhiren_attr.setCH(11);
		Equip limingzhiren = new Equip(32, "����֮��", R.drawable.limingzhiren, 750, "������ÿ�λ�ɱӢ�ۻ��30�����Ǯ������ÿ���������12�����Ǯ������", new String[]{"CH","money"}, new String[]{"+11%��������"}, limingzhiren_attr, new int[]{4}, new int[]{35});
		list.add(limingzhiren);
		
		EquipAttribute zhenmingfadian_attr = new EquipAttribute();
		zhenmingfadian_attr.setAP(30);
		zhenmingfadian_attr.setMpRegen(7);
		zhenmingfadian_attr.setCD(10);
		Equip zhenmingfadian = new Equip(33, "��������", R.drawable.zhenmingfadian, 1125, "Ψһ����������10%��ȴ������", new String[]{"CD","AP","MpRegen"}, new String[]{"+30����ǿ��","+7�����ظ�/5��"}, zhenmingfadian_attr, new int[]{7}, new int[]{34});
		list.add(zhenmingfadian);
		
		EquipAttribute yuanhuanzhili_attr = new EquipAttribute();
		yuanhuanzhili_attr.setAP(35);
		yuanhuanzhili_attr.setAS(0.45);
		yuanhuanzhili_attr.setMpRegen(8);
		yuanhuanzhili_attr.setCD(15);
		Equip yuanhuanzhili = new Equip(34, "Բ��֮��", R.drawable.yuanhuanzhili, 2700, "Ψһ����������15%��ȴ������Ψһ�����������ͨ������Ŀ����ɶ���32�㷨���˺�������6�㷨�����ԣ����ٷ������Ե�״̬������4�Ρ�", new String[]{"AP","AS","CD","MpRegen","SP"}, new String[]{"+35����ǿ��","+45%�����ٶ�","+8�����ظ�/5��"}, yuanhuanzhili_attr, new int[]{33,42}, new int[]{});
		list.add(yuanhuanzhili);
		
		EquipAttribute caotijian_attr = new EquipAttribute();
		caotijian_attr.setCD(15);
		caotijian_attr.setARP(20);
		caotijian_attr.setAD(30);
		caotijian_attr.setCH(15);
		Equip caotijian = new Equip(35, "���S��", R.drawable.caotijian, 2895, "Ψһ�����������ƶ��ٶ�20%�������ٶ�50%������8�룬��ȴ60�롣 Ψһ����������15%��ȴ������Ψһ����������20���״�͸��", new String[]{"AS","AD","MS","CD","ARP","CH"}, new String[]{"+30������","+15%��������"}, caotijian_attr, new int[]{1,32}, new int[]{});
		list.add(caotijian);
		
		EquipAttribute tiansuozhanyue_attr = new EquipAttribute();
		tiansuozhanyue_attr.setAD(55);
		tiansuozhanyue_attr.setAS(0.3);
		Equip tiansuozhanyue = new Equip(36, "����ն��", R.drawable.tiansuozhanyue, 2865, "Ψһ���������������Խ���Ŀ��10�㻤�ף�����5�룬������4�Ρ�", new String[]{"AS","AD","ARP"}, new String[]{"+55������","+30%�����ٶ�"}, tiansuozhanyue_attr, new int[]{5,16}, new int[]{});
		list.add(tiansuozhanyue);
		
		EquipAttribute yinsushouren_attr = new EquipAttribute();
		yinsushouren_attr.setMS(0.1);
		yinsushouren_attr.setAS(0.55);
		yinsushouren_attr.setCH(30);
		Equip yinsushouren = new Equip(37, "��������", R.drawable.yinsushouren, 2895, null, new String[]{"CH","AS","MS"}, new String[]{"+10%�ƶ��ٶ�","+55%�����ٶ�","+30%��������"}, yinsushouren_attr, new int[]{5,6}, new int[]{});
		list.add(yinsushouren);
		
		EquipAttribute yaodaocunzheng_attr = new EquipAttribute();
		yaodaocunzheng_attr.setAD(60);
		yaodaocunzheng_attr.setLS(12);
		Equip yaodaocunzheng = new Equip(38, "��������", R.drawable.yaodaocunzheng, 3000, "������ÿɱһ���з���λ���1�㹥������0.2%����͵ȡ�����40��������8%����͵ȡ�������üӳɻ���Ӣ����������롣", new String[]{"Hp","AD","LS","UP"}, new String[]{"+60������","+12%����͵ȡ"}, yaodaocunzheng_attr, new int[]{14,16}, new int[]{});
		list.add(yaodaocunzheng);
		
		EquipAttribute hushenbishou_attr = new EquipAttribute();
		hushenbishou_attr.setAD(40);
		hushenbishou_attr.setMS(0.06);
		hushenbishou_attr.setAS(0.3);
		hushenbishou_attr.setCH(15);
		Equip hushenbishou = new Equip(39, "����ذ��", R.drawable.hushenbishou, 3000, "Ψһ������ʹ�ú��������㻤�ܣ�ÿ�㻤�ܿ��Ե���һ���˺�������3������ʧ����ȴʱ��90��", new String[]{"AS","AD","MS","CH"}, new String[]{"+40����ֵ","+6%�ƶ��ٶ�","+30%�����ٶ�","+15%��������"}, hushenbishou_attr, new int[]{6,13}, new int[]{});
		list.add(hushenbishou);
		
		EquipAttribute huanxiangshashou_attr = new EquipAttribute();
		huanxiangshashou_attr.setHp(450);
		huanxiangshashou_attr.setSR(35);
		huanxiangshashou_attr.setAD(35);
		Equip huanxiangshashou = new Equip(40, "����ɱ��", R.drawable.huanxiangshashou, 3130, "Ψһ������ÿ���ܵ����Եз��ķ����˺����������5�㹥������2%�ƶ��ٶȣ�����5�룬���ɵ���7�Ρ�Ψһ������������ֵ���͵�35%����ʱ�ܵ������˺����Բ���һ������350�㷨���˺��Ļ��ܣ�����5�룬���Ч��ÿ60����ഥ��һ�Ρ�", new String[]{"Hp","AD","SR","MS"}, new String[]{"+450����ֵ","+35������","+35��������"}, huanxiangshashou_attr, new int[]{19}, new int[]{});
		list.add(huanxiangshashou);
		
		EquipAttribute shuangzhiaishang_attr = new EquipAttribute();
		shuangzhiaishang_attr.setHp(700);
		shuangzhiaishang_attr.setAD(20);
		Equip shuangzhiaishang = new Equip(41, "˪֮����", R.drawable.shuangzhiaishang, 3150, "Ψһ��������ͨ��������Ŀ��40%��Զ��30%���ƶ��ٶȣ�����2.5��", new String[]{"Hp","AD"}, new String[]{"+70����ֵ","+8������","+3%����͵ȡ"}, shuangzhiaishang_attr, new int[]{3}, new int[]{});
		list.add(shuangzhiaishang);
		
		EquipAttribute heilongpibian_attr = new EquipAttribute();
		heilongpibian_attr.setAS(35);
		Equip heilongpibian = new Equip(42, "����Ƥ��", R.drawable.heilongpibian, 1240, "Ψһ�����������ͨ�������Զ�Ŀ����ɶ���20�㷨���˺�", new String[]{"AS"}, new String[]{"+35%�����ٶ�"}, heilongpibian_attr, new int[]{5,5}, new int[]{34});
		list.add(heilongpibian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "��Լ֮��", R.drawable.qiyuezhijian, 440, "Ψһ������������������͵з���Ӣ�۵�λʱ�������15�㷨���˺�", new String[]{"Hp","AD","LS"}, new String[]{"+70����ֵ","+8������","+3%����͵ȡ"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "��Լ֮��", R.drawable.qiyuezhijian, 440, "Ψһ������������������͵з���Ӣ�۵�λʱ�������15�㷨���˺�", new String[]{"Hp","AD","LS"}, new String[]{"+70����ֵ","+8������","+3%����͵ȡ"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "��Լ֮��", R.drawable.qiyuezhijian, 440, "Ψһ������������������͵з���Ӣ�۵�λʱ�������15�㷨���˺�", new String[]{"Hp","AD","LS"}, new String[]{"+70����ֵ","+8������","+3%����͵ȡ"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
//		
//		EquipAttribute qiyuezhijian_attr = new EquipAttribute();
//		qiyuezhijian_attr.setHp(70);
//		qiyuezhijian_attr.setAD(8);
//		qiyuezhijian_attr.setLS(3);
//		Equip qiyuezhijian = new Equip(9, "��Լ֮��", R.drawable.qiyuezhijian, 440, "Ψһ������������������͵з���Ӣ�۵�λʱ�������15�㷨���˺�", new String[]{"Hp","AD","LS"}, new String[]{"+70����ֵ","+8������","+3%����͵ȡ"}, qiyuezhijian_attr, new int[]{}, new int[]{});
//		list.add(qiyuezhijian);
		return list;
	}
}
