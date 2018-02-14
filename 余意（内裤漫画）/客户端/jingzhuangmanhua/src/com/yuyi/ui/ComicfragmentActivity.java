package com.yuyi.ui;

import java.util.ArrayList;
import java.util.List;

import com.yuyi.contants.Contants;
import com.yuyi.fragment.LookComicFragment;
import com.yuyi.neikumanhua.R;
import com.yuyi.neikumanhua.R.id;
import com.yuyi.neikumanhua.R.layout;
import com.yuyi.neikumanhua.R.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.Window;

public class ComicfragmentActivity extends FragmentActivity {
	
	ViewPager viewpager;
	List<LookComicFragment> llist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_comicfragment);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		llist = new ArrayList<LookComicFragment>();
		for(int i = 0;i<=Contants.comicUrlList.size()+1;i++){
			LookComicFragment lcf = new LookComicFragment();
			//传入参数
			Bundle bundle = new Bundle();
			bundle.putString("tag", i+"");
			lcf.setArguments(bundle);
			llist.add(lcf); 
		}
		viewpager.setAdapter(new MyAdpter(getSupportFragmentManager()));
		viewpager.setCurrentItem(Contants.comicPage+1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comicfragment, menu);
		return true;
	}
	
	class MyAdpter extends FragmentPagerAdapter{
		
		
		public MyAdpter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int location) {
			// TODO Auto-generated method stub
			return llist.get(location);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return llist.size();
		}
		
	}
}
