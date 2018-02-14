package com.application;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	private LruCache<String, Bitmap> cache;
	
	public BitmapCache(){
		int maxSize=1*1024*1024;
		cache=new LruCache<String, Bitmap>(maxSize){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				return value.getRowBytes()*value.getHeight();
			}
		};
		
	}
	
	public void close(){
		if(cache!=null){
			if(cache.size()>0){
				cache.evictAll();
			}
			cache=null;
		}
	}
	
	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub

	}

}
