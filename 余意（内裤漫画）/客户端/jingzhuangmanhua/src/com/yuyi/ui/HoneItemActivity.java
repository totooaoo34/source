package com.yuyi.ui;

import java.util.ArrayList;
import java.util.List;

import com.yuyi.fragment.HomeContentFragMent;
import com.yuyi.neikumanhua.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HoneItemActivity extends FragmentActivity{
	ViewPager viewPager;
	List<HomeContentFragMent> hcfList;
	HorizontalScrollView hsv;
	RadioGroup rg;
	RadioButton rb0, rb1, rb2, rb3;
	TextView line;
	RelativeLayout layout_jingcaituijian_1, layout_rementuijian_1,
			layout_yuanchuangguoman_1, layout_zuijingengxin_1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hone_item);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		hsv = (HorizontalScrollView) findViewById(R.id.horizontalScrollView_menu);
		layout_jingcaituijian_1 = (RelativeLayout) findViewById(R.id.layout_jingcaituijian_1);
		layout_rementuijian_1 = (RelativeLayout) findViewById(R.id.layout_rementuijian_1);
		layout_yuanchuangguoman_1 = (RelativeLayout) findViewById(R.id.layout_yuanchuangguoman_1);
		layout_zuijingengxin_1 = (RelativeLayout) findViewById(R.id.layout_zuijingengxin_1);
		
		line = (TextView) findViewById(R.id.line);
		rg = (RadioGroup) findViewById(R.id.rg);
		rb0 = (RadioButton) findViewById(R.id.rb0);
		rb1 = (RadioButton) findViewById(R.id.rb1);
		rb2 = (RadioButton) findViewById(R.id.rb2);
		rb3 = (RadioButton) findViewById(R.id.rb3);
		
		rb0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewPager.setCurrentItem(0);	
				layout_jingcaituijian_1.setBackgroundColor(getResources().getColor(R.color.yanse));
				layout_rementuijian_1.setBackgroundColor(Color.WHITE);
				layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
				layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
			}
		});
		rb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewPager.setCurrentItem(1);
				layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
				layout_rementuijian_1.setBackgroundColor(getResources().getColor(R.color.yanse));
				layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
				layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
			}
		});
		rb2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewPager.setCurrentItem(2);
				layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
				layout_rementuijian_1.setBackgroundColor(Color.WHITE);
				layout_yuanchuangguoman_1.setBackgroundColor(getResources().getColor(R.color.yanse));
				layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
			}
		});
		rb3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewPager.setCurrentItem(3);
				layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
				layout_rementuijian_1.setBackgroundColor(Color.WHITE);
				layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
				layout_zuijingengxin_1.setBackgroundColor(getResources().getColor(R.color.yanse));
			}
		});
		hcfList = new ArrayList<HomeContentFragMent>();
		for (int i = 0; i < 4; i++) {
			HomeContentFragMent hcf = new HomeContentFragMent();
			// �������
			Bundle bundle = new Bundle();
			bundle.putString("tag", i + "");
			hcf.setArguments(bundle);
			hcfList.add(hcf);
		}
		
		viewPager.setAdapter(new MyAdpter(getSupportFragmentManager()));
		viewPager.setCurrentItem(1);
		layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
		layout_rementuijian_1.setBackgroundColor(getResources().getColor(R.color.yanse));
		layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
		layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			// ����vaiewpager��fragmentʱ��ȡ�±�
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				if (position == 0) {
					layout_jingcaituijian_1.setBackgroundColor(getResources().getColor(R.color.yanse));
					layout_rementuijian_1.setBackgroundColor(Color.WHITE);
					layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
					layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
				}
				if (position == 1) {
					layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
					layout_rementuijian_1.setBackgroundColor(getResources().getColor(R.color.yanse));
					layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
					layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
				}
				if (position == 2) {
					layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
					layout_rementuijian_1.setBackgroundColor(Color.WHITE);
					layout_yuanchuangguoman_1.setBackgroundColor(getResources().getColor(R.color.yanse));
					layout_zuijingengxin_1.setBackgroundColor(Color.WHITE);
				}
				if (position == 3) {
					layout_jingcaituijian_1.setBackgroundColor(Color.WHITE);
					layout_rementuijian_1.setBackgroundColor(Color.WHITE);
					layout_yuanchuangguoman_1.setBackgroundColor(Color.WHITE);
					layout_zuijingengxin_1.setBackgroundColor(getResources().getColor(R.color.yanse));
				}
			}

			// ����ʱ��ķ��� �㷨
			@Override
			public void onPageScrolled(int arg0,// �ƶ��ĸ���
					float arg1, // ��ǰ�ƶ�ѡ�����ı���
					int arg2// ��ǰ�ƶ�����ֵ
			) {
				// TODO Auto-generated method stub
				int total = (int) ((arg0 + arg1) * rb0.getWidth());// ��ȡˮƽ��������ǰλ��
				int green = (viewPager.getWidth() - rb0.getWidth()) / 2;// ��ȡ���а�ť��x����
				int scroll = total - green;// ����ˮƽ������Ӧ�û����ľ���
				hsv.scrollTo(scroll, 0);// ����ˮƽ������
				onScrollViewChange(arg0, arg1);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	float fromX = 0;

	// HorizontalScrollView�����仯ʱ���㷨
	private void onScrollViewChange(int index, float f) {
		// ��ʼ��λ�ƶ�������ʼλ��ΪfromX,����λ��Ϊ��ѡ�а�ťx����һ��
		float location = rb0.getWidth() * ((float) index + f);
		TranslateAnimation animation = new TranslateAnimation(fromX, location,
				0, 0);
		// ���ö���ʱ��
		animation.setDuration(50);
		animation.setFillAfter(true);
		// �����ζ�������λ������Ϊ�´ζ�����ʼλ��
		fromX = location;
		// ��������
		line.startAnimation(animation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hone_item, menu);
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
			return hcfList.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return hcfList.size();
		}

	}



}
