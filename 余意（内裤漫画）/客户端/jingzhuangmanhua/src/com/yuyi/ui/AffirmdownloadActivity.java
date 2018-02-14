package com.yuyi.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ab.download.DownFileDao;
import com.ab.view.progress.AbHorizontalProgressBar;
import com.yuyi.adapter.DownloadcheckedAdapter;
import com.yuyi.adapter.LookItemAdapter;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;
import com.yuyi.neikumanhua.R.id;
import com.yuyi.neikumanhua.R.layout;
import com.yuyi.neikumanhua.R.menu;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class AffirmdownloadActivity extends Activity {

	TextView querenDownLoad;

	GridView myGridView;
	
	int progress = 0;
	
	String sdcardPath =Environment.getExternalStorageDirectory().getAbsolutePath();

	MyTask matask;
	
	//ProgressBar bar;
	
	AbHorizontalProgressBar mAbProgressBar;
	
	private TextView numberText, maxText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_affirmdownload);
		numberText = (TextView) findViewById(R.id.numberText);
		maxText = (TextView) findViewById(R.id.maxText);
		
		mAbProgressBar = (AbHorizontalProgressBar) findViewById(R.id.horizontalProgressBar);
		//bar = (ProgressBar) findViewById(R.id.progressBar1);
		myGridView = (GridView) findViewById(R.id.myGridView);
		querenDownLoad = (TextView) findViewById(R.id.querenDownLoad);
		myGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		myGridView.setAdapter(new DownloadcheckedAdapter(this, Contants.comicUrlList.size()));
		
		
		
	}
	Thread thraed = new Thread(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			downImage(Contants.httpUrlIndexCheckedList.get(0));
			super.run();
		}
	};
	public class MyTask extends AsyncTask<Object, Integer, Object>{

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			//Contants.httpUrlIndexCheckedList.get(0);
			//for(int i = 0;i<Contants.httpUrlIndexCheckedList.size();i++){
				
			//}
			return null;
		}
		
	}
	
	
	
	public void downImage(String imageHttpPath){
		try {
			URL url = new URL(imageHttpPath);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			//获取访问的响应code
			int code = connection.getResponseCode();
			if(code==200){//响应成功
				//读
				InputStream is = connection.getInputStream();
				//设置进度条最大值
				mAbProgressBar.setMax(connection.getContentLength());
				//判断sd卡是否存在
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
					File file = new File(sdcardPath,imageHttpPath.substring(imageHttpPath.length()-9,imageHttpPath.length()));
					if(!file.exists()){
						file.createNewFile();
					}
					//写入数据
					FileOutputStream fs = new FileOutputStream(file);
					byte[] buffer = new byte[100];
					int count = -1;
					while((count=is.read(buffer))!=-1){
						fs.write(buffer, 0, count);
						progress+=count;
						Message msg = new Message();
						msg.arg1 = progress;
						msg.what = 1;
						handler.sendMessage(msg);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					fs.flush();
					fs.close();
					is.close();
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				mAbProgressBar.setVisibility(View.VISIBLE);
				numberText.setVisibility(View.VISIBLE);
				maxText.setVisibility(View.VISIBLE);
				mAbProgressBar.setProgress(msg.arg1);
				int jindu = msg.arg1/1000+9;
				numberText.setText(String.valueOf(jindu));
				if("100".equals(numberText.getText())){
					//maxText.setVisibility(View.GONE);
					Toast.makeText(AffirmdownloadActivity.this, "恭喜您^_^下载成功！！！", 0).show();
				}
				break;
			}
		};
	};
	
	public void querenDownLoad(View v) {
		//Toast.makeText(AffirmdownloadActivity.this,Contants.httpUrlIndexCheckedList.size() + "集合大小", 0).show();
		if("".equals(numberText.getText())){
			thraed.start();
			maxText.setText("/"+100);
		}
		//matask = new MyTask();
		//matask.execute(3,2,1);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Contants.httpUrlIndexCheckedList.clear();
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.affirmdownload, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
