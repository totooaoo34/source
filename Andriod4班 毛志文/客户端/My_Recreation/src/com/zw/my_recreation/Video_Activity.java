package com.zw.my_recreation;


import httpUrl.HttpNr;
import httpUrl.News_Url;

import java.util.List;

import ben.MyNews;
import Adapter.MyAdapter;
import Adapter.VideoAdapter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Video_Activity extends Activity {
	GridView gv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		gv=(GridView) findViewById(R.id.gridView1);
		//gv.setAdapter(new Vid);
		Add();
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				MyNews news=(MyNews) parent.getItemAtPosition(position);
				String moviePath=News_Url.WEB_HOST+News_Url.WEB_MOVIES+"/"+news.getMoviePath();
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				//设置intent播放的类型
				intent.setDataAndType(Uri.parse(moviePath),
						"video/*");
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video_, menu);
		return true;
	}
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			//(List<MyNews>)msg.obj
			//gv.setAdapter(new VideoAdapter(, Video_Activity.this));
			List<MyNews> list=(List<MyNews>)msg.obj;
			gv.setAdapter(new VideoAdapter(list, Video_Activity.this));
		};
	};
	
	
	public void Add(){
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
