package com.android.tenementclient.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.android.tenementclient.R;
import com.android.tenementclient.activity.FwxxActivity;

public class MyDialogReconnection extends Dialog implements OnClickListener {

	Context mContext;
	Button btn_rec_cancel, btn_rec_confirm;

	public MyDialogReconnection(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_reconnection);
		btn_rec_cancel = (Button) findViewById(R.id.btn_rec_cancel);
		btn_rec_confirm = (Button) findViewById(R.id.btn_rec_confirm);
		
		btn_rec_cancel.setOnClickListener(this);
		btn_rec_confirm.setOnClickListener(this);

		// 取消
		btn_rec_cancel.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_rec_cancel
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				case MotionEvent.ACTION_UP:
					btn_rec_cancel
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_pressed);
					return false;
				case MotionEvent.ACTION_MOVE:
					btn_rec_cancel
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				}
				return false;
			}
		});

		// 确定
		btn_rec_confirm.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_rec_confirm
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				case MotionEvent.ACTION_UP:
					btn_rec_confirm
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_pressed);
					return false;
				case MotionEvent.ACTION_MOVE:
					btn_rec_confirm
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				}
				return false;
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_rec_cancel:
			this.dismiss();
			break;

		case R.id.btn_rec_confirm:
			this.dismiss();
			((FwxxActivity) mContext).sendFwxxMessage();
			break;
		}
	}

}
