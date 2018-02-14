package com.zw.my_recreation;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {

	//// 进入程序之前的闪屏的界面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread thread=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					/// 设置闪屏的时间
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent intent=new Intent();
				intent.setClass(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		};
		thread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
