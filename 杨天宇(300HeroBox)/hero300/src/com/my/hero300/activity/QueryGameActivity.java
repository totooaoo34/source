package com.my.hero300.activity;

import com.my.hero300.R;
import com.my.hero300.R.layout;
import com.my.hero300.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class QueryGameActivity extends Activity {
	WebView wv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query_game);
		
		wv = (WebView) this.findViewById(R.id.wv_query);
		wv.loadUrl("http://300report.jumpw.com/index.html");
		wv.getSettings().setJavaScriptEnabled(true);  
		wv.setWebViewClient(new HelloWebViewClient ());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.query_game, menu);
		return true;
	}
	
	//…Ë÷√ªÿÕÀ  
	public boolean onKeyDown(int keyCode, KeyEvent event) {  
		if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {  
			wv.goBack(); 
	        return true;  
	    }  
	    return false;   
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
