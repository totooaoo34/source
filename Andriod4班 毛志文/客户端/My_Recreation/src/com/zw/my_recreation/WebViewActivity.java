package com.zw.my_recreation;

import android.R.bool;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

	/// 网络请求的 页面
	WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		webview=(WebView) findViewById(R.id.webView1);
		 
		webview.getSettings().setJavaScriptEnabled(true);//支持js
		 
		// webview.loadUrl("http://www.youku.com");
		
		webview.loadUrl("http://world.gmw.cn/newspaper/2015-03/17/content_105205337.htm");
		//webview.loadUrl("http://intl.ce.cn/intlpic/gd/201503/17/t20150317_4842351.shtml");
		//webview.loadUrl("http://photo.firefox.news.cn/15/0331/12/9JVOHEYGXU06Q78P.html");
		webview.setWebChromeClient(new WebChromeClient());
		
		webview.setWebViewClient(new WebViewClient(){
			// 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
			view.loadUrl(url);
				return true;
			}
	});
		
	
		/*//webview.loadUrl("http://www.tudou.com/albumplay/qJtXzLi3iaY/Su8EcoXlEwo.html");
		//webview.getSettings().setPluginsEnabled(true);//设置webview支持插件
		webview.setWebChromeClient(new WebChromeClient());
		  webview.setWebViewClient(new WebViewClient(){
			public boolean shouldOverrideUrlLoading(WebView view,String  url){
				view.loadUrl(url);
				return true;
	       }
		});*/
	}
	
   @Override
     public boolean onKeyDown(int keyCode, KeyEvent event) {
	// TODO Auto-generated method stub
	   if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) 
		{// goBack()返回WebView的上一层页面
		   webview.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

	
	
}
