package com.my.hero300.activity;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		//创建一个等待线程
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				//休眠1秒
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//启动主窗体
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(intent);
				//关闭欢迎窗体
				SplashActivity.this.finish();
				
			}
		});
		//启动线程
		thread.start();
	}
	
//GestureDetector gd;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_splash);
//		gd = new GestureDetector(this, new OnGestureListener() {
//			
//			@Override
//			public boolean onSingleTapUp(MotionEvent e) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//			
//			@Override
//			public void onShowPress(MotionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
//					float distanceY) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//			
//			@Override
//			public void onLongPress(MotionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
//					float velocityY) {
//				// TODO Auto-generated method stub
//				
//				Intent intent = new Intent();
//				intent.setClass(SplashActivity.this, MainActivity.class);
//				startActivity(intent);
//				return false;
//			}
//			
//			@Override
//			public boolean onDown(MotionEvent e) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		});
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.splash, menu);
//		return true;
//	}
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		// TODO Auto-generated method stub
//		gd.onTouchEvent(event);
//		return super.onTouchEvent(event);
//		
//	}

}
