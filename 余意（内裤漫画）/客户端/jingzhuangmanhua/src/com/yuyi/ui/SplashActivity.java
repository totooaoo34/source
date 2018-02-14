package com.yuyi.ui;

import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
		skipActivity();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}
	
	public void skipActivity(){
		//将此次子线程操作放在队列中
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, HomeActivity.class);				
				startActivity(intent);
				overridePendingTransition(R.anim.right_in,//进入时的动画
						R.anim.left_out);//出去时的动画
				finish();
			}
		}, 2*1000);
	}

}
