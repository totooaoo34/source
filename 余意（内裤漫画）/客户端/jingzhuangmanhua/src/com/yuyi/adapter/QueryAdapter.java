package com.yuyi.adapter;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.yuyi.bean.ComicTypeBean;
import com.yuyi.neikumanhua.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QueryAdapter extends BaseAdapter {

	public Context context;

	List<ComicTypeBean> tList;

	// 图片缓存器
	final LruCache<String, Bitmap> lrucache = new LruCache<String, Bitmap>(20);

	// 队列
	RequestQueue queue;

	// 图片加载器
	ImageLoader imageLoader;
	
	public QueryAdapter(Context context, List<ComicTypeBean> tList,
			RequestQueue queue) {
		super();
		this.context = context;
		this.tList = tList;
		this.queue = queue;
		
		// 创建图片缓存对象
		ImageCache imageCache = new ImageCache() {

			@Override
			public void putBitmap(String arg0, Bitmap arg1) {
				// TODO Auto-generated method stub
				lrucache.put(arg0, arg1);
			}

			@Override
			public Bitmap getBitmap(String arg0) {
				// TODO Auto-generated method stub
				return lrucache.get(arg0);
			}
		};
		// 图片加载器可以从内存缓存中获取图片
		imageLoader = new ImageLoader(queue, imageCache);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return tList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view == null){
			view = LayoutInflater.from(context).inflate(R.layout.activity_query_item, null);
		}
		ImageView iv_typeFmImgUrl = (ImageView) view.findViewById(R.id.iv_typeFmImgUrl);
		TextView tv_typeName = (TextView) view.findViewById(R.id.tv_typeName);
		
		ComicTypeBean comicTypeBean = tList.get(position);
		imageLoader.get(comicTypeBean.getTypeFmImgUrl(), ImageLoader.getImageListener(
				iv_typeFmImgUrl,
				android.R.drawable.ic_menu_rotate,
				android.R.drawable.ic_delete));
		tv_typeName.setText(comicTypeBean.getTypeName());
		return view;
	}

}
