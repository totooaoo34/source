package com.android.tenementclient.activity;

import java.util.ArrayList;
import java.util.List;

import com.android.tenementclient.R;
import com.android.tenementclient.fragment.InTradeFragment;
import com.android.tenementclient.fragment.ProblemFragment;
import com.android.tenementclient.fragment.TopLineFragment;
import com.viewpagerindicator.TabPageIndicator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

/**
 * @author Administrator 百科
 * 
 */
public class BaikeActivity extends FragmentActivity {

	private static final String[] CONTENT = new String[] { "头条", "导购", "问答" };

	private List<Fragment> fragments = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_baike);

		fragments.add(new TopLineFragment());// 头条
		fragments.add(new InTradeFragment());// 导购
		fragments.add(new ProblemFragment());// 问答

		FragmentPagerAdapter adapter = new BaikeAdapter(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.vp_baike_page);
		pager.setAdapter(adapter);
		// 关联
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.tpi_top_line);
		indicator.setViewPager(pager);
	}

	class BaikeAdapter extends FragmentPagerAdapter {

		public BaikeAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return fragments.get(arg0);
		}

		@SuppressLint("DefaultLocale")
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return CONTENT[position % CONTENT.length].toUpperCase();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, TabHostActivity.class);
		// this.overridePendingTransition(R.anim.left_in, R.anim.left_out);
		startActivity(intent);
		this.finish();
	}

}
