package com.my.hero300.activity;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;
import com.my.hero300.bean.Hero;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroDesActivity extends Activity {

	Hero hero;
	TextView tv_des_name;
	TextView tv_des_position;
	TextView tv_des_des;
	ImageView iv_des_hero;
	
	TextView tv_des_shengming;
	TextView tv_des_gongji;
	TextView tv_des_fashu;
	TextView tv_des_tuandui;
	TextView tv_des_caozuo;
	ImageView iv_des_shengming;
	ImageView iv_des_gongji;
	ImageView iv_des_fashu;
	ImageView iv_des_tuandui;
	ImageView iv_des_caozuo;
	
	GestureDetector gesture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero_des);
		
		Intent intent = getIntent();
		hero = (Hero) intent.getSerializableExtra("Hero");
		tv_des_name = (TextView) this.findViewById(R.id.tv_des_name);
		tv_des_position = (TextView) this.findViewById(R.id.tv_des_position);
		tv_des_des = (TextView) this.findViewById(R.id.tv_des_des);
		iv_des_hero = (ImageView) this.findViewById(R.id.iv_des_hero);
		
		tv_des_shengming = (TextView) this.findViewById(R.id.tv_des_shengming);
		tv_des_gongji = (TextView) this.findViewById(R.id.tv_des_gongji);
		tv_des_fashu = (TextView) this.findViewById(R.id.tv_des_fashu);
		tv_des_tuandui = (TextView) this.findViewById(R.id.tv_des_tuandui);
		tv_des_caozuo = (TextView) this.findViewById(R.id.tv_des_caozuo);
		
		iv_des_shengming = (ImageView) this.findViewById(R.id.iv_des_shengming);
		iv_des_gongji = (ImageView) this.findViewById(R.id.iv_des_gongji);
		iv_des_fashu = (ImageView) this.findViewById(R.id.iv_des_fashu);
		iv_des_tuandui = (ImageView) this.findViewById(R.id.iv_des_tuandui);
		iv_des_caozuo = (ImageView) this.findViewById(R.id.iv_des_caozuo);
		
		tv_des_name.setText(hero.getHeroName());
		tv_des_position.setText(hero.getHeroPosition());
		tv_des_des.setText(hero.getHeroDes());
		iv_des_hero.setImageResource(hero.getPicPath());
		
		tv_des_shengming.setText(hero.getHeroSimpleAttr().getShengming()+"");
		tv_des_gongji.setText(hero.getHeroSimpleAttr().getGongji()+"");
		tv_des_fashu.setText(hero.getHeroSimpleAttr().getFashu()+"");
		tv_des_tuandui.setText(hero.getHeroSimpleAttr().getTuandui()+"");
		tv_des_caozuo.setText(hero.getHeroSimpleAttr().getCaozuo()+"");
		
		LayoutParams lp_shengming = (LayoutParams) iv_des_shengming.getLayoutParams();
		lp_shengming.width = hero.getHeroSimpleAttr().getShengming()*15;
		iv_des_shengming.setLayoutParams(lp_shengming);
		
		LayoutParams lp_gongji = (LayoutParams) iv_des_gongji.getLayoutParams();
		lp_gongji.width = hero.getHeroSimpleAttr().getGongji()*15;
		iv_des_gongji.setLayoutParams(lp_gongji);
		
		LayoutParams lp_fashu = (LayoutParams) iv_des_fashu.getLayoutParams();
		lp_fashu.width = hero.getHeroSimpleAttr().getFashu()*15;
		iv_des_fashu.setLayoutParams(lp_fashu);
		
		LayoutParams lp_tuandui = (LayoutParams) iv_des_tuandui.getLayoutParams();
		lp_tuandui.width = hero.getHeroSimpleAttr().getTuandui()*15;
		iv_des_tuandui.setLayoutParams(lp_tuandui);
		
		LayoutParams lp_caozuo = (LayoutParams) iv_des_caozuo.getLayoutParams();
		lp_caozuo.width = hero.getHeroSimpleAttr().getCaozuo()*15;
		iv_des_caozuo.setLayoutParams(lp_caozuo);
		
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
				//´ÓÓÒµ½×ó
				if(e1.getX() - e2.getX() > 120)
				{
					Intent intent = new Intent();
					intent.putExtra("Hero", hero);
					intent.setClass(HeroDesActivity.this, SkillActivity.class);
					startActivity(intent);
					
					overridePendingTransition(R.anim.right_in, R.anim.left_out);
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
		getMenuInflater().inflate(R.menu.hero_des, menu);
		return true;
	}

}
