package com.zw.my_recreation;


import httpUrl.Grallery3DDActivity;
import add.R.color;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	ActionBar ab;
	TabHost tabhost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ab=getActionBar();
		//ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		setContentView(R.layout.activity_main);
		
		tabhost=getTabHost();
//		
//		ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.top));
		//ab.setIcon(resId)
		
	  
		cont("1", "艺讯 News", new Intent(this,News_Activity.class));
		cont("2", "艺视 Video",new Intent(this,Video_Activity.class));
		cont("3", "艺展 Exhbition",new Intent(this,Exhbition_Activity.class));
		cont("4", "艺术+ Artists", new Intent(this,Grallery3DDActivity.class));
	    cont("5", "艺历 Calendar", new Intent(this,Calendar_Activity.class));
	}
	
	

	public void cont(String tag,String telier,Intent intent){
		TabSpec tabSpec=tabhost.newTabSpec(tag);
		tabSpec.setIndicator(telier);
		tabSpec.setContent(intent);
		tabhost.addTab(tabSpec);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(1, 1, 1, "收藏");
		return true;
	}

	 @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 switch (item.getItemId()) {
		case 1:
			Toast.makeText(MainActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	  
}
