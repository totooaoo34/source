package com.android.tenementclient.activity;

import com.android.tenementclient.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * @author Administrator ½øÈëAPP¶¯»­
 *
 */
public class SplashActivity extends Activity implements OnGestureListener {

	GestureDetector mGestureDetector;

	ImageView iv_spalash, iv_spalash_top;
	Animation animation1, animation2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		mGestureDetector = new GestureDetector(this, this);

		iv_spalash = (ImageView) findViewById(R.id.iv_spalash);
		iv_spalash_top = (ImageView) findViewById(R.id.iv_spalash_top);

		animation1 = AnimationUtils.loadAnimation(SplashActivity.this,
				R.anim.left_in);
		animation2 = AnimationUtils.loadAnimation(SplashActivity.this,
				R.anim.splash_alpha);

		animation1.setDuration(1000);
		animation1.setFillAfter(true);
		iv_spalash.startAnimation(animation1);

		animation2.setDuration(3000);
		animation2.setFillAfter(true);
		iv_spalash_top.startAnimation(animation2);
		startAction();
	}

	private void startAction() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					sleep(3000);
					Intent intent = new Intent();
					intent.setClass(SplashActivity.this, TabHostActivity.class);
					SplashActivity.this.startActivity(intent);

					SplashActivity.this.overridePendingTransition(
							R.anim.splash_anim, R.anim.splash_anim);
					SplashActivity.this.finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		mGestureDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
//		if (e1.getX() - e2.getX() > 5) {
//			Intent intent = new Intent();
//			intent.setClass(this, TabHostActivity.class);
//			this.startActivity(intent);
//
//			this.overridePendingTransition(R.anim.splash_anim,
//					R.anim.splash_anim);
//			this.finish();
//		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
