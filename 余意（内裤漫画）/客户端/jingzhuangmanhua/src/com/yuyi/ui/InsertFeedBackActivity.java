package com.yuyi.ui;

import com.yuyi.neikumanhua.R;
import com.yuyi.neikumanhua.R.layout;
import com.yuyi.neikumanhua.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class InsertFeedBackActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_insert_feed_back);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_feed_back, menu);
		return true;
	}

}
