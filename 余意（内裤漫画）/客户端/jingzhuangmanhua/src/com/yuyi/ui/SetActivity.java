package com.yuyi.ui;

import com.yuyi.neikumanhua.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SetActivity extends Activity {
	RelativeLayout layout_set;
	LinearLayout layout_user, layout_download, layout_setting, layout_feedback,
			layout_more_update;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_set);
		layout_set = (RelativeLayout) findViewById(R.id.layout_set);
		layout_set.setBackgroundColor(Color.GREEN);
		layout_user = (LinearLayout) findViewById(R.id.layout_user);
		layout_download = (LinearLayout) findViewById(R.id.layout_download);
		layout_setting = (LinearLayout) findViewById(R.id.layout_setting);
		layout_feedback = (LinearLayout) findViewById(R.id.layout_feedback);
		layout_more_update = (LinearLayout) findViewById(R.id.layout_more_update);

		layout_user.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					layout_user.setBackgroundResource(R.drawable.collect_drawable_false);
					if (event.getX() < 0 || event.getX() > 465) {
						layout_user.setBackgroundResource(R.drawable.collect_drawable_true);
							
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_user
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_MOVE:					
					if (event.getX() < 0 || event.getX() > 465) {
						layout_user
								.setBackgroundResource(R.drawable.collect_drawable_true);
						
						
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_user
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_UP:
					if(event.getY()>0&&event.getY()<52&event.getX()>0&&event.getX()<465){
					Intent intent = new Intent();
					intent.setClass(SetActivity.this, UserloginActivity.class);
					startActivity(intent);
					layout_user.setBackgroundResource(R.drawable.collect_drawable_true);
				}
					break;
					
				}
				return false;
			}
		});
		layout_user.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		layout_download.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					layout_download
							.setBackgroundResource(R.drawable.collect_drawable_false);
					if (event.getX() < 0 || event.getX() > 465) {
						layout_download
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_download
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_MOVE:
					if (event.getX() < 0 || event.getX() > 465) {
						layout_download
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_download
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_UP:
					if(event.getY()>0&&event.getY()<52&event.getX()>0&&event.getX()<465){
					Intent intent = new Intent();
					intent.setClass(SetActivity.this, DownloadmanageActivity.class);
					startActivity(intent);
					layout_download.setBackgroundResource(R.drawable.collect_drawable_true);
				}
					break;
					
				}
				return false;
			}
		});
		
		layout_download.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		layout_setting.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					layout_setting
							.setBackgroundResource(R.drawable.collect_drawable_false);
					if (event.getX() < 0 || event.getX() > 465) {
						layout_setting
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_setting
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_MOVE:
					if (event.getX() < 0 || event.getX() > 465) {
						layout_setting
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_setting
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_UP:
					if(event.getY()>0&&event.getY()<52&event.getX()>0&&event.getX()<465){
					Intent intent = new Intent();
					intent.setClass(SetActivity.this, SoftwareSetActivity.class);
					startActivity(intent);
					layout_setting.setBackgroundResource(R.drawable.collect_drawable_true);
				}
					break;
				}
				return false;
			}
		});
		layout_setting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		layout_download.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		layout_feedback.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					layout_feedback
							.setBackgroundResource(R.drawable.collect_drawable_false);
					if (event.getX() < 0 || event.getX() > 465) {
						layout_feedback
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_feedback
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_MOVE:
					if (event.getX() < 0 || event.getX() > 465) {
						layout_feedback
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_feedback
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_UP:
					if(event.getY()>0&&event.getY()<52&event.getX()>0&&event.getX()<465){
					Intent intent = new Intent();
					intent.setClass(SetActivity.this, FeedbackActivity.class);
					startActivity(intent);
					layout_feedback.setBackgroundResource(R.drawable.collect_drawable_true);
				}
					break;
				}
				return false;
			}
		});
		layout_feedback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
		layout_more_update.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					layout_more_update
							.setBackgroundResource(R.drawable.collect_drawable_false);
					if (event.getX() < 0 || event.getX() > 465) {
						layout_more_update
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_more_update
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_MOVE:
					if (event.getX() < 0 || event.getX() > 465) {
						layout_more_update
								.setBackgroundResource(R.drawable.collect_drawable_true);
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_more_update
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
//				case MotionEvent.ACTION_UP:
//					if(event.getY()>0&&event.getY()<52&event.getX()>0&&event.getX()<465){
//					Intent intent = new Intent();
//					intent.setClass(SetActivity.this, FeedbackActivity.class);
//					startActivity(intent);
//					layout_more_update.setBackgroundResource(R.drawable.collect_drawable_true);
//				}
//					break;
				}
				return false;
			}
		});
		layout_more_update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set, menu);
		return true;
	}

}
