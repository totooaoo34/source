package com.my.hero300.activity;

import java.util.List;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;
import com.my.hero300.adapter.SkillAdapter;
import com.my.hero300.bean.Hero;
import com.my.hero300.bean.Skill;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ListView;

public class SkillActivity extends Activity {

	Hero hero;
	List<Skill> list;
	ListView lv;
	GestureDetector gesture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skill);
		lv = (ListView) this.findViewById(R.id.lv_skill);
		
		Intent intent = getIntent();
		hero = (Hero) intent.getSerializableExtra("Hero");
		list = hero.getSkills();
		SkillAdapter adapter = new SkillAdapter(this, list);
		lv.setAdapter(adapter);
		
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
				//从右到左
				if(e1.getX() - e2.getX() > 120)
				{
					Intent intent = new Intent();
					intent.putExtra("Hero", hero);
					intent.setClass(SkillActivity.this, HeroGonglueActivity.class);
					startActivity(intent);
					
					overridePendingTransition(R.anim.right_in, R.anim.left_out);
				}
				//从左到右
				if(e2.getX() - e1.getX() > 120) 
				{
					Intent intent = new Intent();
					intent.putExtra("Hero", hero);
					intent.setClass(SkillActivity.this, HeroDesActivity.class);
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
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		gesture.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.skill, menu);
		return true;
	}

}
