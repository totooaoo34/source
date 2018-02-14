package com.android.tenementclient.util;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	
	private LruCache<String, Bitmap> mCache;

	public BitmapCache() {
		
		int maxSize = 10 * 1024 * 1024;
		mCache = new LruCache<String, Bitmap>(maxSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				return value.getRowBytes() * value.getHeight();
			}
		};
	}

	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		return mCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		mCache.put(url, bitmap);
	}

	public void clearAll() {
		if (mCache != null) {
			if (mCache.size() > 0) {
				// 清除所有的
				mCache.evictAll();
			}
			mCache = null;
		}
	}

}
