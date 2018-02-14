package com.my.hero300.activity;

import java.util.List;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;
import com.my.hero300.adapter.GonglueAdapter;
import com.my.hero300.bean.Hero;
import com.my.hero300.bean.HeroGonglue;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class HeroGonglueActivity extends Activity {

	ListView lv;
	Hero hero;
	List<HeroGonglue> list;
	TextView tv_gonglue_null1;
	TextView tv_gonglue_null2;
	GestureDetector gesture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero_gonglue);
		
		Intent intent = getIntent();
		hero = (Hero) intent.getSerializableExtra("Hero");
		list = hero.getHeroGonglues();
		if(list!=null){
			initView();
		}else{
			lv = (ListView) this.findViewById(R.id.lv_gonglue);
			lv.setVisibility(View.GONE);
		}
		
		gesture = new GestureDetector(this, new GestureDetector.OnGestureListener() {
		
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY) {
				// TODO Auto-generated method stub
				//从左到右
				if(e2.getX() - e1.getX() > 120) 
				{
					Intent intent = new Intent();
					intent.putExtra("Hero", hero);
					intent.setClass(HeroGonglueActivity.this, SkillActivity.class);
					startActivity(intent);
					
					overridePendingTransition(R.anim.left_in,R.anim.right_out);
			
				}
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}
	
	//初始化空间
	public void initView(){
		tv_gonglue_null1 = (TextView) this.findViewById(R.id.tv_gonglue_null1);
		tv_gonglue_null2 = (TextView) this.findViewById(R.id.tv_gonglue_null2);
		tv_gonglue_null1.setVisibility(View.GONE);
		tv_gonglue_null2.setVisibility(View.GONE);
		lv = (ListView) this.findViewById(R.id.lv_gonglue);
		GonglueAdapter adapter = new GonglueAdapter(this, list);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent1 = new Intent();
				intent1.putExtra("webPath", list.get(position).getWebPath());
				intent1.setClass(HeroGonglueActivity.this, HeroGonglueDesActivity.class);
				startActivity(intent1);
			}
		});
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		gesture.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hero_gonglue, menu);
		return true;
	}

}
