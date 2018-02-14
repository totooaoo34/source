package com.yuyi.ui;



import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yuyi.adapter.HomeAdapter;
import com.yuyi.adapter.QueryAdapter;
import com.yuyi.application.MyApplication;
import com.yuyi.bean.ComicBean;
import com.yuyi.bean.ComicTypeBean;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.widget.GridView;

public class QueryActivity extends Activity {
	GridView gv_query;
	
	MyApplication myappliction;
	RequestQueue queue;
	
	JSONArray array;
	JSONObject data;
	
	List<ComicTypeBean> tList = new ArrayList<ComicTypeBean>();
	
	String typImaeUrl = Contants.ComicHttpUrl+"querytype/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query);
		myappliction = new MyApplication();
		queue = myappliction.getMyappliction().getQueue();
		
		gv_query = (GridView) findViewById(R.id.gv_query);
		gv_query.setSelector(new ColorDrawable(Color.TRANSPARENT));
		sendHttpRequestGetRemMenJson();
		
	}

	public void sendHttpRequestGetRemMenJson(){
		String url = Contants.ComicHttpUrl+"comicAction!getComicTypeList";
		//String url = "http://192.168.2.69:8080/NeiKuServer/comicAction!getComicTypeList";
		JsonObjectRequest jsonRequest = new JsonObjectRequest(
				url,
				null,
				new Listener<JSONObject>() {//获取网络数据成功监听

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						try {
							array = response.getJSONArray("comic_type");
							for(int i = 0;i<array.length();i++){
								data = array.getJSONObject(i);
								ComicTypeBean comictypebean = new ComicTypeBean();
								comictypebean.setTypesId(data.getInt("typesId"));
								comictypebean.setTypeFmImgUrl(typImaeUrl+data.getString("typeFmImgUrl"));
								comictypebean.setTypeName(data.getString("typeName"));
								comictypebean.setForeignId(data.getInt("foreignId"));
								tList.add(comictypebean);
							}
							
							gv_query.setAdapter(new QueryAdapter(QueryActivity.this,tList,queue));
							
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				},
				null);//获取网络数据失败监听
				queue.add(jsonRequest);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.query, menu);
		return true;
	}

}
