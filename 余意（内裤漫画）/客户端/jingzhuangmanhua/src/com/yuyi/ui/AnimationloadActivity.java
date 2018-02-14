package com.yuyi.ui;

import com.ab.view.progress.AbCircleProgressBar;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;
import com.yuyi.neikumanhua.R.id;
import com.yuyi.neikumanhua.R.layout;
import com.yuyi.neikumanhua.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AnimationloadActivity extends Activity {

	ImageView iv_animation;
	//ProgressBar progressBar;
	
	AbCircleProgressBar mAbProgressBar;
	private int max = 100;
	private int progress = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_animationload);
		mAbProgressBar = (AbCircleProgressBar) findViewById(R.id.circleProgressBar);
		mAbProgressBar.setMax(8);
		
		iv_animation = (ImageView) findViewById(R.id.iv_animation);
		//progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		//progressBar.setMax(8);
		
		AnimationDrawable ad  = (AnimationDrawable) iv_animation.getBackground();
		ad.start();	
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				for(int i = 0;i<8;i++){
					count++;
					try {
						Thread.sleep(350);
						Message msg = new Message();
						msg.arg1 = count;
						msg.what = 1;
						handler.sendMessage(msg);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				mAbProgressBar.setProgress(msg.arg1);
				if(msg.arg1==8){
					Intent intent = new Intent();
					intent.setClass(AnimationloadActivity.this, ComicfragmentActivity.class);
					startActivity(intent);
					finish();
				}
				break;
			}
		};
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animationload, menu);
		return true;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		
	}

}
