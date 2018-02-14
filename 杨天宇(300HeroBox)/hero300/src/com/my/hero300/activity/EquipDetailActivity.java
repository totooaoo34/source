package com.my.hero300.activity;

import java.util.ArrayList;
import java.util.List;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;
import com.my.hero300.adapter.EquipAdapter;
import com.my.hero300.bean.Equip;
import com.my.hero300.view.MyGridView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class EquipDetailActivity extends Activity {

	Equip equip;
	ImageView iv_des_equip;
	TextView tv_des_equip_name;
	TextView tv_des_equip_price;
	TextView tv_des_equip_data1;
	TextView tv_des_equip_data2;
	TextView tv_des_equip_data3;
	TextView tv_des_equip_data4;
	TextView tv_des_equip_data5;
	TextView tv_des_equip_data6;
	TextView tv_des_equip_data7;
	TextView tv_des_equip_data8;
	TextView tv_des_equip_des;
	TextView tv_wupinshuoming;
	TextView tv_keyihecheng;
	TextView tv_hechengxuyao;
	List<Equip> listAll;
	List<Equip> listTo;
	List<Equip> listFrom;
	MyGridView gv_eto;
	MyGridView gv_efrom;
	
	ScrollView mScrollView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equip_detail);
		
		Intent intent = getIntent();
		equip = (Equip) intent.getSerializableExtra("Equip");
		
		iv_des_equip = (ImageView) this.findViewById(R.id.iv_des_equip);
		iv_des_equip.setImageResource(equip.getPicPath());
		
		tv_des_equip_name = (TextView) this.findViewById(R.id.tv_des_equip_name);
		tv_des_equip_name.setText(equip.getEquipName());
		tv_des_equip_price = (TextView) this.findViewById(R.id.tv_des_equip_price);
		tv_des_equip_price.setText(equip.getEquipPrice()+"");
		
		tv_des_equip_data1 = (TextView) this.findViewById(R.id.tv_des_equip_data1);
		tv_des_equip_data2 = (TextView) this.findViewById(R.id.tv_des_equip_data2);
		tv_des_equip_data3 = (TextView) this.findViewById(R.id.tv_des_equip_data3);
		tv_des_equip_data4 = (TextView) this.findViewById(R.id.tv_des_equip_data4);
		tv_des_equip_data5 = (TextView) this.findViewById(R.id.tv_des_equip_data5);
		tv_des_equip_data6 = (TextView) this.findViewById(R.id.tv_des_equip_data6);
		tv_des_equip_data7 = (TextView) this.findViewById(R.id.tv_des_equip_data7);
		tv_des_equip_data8 = (TextView) this.findViewById(R.id.tv_des_equip_data8);
		List<TextView> list = new ArrayList<TextView>();
		list.add(tv_des_equip_data1);
		list.add(tv_des_equip_data2);
		list.add(tv_des_equip_data3);
		list.add(tv_des_equip_data4);
		list.add(tv_des_equip_data5);
		list.add(tv_des_equip_data6);
		list.add(tv_des_equip_data7);
		list.add(tv_des_equip_data8);
		for (int i = list.size()-1; i >= 0; i--) {
			if(equip.getEquipData().length>=i+1){
				list.get(i).setText(equip.getEquipData()[i]);
			}else{
				list.get(i).setVisibility(View.GONE);
			}
		}
		tv_des_equip_des = (TextView) this.findViewById(R.id.tv_des_equip_des);
		tv_wupinshuoming = (TextView) this.findViewById(R.id.tv_wupinshuoming);
		if(equip.getEquipDes()!=null){
			tv_des_equip_des.setText(equip.getEquipDes());
		}else{
			tv_des_equip_des.setVisibility(View.GONE);
			tv_wupinshuoming.setVisibility(View.GONE);
		}
		
		
		//可以合成
		tv_keyihecheng = (TextView) this.findViewById(R.id.tv_keyihecheng);
		gv_eto = (MyGridView) this.findViewById(R.id.gv_equip_eto);
		
		if(equip.getEto().length!=0){
			listAll = AllEquipActivity.loadAllEquip();
			listTo = new ArrayList<Equip>();
			
			for (int i = listAll.size()-1; i >= 0 ; i--) {
				for (int j = 0; j < equip.getEto().length; j++) {
					if(listAll.get(i).getEid()==equip.getEto()[j]){
						listTo.add(listAll.get(i));
					}
				}
			}
			EquipAdapter adapter = new EquipAdapter(this, listTo);
			gv_eto.setAdapter(adapter);
		}else{
			tv_keyihecheng.setVisibility(View.GONE);
			gv_eto.setVisibility(View.GONE);
		}
		
		gv_eto.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("Equip", listTo.get(position));
				intent.setClass(EquipDetailActivity.this, EquipDetailActivity.class);
				startActivity(intent);
			}
		});
		
		
		//合成需要
		tv_hechengxuyao = (TextView) this.findViewById(R.id.tv_hechengxuyao);
		gv_efrom = (MyGridView) this.findViewById(R.id.gv_equip_efrom);
		if(equip.getEfrom().length!=0){
			listAll = AllEquipActivity.loadAllEquip();
			listFrom = new ArrayList<Equip>();
			for (int i = listAll.size()-1; i >= 0 ; i--) {
				for (int j = 0; j < equip.getEfrom().length; j++) {
					if(listAll.get(i).getEid()==equip.getEfrom()[j]){
						listFrom.add(listAll.get(i));
					}
				}
			}
			EquipAdapter adapter = new EquipAdapter(this, listFrom);
			gv_efrom.setAdapter(adapter);
		}else{
			tv_hechengxuyao.setVisibility(View.GONE);
			gv_efrom.setVisibility(View.GONE);
		}
		gv_efrom.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("Equip", listFrom.get(position));
				intent.setClass(EquipDetailActivity.this, EquipDetailActivity.class);
				startActivity(intent);
			}
		});
		
		mScrollView = (ScrollView) this.findViewById(R.id.scrollView_equip_detail);
		mScrollView.smoothScrollTo(0, 0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.equip_detail, menu);
		return true;
	}

}
