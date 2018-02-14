package com.my.hero300.activity;

import java.util.List;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;
import com.my.hero300.adapter.HeroAdapter;
import com.my.hero300.adapter.Image3DAdapter;
import com.my.hero300.bean.Hero;
import com.my.hero300.view.GalleryView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class AllHero2Activity extends Activity {

	List<Hero> list;
	GalleryView gv;
	RadioButton rb;
	RadioGroup rg;
	
	Button btn_biaoge;
	TextView tv_hero2_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_hero2);
		list = AllHeroActivity.loadAllHero();
		init();
		
		rg = (RadioGroup) this.findViewById(R.id.rg_selectposition);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int rbId = group.getCheckedRadioButtonId();
				rb = (RadioButton) AllHero2Activity.this.findViewById(rbId);
				String position =  rb.getText().toString();
				select(position);
				init();
			}
		});
		
		btn_biaoge = (Button) this.findViewById(R.id.btn_biaoge);
		btn_biaoge.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(AllHero2Activity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
	
	//初始化加载英雄
	public void init(){
		
		/*
		 * 
		gallery = (GalleryView) findViewById(R.id.mygallery);

		adapter = new ImageAdapter(this); 	
		adapter.createReflectedImages();
		gallery.setAdapter(adapter);*/
		
		gv = (GalleryView) this.findViewById(R.id.mygallery);
		final Image3DAdapter adapter = new Image3DAdapter(this, list);
		adapter.createReflectedImages();
		gv.setAdapter(adapter);
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("Hero", list.get(position));
				intent.setClass(AllHero2Activity.this, HeroDetailActivity.class);
				startActivity(intent);
			}
		});
		
		tv_hero2_name = (TextView) this.findViewById(R.id.tv_hero2_name);
		gv.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				tv_hero2_name.setText(list.get(position).getHeroName());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_hero2, menu);
		return true;
	}

	
	//根据定位筛选英雄
	public List<Hero> select(String position){
		list = AllHeroActivity.loadAllHero();
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
}
