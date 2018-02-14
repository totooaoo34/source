package com.yuyi.ui;


import com.yuyi.neikumanhua.R;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;


public class HomeActivity extends TabActivity {
	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		
		tabHost = getTabHost();
		
		//初始化tabHost
		tabHost.setup();
		createTabSpec("Spec1","第一页",new Intent(HomeActivity.this,LoginActivity.class),R.drawable.icon_tab_favor);
		createTabSpec("Spec2","第二页",new Intent(HomeActivity.this,HoneItemActivity.class),R.drawable.icon_tab_recom);
		createTabSpec("Spec3","第三页",new Intent(HomeActivity.this,QueryActivity.class),R.drawable.icon_tab_search);
		createTabSpec("Spec4","第四页",new Intent(HomeActivity.this,SetActivity.class),R.drawable.icon_tab_more);
		tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.WHITE);
		initcheckSpec(1,Color.LTGRAY);
		tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.WHITE);
		tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.WHITE);
		
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				if("Spec1".equals(tabId)){
					tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.LTGRAY);
				}
				else{
					tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.WHITE);
				}
				if("Spec2".equals(tabId)){
					tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.LTGRAY);
				}
				else{
					tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.WHITE);
				}
				if("Spec3".equals(tabId)){
					tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.LTGRAY);
				}
				else{
					tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.WHITE);
				}
				if("Spec4".equals(tabId)){
					tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.LTGRAY);
				}
				else{
					tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.WHITE);
				}
			}
		});
		
	}
	
	
	//加载默认选中页面
	public void initcheckSpec(int index,int colorId){
		tabHost.setCurrentTab(index);
		View view = tabHost.getTabWidget().getChildAt(index);
		
		view.setBackgroundColor(colorId);
	}
	
	public void createTabSpec(String tagId,String tagName,Intent intent,int iconId){
		TabSpec spec = tabHost.newTabSpec(tagId);
		spec.setIndicator(null, getResources().getDrawable(iconId));
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
