package com.android.tenementclient.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.android.tenementclient.util.BitmapCache;

public class VolleyApplication extends Application{
	
	private static VolleyApplication instance;
	
	public RequestQueue mQueue;
	public ImageLoader mImageLoader;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
		//初始化RequestQueue 只会调用一次
		mQueue = Volley.newRequestQueue(this);
		//初始化ImageLoader
		mImageLoader = new ImageLoader(mQueue, new BitmapCache());
	}
	
	public static VolleyApplication getVolleyApplication() {
		return instance;
	}
	
	public RequestQueue getRequesrQueue() {
		return mQueue;
	}
	
	public ImageLoader getImageLoader() {
		return mImageLoader;
	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
}
