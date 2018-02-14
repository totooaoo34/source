package com.example.tt_love_baby_client;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class XinxiActivity extends Activity {
	TextView username;
	ImageView iv_xinxiback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_xinxi);
		Intent intent = getIntent();
		username=(TextView) findViewById(R.id.tv_xinxiname);
		username.setText(intent.getStringExtra("username"));
		iv_xinxiback=(ImageView) findViewById(R.id.iv_xinxi_back);
		iv_xinxiback.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xinxi, menu);
		return true;
	}

}
