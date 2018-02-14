package com.my.hero300.activity;

import java.util.ArrayList;
import java.util.List;

import com.my.hero300.R;
import com.my.hero300.bean.Hero;
import com.my.hero300.bean.HeroAttribute;
import com.my.hero300.bean.Skill;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	
	TabHost th;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		th = (TabHost) this.findViewById(android.R.id.tabhost);
		
		TabSpec ts1 = th.newTabSpec("1");
		ts1.setIndicator("英雄资料");
		ts1.setContent(new Intent(this,AllHeroActivity.class));
		th.addTab(ts1);
		TabSpec ts2 = th.newTabSpec("2");
		ts2.setIndicator("装备资料");
		ts2.setContent(new Intent(this,AllEquipActivity.class));
		th.addTab(ts2);
		TabSpec ts3 = th.newTabSpec("3");
		ts3.setIndicator("战绩查询");
		ts3.setContent(new Intent(this,QueryGameActivity.class));
		th.addTab(ts3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
}
