package com.zw.my_recreation;


import httpUrl.HttpNr;
import httpUrl.News_Url;

import java.util.List;

import ben.MyNews;
import Adapter.CalendarAdapter;
import Adapter.ExhbitionAdpter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class Calendar_Activity extends Activity {

	/// 这是艺历的主界面
	ListView Calendar_lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		Calendar_lv=(ListView) findViewById(R.id.lv_Calendar);
		CalendarAdd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar_, menu);
		return true;
	}
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			List<MyNews> list=(List<MyNews>)msg.obj;
			Calendar_lv.setAdapter(new CalendarAdapter(list, Calendar_Activity.this));
		};
	};
	
	
	public void CalendarAdd(){
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
