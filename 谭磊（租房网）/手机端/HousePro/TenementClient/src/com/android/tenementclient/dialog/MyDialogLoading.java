package com.android.tenementclient.dialog;

import com.android.tenementclient.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MyDialogLoading extends ProgressDialog {

	Context mContext;
	ImageView iv_page_loading_bar;

	Animation page_loading_bar;

	public MyDialogLoading(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_loading);

		iv_page_loading_bar = (ImageView) findViewById(R.id.iv_page_loading_bar);

		page_loading_bar = AnimationUtils.loadAnimation(mContext,
				R.anim.rotate_page_bar);
		page_loading_bar.setFillAfter(true);
		iv_page_loading_bar.startAnimation(page_loading_bar);
	}
}
