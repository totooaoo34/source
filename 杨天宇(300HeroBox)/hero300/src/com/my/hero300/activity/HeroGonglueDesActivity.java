package com.my.hero300.activity;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HeroGonglueDesActivity extends Activity {
	WebView wv;
	String webPath;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero_gonglue_des);
		
		Intent intent = getIntent();
		webPath = intent.getStringExtra("webPath");
		wv = (WebView) this.findViewById(R.id.wv_gonglue_des);
		wv.loadUrl(webPath);
		wv.getSettings().setJavaScriptEnabled(true);  
		wv.setWebViewClient(new HelloWebViewClient ());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hero_gonglue_des, menu);
		return true;
	}
	
	
		
		
	//Web ”Õº  
    private class HelloWebViewClient extends WebViewClient {  
    	@Override 
		public boolean shouldOverrideUrlLoading(WebView view, String url) {  
    		view.loadUrl(url);
    		return true;
    	}  
    } 

}
