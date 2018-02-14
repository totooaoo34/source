package com.yuyi.application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application{
	private static MyApplication myappliction;
	//volley∂”¡–
	public RequestQueue queue;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		myappliction = this;
		queue = Volley.newRequestQueue(this);
		super.onCreate();
	}

	public static MyApplication getMyappliction() {
		return myappliction;
	}


	public RequestQueue getQueue() {
		return queue;
	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
}
