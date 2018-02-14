package com.android.tenementclient.dialog;

import com.android.tenementclient.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MyDialogExit extends Dialog implements OnClickListener {

	Context mContext;
	Button btn_exit, btn_cancel;

	public MyDialogExit(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_exit);

		btn_exit = (Button) findViewById(R.id.btn_exit);
		btn_cancel = (Button) findViewById(R.id.btn_cancel);

		btn_exit.setOnClickListener(this);
		btn_cancel.setOnClickListener(this);

		// ÍË³ö
		btn_exit.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_exit.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				case MotionEvent.ACTION_UP:
					btn_exit.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_pressed);
					return false;
				case MotionEvent.ACTION_MOVE:
					btn_exit.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				}
				return false;
			}
		});

		// È¡Ïû
		btn_cancel.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_cancel
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				case MotionEvent.ACTION_UP:
					btn_cancel
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_pressed);
					return false;
				case MotionEvent.ACTION_MOVE:
					btn_cancel
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				}
				return false;
			}
		});

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btn_exit:
			Thread thread = new Thread() {
				public void run() {
					try {
						((Activity) mContext).overridePendingTransition(
								R.anim.splash_anim_exit,
								R.anim.splash_anim_exit);
						((Activity) mContext).finish();
						sleep(2000);
						// android.os.Process.killProcess(android.os.Process.myPid());
						System.exit(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			};
			thread.start();
			break;
		case R.id.btn_cancel:
			this.dismiss();
			break;
		}
	}

}
