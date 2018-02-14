package com.android.tenementclient.activity;

import com.android.tenementclient.R;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * @author Administrator 主页-百科-我的-更多
 * 
 */
@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity implements OnClickListener {

	public static String TAB_TAG_HOME = "home";
	public static String TAB_TAG_BAIKE = "baike";
	public static String TAB_TAG_MY = "my";
	public static String TAB_TAG_MORE = "more";

	public static TabHost tabhost;

	ImageView mHome, mBaike, mMy, mMore;
	TextView mHomeTxt, mBaikeTxt, mMyTxt, mMoreTxt;
	LinearLayout ll_tab_01, ll_tab_02, ll_tab_03, ll_tab_04;

	Intent mHomeIntent, mBaikeIntent, mMyIntent, mMoreIntent;

	int mCurId = R.id.ll_tab_01;

	private Animation left_in, left_out;
	private Animation right_in, right_out;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabhost);
		prepareAnim();
		inntView();
		inntIntent();
		setTabIntent();
	}

	private void prepareAnim() {
		left_in = AnimationUtils.loadAnimation(this, R.anim.left_in);
		left_out = AnimationUtils.loadAnimation(this, R.anim.left_out);
		right_in = AnimationUtils.loadAnimation(this, R.anim.right_in);
		right_out = AnimationUtils.loadAnimation(this, R.anim.right_out);
	}

	private void inntView() {
		ll_tab_01 = (LinearLayout) findViewById(R.id.ll_tab_01);
		ll_tab_02 = (LinearLayout) findViewById(R.id.ll_tab_02);
		ll_tab_03 = (LinearLayout) findViewById(R.id.ll_tab_03);
		ll_tab_04 = (LinearLayout) findViewById(R.id.ll_tab_04);

		mHome = (ImageView) findViewById(R.id.iv_01);
		mBaike = (ImageView) findViewById(R.id.iv_02);
		mMy = (ImageView) findViewById(R.id.iv_03);
		mMore = (ImageView) findViewById(R.id.iv_04);

		mHomeTxt = (TextView) findViewById(R.id.tv_01);
		mBaikeTxt = (TextView) findViewById(R.id.tv_02);
		mMyTxt = (TextView) findViewById(R.id.tv_03);
		mMoreTxt = (TextView) findViewById(R.id.tv_04);

		// 绑定点击监听事件
		ll_tab_01.setOnClickListener((OnClickListener) this);
		ll_tab_02.setOnClickListener((OnClickListener) this);
		ll_tab_03.setOnClickListener((OnClickListener) this);
		ll_tab_04.setOnClickListener((OnClickListener) this);
		mHome.setImageResource(R.drawable.tab_home_select);

		mHomeTxt.setTextColor(Color.parseColor("#e76e6e"));
		mBaikeTxt.setTextColor(Color.parseColor("#888888"));
		mMyTxt.setTextColor(Color.parseColor("#888888"));
		mMoreTxt.setTextColor(Color.parseColor("#888888"));
	}

	// 创建Intent
	private void inntIntent() {
		mHomeIntent = new Intent(this, HomeActivity.class);
		mBaikeIntent = new Intent(this, BaikeActivity.class);
		mMyIntent = new Intent(this, MyActivity.class);
		mMoreIntent = new Intent(this, MoreActivity.class);
	}

	// 添加tab
	private void setTabIntent() {
		tabhost = getTabHost();
		tabhost.addTab(createTabSpec(TAB_TAG_HOME, R.string.home_01,
				R.drawable.tab_home_normal, mHomeIntent));
		tabhost.addTab(createTabSpec(TAB_TAG_BAIKE, R.string.home_02,
				R.drawable.tab_baike_normal, mBaikeIntent));
		tabhost.addTab(createTabSpec(TAB_TAG_MY, R.string.home_03,
				R.drawable.tab_house_normal, mMyIntent));
		tabhost.addTab(createTabSpec(TAB_TAG_MORE, R.string.home_04,
				R.drawable.tab_more_normal, mMoreIntent));
	}

	// 创建方法
	private TabHost.TabSpec createTabSpec(String tag, int lable, int img,
			final Intent content) {
		return tabhost
				.newTabSpec(tag)
				.setIndicator(getString(lable), getResources().getDrawable(img))// 图片
				.setContent(content);// 意图
	}

	public static void setCurrentTabByTag(String tab) {
		tabhost.setCurrentTabByTag(tab);
	}

	// 点击事件
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method
		if (mCurId == v.getId())
			return;
		mHome.setImageResource(R.drawable.tab_home_normal);
		mBaike.setImageResource(R.drawable.tab_baike_normal);
		mMy.setImageResource(R.drawable.tab_house_normal);
		mMore.setImageResource(R.drawable.tab_more_normal);
		int clickId = v.getId();
		final boolean flag;
		if (mCurId < clickId)
			flag = true;
		else
			flag = false;

		if (flag)
			tabhost.getCurrentView().startAnimation(left_out);
		else
			tabhost.getCurrentView().startAnimation(right_out);
		switch (clickId) {
		case R.id.ll_tab_01:
			tabhost.setCurrentTabByTag(TAB_TAG_HOME);
			mHome.setImageResource(R.drawable.tab_home_select);
			mHomeTxt.setTextColor(Color.parseColor("#e76e6e"));
			mBaikeTxt.setTextColor(Color.parseColor("#888888"));
			mMyTxt.setTextColor(Color.parseColor("#888888"));
			mMoreTxt.setTextColor(Color.parseColor("#888888"));
			break;
		case R.id.ll_tab_02:
			tabhost.setCurrentTabByTag(TAB_TAG_BAIKE);
			mBaike.setImageResource(R.drawable.tab_baike_select);
			mBaikeTxt.setTextColor(Color.parseColor("#e76e6e"));
			mHomeTxt.setTextColor(Color.parseColor("#888888"));
			mMyTxt.setTextColor(Color.parseColor("#888888"));
			mMoreTxt.setTextColor(Color.parseColor("#888888"));
			break;
		case R.id.ll_tab_03:
			tabhost.setCurrentTabByTag(TAB_TAG_MY);
			mMy.setImageResource(R.drawable.tab_house_select);
			mMyTxt.setTextColor(Color.parseColor("#e76e6e"));
			mHomeTxt.setTextColor(Color.parseColor("#888888"));
			mBaikeTxt.setTextColor(Color.parseColor("#888888"));
			mMoreTxt.setTextColor(Color.parseColor("#888888"));
			break;
		case R.id.ll_tab_04:
			tabhost.setCurrentTabByTag(TAB_TAG_MORE);
			mMore.setImageResource(R.drawable.tab_more_select);
			mMoreTxt.setTextColor(Color.parseColor("#e76e6e"));
			mHomeTxt.setTextColor(Color.parseColor("#888888"));
			mBaikeTxt.setTextColor(Color.parseColor("#888888"));
			mMyTxt.setTextColor(Color.parseColor("#888888"));
			break;
		}
		if (flag)
			tabhost.getCurrentView().startAnimation(left_in);
		else
			tabhost.getCurrentView().startAnimation(right_in);
		mCurId = clickId;
	}

}
