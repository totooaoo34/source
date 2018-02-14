package com.zw.my_recreatio.three_imagses;

import com.zw.my_recreation.R;
import com.zw.my_recreation.R.layout;
import com.zw.my_recreation.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Artlsts2_Activity extends Activity {

     //// 3D图片浏览的主界面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2_artlsts);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artlsts2_, menu);
		return true;
	}

}
