package com.android.tenementclient.adapte;

import java.util.List;

import com.android.tenementclient.R;
import com.android.tenementclient.application.VolleyApplication;
import com.android.tenementclient.content.WebContent;
import com.android.tenementclient.entity.Fwxx;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Administrator 房屋信息适配器
 */
public class FwxxAdapter extends BaseAdapter {

	List<Fwxx> mList;
	Context mContext;
	RequestQueue requestQueue = VolleyApplication.getVolleyApplication().mQueue;
	final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20);
	ImageLoader imageLoader = VolleyApplication.getVolleyApplication().mImageLoader;

	public FwxxAdapter(List<Fwxx> list, Context context, RequestQueue request) {
		mList = list;
		mContext = context;
		requestQueue = request;

		ImageCache imageCache = new ImageCache() {// 用于做图片缓存

			@Override
			public void putBitmap(String key, Bitmap value) {
				// TODO Auto-generated method stub
				lruCache.put(key, value);
			}

			@Override
			public Bitmap getBitmap(String key) {
				// TODO Auto-generated method stub
				return lruCache.get(key);
			}
		};
		imageLoader = new ImageLoader(requestQueue, imageCache);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		// if (view == null) {
		view = LayoutInflater.from(mContext).inflate(R.layout.list_fwxx, null);

		// view.setTag(holder);// 保存
		// }
		// else {
		// holder = (ViewHolder) view.getTag();
		// }

		holder = new ViewHolder();
		holder.iv_fwxx_img = (ImageView) view.findViewById(R.id.iv_fwxx_img);
		holder.tv_title = (TextView) view.findViewById(R.id.tv_title);// 标题
		holder.tv_shi = (TextView) view.findViewById(R.id.tv_shi);// 室
		holder.tv_ting = (TextView) view.findViewById(R.id.tv_ting);// 厅
		holder.tv_date = (TextView) view.findViewById(R.id.tv_date);// 日期
		holder.tv_fwid = (TextView) view.findViewById(R.id.tv_fwid);// 房屋ID号
		holder.tv_zj = (TextView) view.findViewById(R.id.tv_zj);// 资金
		// 对标签进行赋值
		Fwxx fwxx = this.mList.get(position);

		holder.tv_title.setText(fwxx.getTitle().toString());
		holder.tv_shi.setText(fwxx.getShi().toString());
		holder.tv_ting.setText(fwxx.getTing().toString());
		holder.tv_date.setText(fwxx.getDate().toString());
		holder.tv_zj.setText(fwxx.getZj().toString());
		holder.tv_fwid.setText(fwxx.getFwid().toString());

		// 图片加载器
		imageLoader.get(WebContent.HOST + WebContent.HOUSE_IMG + fwxx.getImg(),
				ImageLoader
						.getImageListener(holder.iv_fwxx_img,
								R.drawable.icon_loading,
								R.drawable.pic_loading_offline));// 失败的图片

		return view;
	}

	class ViewHolder {
		ImageView iv_fwxx_img;
		TextView tv_title;
		TextView tv_shi;
		TextView tv_ting;
		TextView tv_date;
		TextView tv_zj;
		TextView tv_fwid;
	}

}
