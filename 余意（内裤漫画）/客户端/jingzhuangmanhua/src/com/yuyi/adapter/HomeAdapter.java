package com.yuyi.adapter;

import java.util.List;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.yuyi.bean.ComicBean;
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

public class HomeAdapter extends BaseAdapter{
	
	//ͼƬ������
	final LruCache<String, Bitmap> lrucache = new LruCache<String, Bitmap>(20);
	
	//����
	RequestQueue queue;
	
	//ͼƬ������
	ImageLoader imageLoader;
	
	public Context context;
	
	public List<ComicBean> cList;
	
	public HomeAdapter( Context context,
			List<ComicBean> cList,RequestQueue queue) {
		super();
		this.queue = queue;
		this.context = context;
		this.cList = cList;
		
		//����ͼƬ�������
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
		//ͼƬ���������Դ��ڴ滺���л�ȡͼƬ
		imageLoader = new ImageLoader(queue, imageCache);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return cList.get(position);
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
			view = LayoutInflater.from(context).inflate(R.layout.activity_comic_item, null);
		}
		TextView tv_comicName = (TextView) view.findViewById(R.id.tv_comicName);
		TextView tv_comicFmJiesao = (TextView) view.findViewById(R.id.tv_comicFmJiesao);
		TextView tv_comicpage_item = (TextView) view.findViewById(R.id.tv_comicpage_item);
		ImageView iv_home_item = (ImageView) view.findViewById(R.id.iv_home_item);
		
		ComicBean comicBean = cList.get(position);

		imageLoader.get(comicBean.getComicFmImgUrl(), ImageLoader.getImageListener(
				iv_home_item,
				android.R.drawable.ic_menu_rotate,
				android.R.drawable.ic_delete));
		
		tv_comicName.setText(comicBean.getComicName());
		tv_comicFmJiesao.setText(comicBean.getComicFmJiesao());
		tv_comicpage_item.setText(cList.size()+"��");
		return view;
	}

}
