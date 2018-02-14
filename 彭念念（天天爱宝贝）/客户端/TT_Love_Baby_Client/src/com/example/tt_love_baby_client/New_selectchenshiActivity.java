package com.example.tt_love_baby_client;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.Window;

public class New_selectchenshiActivity extends Activity {
	ViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_new_selectchenshi);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_selectchenshi, menu);
		return true;
	}

}
