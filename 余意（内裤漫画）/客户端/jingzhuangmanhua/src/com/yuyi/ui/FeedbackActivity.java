package com.yuyi.ui;

import com.yuyi.neikumanhua.R;
import com.yuyi.neikumanhua.R.layout;
import com.yuyi.neikumanhua.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class FeedbackActivity extends Activity {
	LinearLayout layout_feedbackError01;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_feedback);
		layout_feedbackError01 = (LinearLayout) findViewById(R.id.layout_feedbackError01);
		layout_feedbackError01.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					layout_feedbackError01.setBackgroundResource(R.drawable.collect_drawable_false);
					if (event.getX() < 0 || event.getX() > 465) {
						layout_feedbackError01.setBackgroundResource(R.drawable.collect_drawable_true);
							
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_feedbackError01
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_MOVE:					
					if (event.getX() < 0 || event.getX() > 465) {
						layout_feedbackError01
								.setBackgroundResource(R.drawable.collect_drawable_true);
							
					} else if (event.getY() < 0 || event.getY() > 52) {
						layout_feedbackError01
								.setBackgroundResource(R.drawable.collect_drawable_true);
					}
					break;
				case MotionEvent.ACTION_UP:
					if(event.getY()>0&&event.getY()<52&event.getX()>0&&event.getX()<465){
					Intent intent = new Intent();
					intent.setClass(FeedbackActivity.this, InsertFeedBackActivity.class);
					startActivity(intent);
					layout_feedbackError01.setBackgroundResource(R.drawable.collect_drawable_true);
				}
					break;
					
				}
				return false;
			}
		});
		layout_feedbackError01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

}
