package com.yuyi.ui;

import java.util.ArrayList;
import java.util.List;

import com.ab.view.progress.AbHorizontalProgressBar;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageRequest;
import com.yuyi.adapter.LookItemAdapter;
import com.yuyi.application.MyApplication;
import com.yuyi.bean.ComicBeanParcelable;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KanmanhuaActivity extends Activity {
	MyApplication myappliction;
	RequestQueue queue;
	String imaTiltlUrl;
	GridView myGridView;
	ImageView iv_title;
	TextView tv_jssTitle;
	TextView tv_author;
	TextView tv_comat;
	TextView tv_source;
	TextView tv_juqingjieshao;
	TextView iv_updateTime;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_kanmanhua);
		myappliction = new MyApplication();
		queue = myappliction.getMyappliction().getQueue();
		myGridView = (GridView) findViewById(R.id.myGridView);
		
		iv_title = (ImageView) findViewById(R.id.iv_title);
		tv_jssTitle = (TextView) findViewById(R.id.tv_jssTitle);
				
		tv_author = (TextView) findViewById(R.id.tv_author);
		tv_comat = (TextView) findViewById(R.id.tv_comat);
		tv_source = (TextView) findViewById(R.id.tv_source);
		tv_juqingjieshao = (TextView) findViewById(R.id.tv_juqingjieshao);
		iv_updateTime = (TextView) findViewById(R.id.iv_updateTime);
		
		
		
		Intent intent = getIntent();
		ComicBeanParcelable parcelable = intent.getParcelableExtra("parcelable");
		
		imaTiltlUrl = parcelable.comicIma05Url;
		
		imaRequest();
		if("完结".equals(parcelable.comicUpdateTime)){
			tv_jssTitle.setText(parcelable.comicName+"(完)");
		}
		else{
			tv_jssTitle.setText(parcelable.comicName);
		}
		tv_author.setText("作    者："+parcelable.comicAuthor);
		tv_comat.setText( "战斗力："+parcelable.comicComat);
		tv_source.setText("来    源："+parcelable.comicSource);
		tv_juqingjieshao.setText(parcelable.comicJqJiesao);
		iv_updateTime.setText("更新状态："+parcelable.comicUpdateTime);
		
		myGridView.setAdapter(new LookItemAdapter(KanmanhuaActivity.this,Contants.comicUrlList.size()));
		myGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		//((ViewGroup)myGridView).setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
		myGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				Contants.comicPage = position;
				Intent intent = new Intent();
				intent.setClass(KanmanhuaActivity.this, AnimationloadActivity.class);
				startActivity(intent);
				
			}
		});
		
	}
	public void imaRequest(){
		ImageRequest imageRequest = new ImageRequest(imaTiltlUrl, new Listener<Bitmap>() {
			
			@Override
			public void onResponse(Bitmap response) {
				// TODO Auto-generated method stub
				iv_title.setImageBitmap(response);
			}
		}, 100, 160, Config.ARGB_8888, 
		null
		);
		queue.add(imageRequest);
	}
	
	public void dwonLoad(View v){
		Intent intent = new Intent();
		intent.setClass(this, AffirmdownloadActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kanmanhua, menu);
		return true;
	}

}
