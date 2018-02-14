package com.yuyi.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yuyi.fragment.LoginContentFragMent;
import com.yuyi.neikumanhua.R;

public class LoginActivity extends FragmentActivity {
	ViewPager viewpager;
	List<LoginContentFragMent> loginList;
	RadioGroup rg_login;
	RadioButton rb_shoucang,rb_lishi;
	RelativeLayout layout_shoucang,layout_lishi;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		viewpager = (ViewPager) findViewById(R.id.LoginViewpager);
		layout_shoucang = (RelativeLayout) findViewById(R.id.layout_shoucang);
		layout_lishi = (RelativeLayout) findViewById(R.id.layout_lishi);
		loginList = new ArrayList<LoginContentFragMent>();
		rg_login = (RadioGroup) findViewById(R.id.rg_login);
		rb_shoucang = (RadioButton) findViewById(R.id.rb_shoucang);
		rb_lishi = (RadioButton) findViewById(R.id.rb_lishi);
		layout_shoucang.setBackgroundColor(getResources().getColor(R.color.yanse));
		layout_lishi.setBackgroundColor(Color.WHITE);
		rb_shoucang.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewpager.setCurrentItem(0);
				layout_shoucang.setBackgroundColor(getResources().getColor(R.color.yanse));
				layout_lishi.setBackgroundColor(Color.WHITE);
			}
		});
		rb_lishi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewpager.setCurrentItem(1);
				layout_shoucang.setBackgroundColor(Color.WHITE);
				layout_lishi.setBackgroundColor(getResources().getColor(R.color.yanse));
			}
		});
		for (int i = 0; i < 2; i++) {
			LoginContentFragMent lcf = new LoginContentFragMent();
			// 传入参数
			Bundle bundle = new Bundle();
			bundle.putString("tag", i + "");
			lcf.setArguments(bundle);
			loginList.add(lcf);
		}
		
		viewpager.setAdapter(new MyAdpter(getSupportFragmentManager()));
		viewpager.setCurrentItem(0);
		
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
				if(arg0==0){
					rb_shoucang.setBackgroundColor(getResources().getColor(R.color.yanse));
					rb_lishi.setBackgroundColor(Color.WHITE);
				}
				if(arg0==1){
					rb_shoucang.setBackgroundColor(Color.WHITE);
					rb_lishi.setBackgroundColor(getResources().getColor(R.color.yanse));
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	class MyAdpter extends FragmentPagerAdapter {

		public MyAdpter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return loginList.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return loginList.size();
		}

	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		Toast.makeText(LoginActivity.this, sp.getString("sessionid", "..")+"退出程序", 0).show();
		Editor edit = sp.edit();
		edit.clear();
		edit.commit();
		edit.apply();
		
		
		return super.onKeyDown(keyCode, event);
		//Toast.makeText(LoginActivity.this, "退出程序", 0).show();
		
	}

}
