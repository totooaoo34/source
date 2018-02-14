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
		//���˴����̲߳������ڶ�����
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, HomeActivity.class);				
				startActivity(intent);
				overridePendingTransition(R.anim.right_in,//����ʱ�Ķ���
						R.anim.left_out);//��ȥʱ�Ķ���
				finish();
			}
		}, 2*1000);
	}

}
