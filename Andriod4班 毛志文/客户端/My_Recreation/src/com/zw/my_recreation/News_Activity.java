package com.zw.my_recreation;

import httpUrl.HttpNr;
import httpUrl.News_Url;
import java.util.List;

import picture.CircleFlowIndicator;
import picture.ImageAdapter;
import picture.ViewFlow;



import ben.MyNews;
import Adapter.MyAdapter;
import android.media.audiofx.BassBoost.Settings;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class News_Activity extends Activity {
	///private static final ListAdapter MyAdapter = null;
	/// 艺迅的主界面
	ListView lv;/// 用来显示主数据的控件
	List<MyNews> mList;
	private ViewFlow viewFlow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_);
		lv=(ListView) findViewById(R.id.listView1); 
		init();
		circleimage();
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//MyNews news=(MyNews) parent.getAdapter().getItem(position);	
			 Integer ssid=position;
			 Toast.makeText(News_Activity.this,ssid+"", Toast.LENGTH_SHORT).show();
			 Intent intent=new Intent();
			 intent.setClass(News_Activity.this, WebViewActivity.class);
			 startActivity(intent);
				
			 /// 调用 本地的视频
//				MyNews news=(MyNews) parent.getItemAtPosition(position);
//				String moviePath=News_Url.WEB_HOST+News_Url.WEB_MOVIES+"/"+news.getMoviePath();
//				Intent intent = new Intent();
//				intent.setAction(Intent.ACTION_VIEW);
//				//设置intent播放的类型
//				intent.setDataAndType(Uri.parse(moviePath),
//						"video/*");
//				startActivity(intent);
//				
				////窗体之间的传值  将我们所点点击获取到的id传到 Webview这个窗体去
			      
			
			
			}
		});
	}
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			List<MyNews> list=(List<MyNews>)msg.obj;
		lv.setAdapter(new MyAdapter(list, News_Activity.this));
		};
	};
	
	
	public void init(){
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
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	void circleimage() {

		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new ImageAdapter(this));
		viewFlow.setmSideBuffer(2); // 实际图片张数， 我的ImageAdapter实际图片张数为3
		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.circleFlowIndicator1);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(2000);
		viewFlow.setSelection(0); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放
	}
}
   
	
	

