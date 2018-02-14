package com.zw.my_recreation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Tow_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tow_);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tow_, menu);
		return true;
	}

}
