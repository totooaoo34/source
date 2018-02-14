package com.example.tt_love_baby_client;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class KechengbiaoActivity extends Activity {
	ImageView iv_ruyuan_back,iv_addmsg;
	TextView iv_ruyuan_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kechengbiao);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View v = LayoutInflater.from(this).inflate(
				R.layout.jiazhang_actionbar_layout, null);
		iv_ruyuan_back=(ImageView) v.findViewById(R.id.iv_jiazhang_back);
		iv_ruyuan_title=(TextView) v.findViewById(R.id.tv_banji);
		iv_addmsg=(ImageView) v.findViewById(R.id.iv_jiazhang_addmsg);
		iv_addmsg.setVisibility(TRIM_MEMORY_BACKGROUND);
		iv_ruyuan_title.setText("�γ̱�");
		iv_ruyuan_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		LayoutParams arg1 = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		actionBar.setCustomView(v, arg1);
		
		ImageView kechengbiao=(ImageView) findViewById(R.id.iv_image_kechengbiao);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.kechengbiao, menu);
		return true;
	}

}
