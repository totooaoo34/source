package com.my.hero300.activity;

import java.util.ArrayList;
import java.util.List;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;
import com.my.hero300.bean.Hero;
import com.my.hero300.bean.HeroAttribute;
import com.my.hero300.bean.Skill;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class HeroDetailActivity extends TabActivity {

	TabHost th_detail;
	Hero hero;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero_detail);
		
		th_detail = (TabHost) this.findViewById(android.R.id.tabhost);
		hero = (Hero)this.getIntent().getSerializableExtra("Hero");
		TabSpec ts1 = th_detail.newTabSpec("1");
		ts1.setIndicator("Ó¢ÐÛ¼ò½é");
		Intent intent1 = new Intent();
		intent1.putExtra("Hero", hero);
		intent1.setClass(HeroDetailActivity.this, HeroDesActivity.class);
		ts1.setContent(intent1);
		th_detail.addTab(ts1);
		
		TabSpec ts2 = th_detail.newTabSpec("2");
		ts2.setIndicator("¼¼ÄÜÏêÏ¸");
		Intent intent2 = new Intent();
		intent2.putExtra("Hero", hero);
		intent2.setClass(HeroDetailActivity.this, SkillActivity.class);
		ts2.setContent(intent2);
		th_detail.addTab(ts2);
		TabSpec ts3 = th_detail.newTabSpec("3");
		ts3.setIndicator("¹¥ÂÔ/ÊÓÆµ");
		Intent intent3 = new Intent();
		intent3.putExtra("Hero", hero);
		intent3.setClass(HeroDetailActivity.this, HeroGonglueActivity.class);
		ts3.setContent(intent3);
		th_detail.addTab(ts3);
		
//		TabSpec ts4 = th_detail.newTabSpec("4");
//		ts4.setIndicator("Ó¢ÐÛÄ£Äâ");
//		Intent intent4 = new Intent();
//		intent4.putExtra("Hero", hero);
//		intent4.setClass(HeroDetailActivity.this, HeroGonglueActivity.class);
//		ts4.setContent(intent4);
//		th_detail.addTab(ts4);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hero_detail, menu);
		return true;
	}
	
}
