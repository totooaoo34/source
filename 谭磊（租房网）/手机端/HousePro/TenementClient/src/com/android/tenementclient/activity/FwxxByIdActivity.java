package com.android.tenementclient.activity;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.tenementclient.R;
import com.android.tenementclient.adapte.FwxxByIdAdapter;
import com.android.tenementclient.application.VolleyApplication;
import com.android.tenementclient.content.WebContent;
import com.android.tenementclient.entity.FwxxById;
import com.android.tenementclient.json.FwxxJSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * @author Administrator 房屋信息单个详情
 *
 */
public class FwxxByIdActivity extends Activity {

	Bundle bundle;
	String fwid;
	ListView lv_fwxxbyid;
	View fwxxbyid_top;
	Intent intent;

	// volley缓存机制
	public static final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(
			20);
	public static RequestQueue mQueue;// volley的队列
	public static ImageLoader imageLoader;// volley的图片加载器

	@Override
	protected void onCreate(Bundle arg0) {		
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_fwxxbyid);
		intent = this.getIntent();
		bundle = intent.getExtras();
		// 收到bundle传过来的房屋ID进行JSON构造
		fwid = bundle.getString("fwid");
		mQueue = VolleyApplication.getVolleyApplication().mQueue;
		lv_fwxxbyid = (ListView) findViewById(R.id.lv_fwxxbyid);
		sendJsonRequest();
	}

	FwxxJSON fwxxJSON;

	public void sendJsonRequest() {
		String url = WebContent.HOST + WebContent.ACTION_FWXX_BYID + "?fwid="
				+ fwid;
		JsonObjectRequest jsonRequest = new JsonObjectRequest(url, null,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						fwxxJSON = new FwxxJSON();
						FwxxById fwxxByID = fwxxJSON.getFwxxByIdJson(response
								.toString());

						fwxxbyid_top = LayoutInflater.from(
								FwxxByIdActivity.this).inflate(
								R.layout.activity_fwxxbyid_top, null);

						ImageView imageView = (ImageView) fwxxbyid_top
								.findViewById(R.id.iv_fwxxbyid_top_img);

						// Volley图片加载器
						imageLoader =VolleyApplication.getVolleyApplication().mImageLoader;
						
						imageLoader.get(WebContent.HOST + WebContent.HOUSE_IMG
								+ fwxxByID.getImg(), ImageLoader
								.getImageListener(imageView,
 										R.drawable.icon_loading,// 加载中显示的图片
										R.drawable.pic_loading_offline));// 失败的图片

						lv_fwxxbyid.setDividerHeight(0);
						lv_fwxxbyid.addHeaderView(fwxxbyid_top);
						lv_fwxxbyid.setAdapter(new FwxxByIdAdapter(fwxxByID,
								FwxxByIdActivity.this));
					}
				}, null);
		mQueue.add(jsonRequest);
	}
}
