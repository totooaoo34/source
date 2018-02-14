package com.zw.my_recreation;


import httpUrl.HttpNr;
import httpUrl.News_Url;

import java.util.List;

import ben.MyNews;
import Adapter.ExhbitionAdpter;
import Adapter.MyAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class Exhbition_Activity extends Activity {
   
	/// 艺展的主界面
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exhbition);
		lv=(ListView) findViewById(R.id.listView1);
		initAdd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exhbition_, menu);
		return true;
	}
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			List<MyNews> list=(List<MyNews>)msg.obj;
		lv.setAdapter(new ExhbitionAdpter(list, Exhbition_Activity.this));
		};
	};
	
	
	public void initAdd(){
		/// 子线程
		Thread  thread=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String content =HttpNr.sendHttpGet(News_Url.WEB_HOST+News_Url.WEB_SERVLET);
					Message msg=new Message();
					msg.obj=MovieManager.getMovieList(content);
					handler.sendMessage(msg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		thread.start();
		
	}

}
