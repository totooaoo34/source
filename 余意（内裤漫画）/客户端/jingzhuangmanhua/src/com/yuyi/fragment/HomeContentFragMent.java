package com.yuyi.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.origamilabs.library.views.StaggeredGridView;
import com.yuyi.adapter.HomeAdapter;
import com.yuyi.adapter.StaggeredAdapter;
import com.yuyi.application.MyApplication;
import com.yuyi.bean.ComicBean;
import com.yuyi.bean.ComicBeanParcelable;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;
import com.yuyi.ui.KanmanhuaActivity;

public class HomeContentFragMent extends Fragment{
	String tag;
	View v;
	GridView gd_remen;
	JSONArray array;
	JSONObject data;
	MyApplication myappliction;
	RequestQueue queue;
	List<ComicBean> cList = new ArrayList<ComicBean>();
	String fMImageUrl = Contants.ComicHttpUrl+"remenlianzai/";
	StaggeredGridView gridView;
	List<String> urlList;
	
//	String[] urls = {
//			"http://192.168.0.103:8080/NeiKuServer/jingcaituijian/yaohu.png",
//			"http://192.168.0.103:8080/NeiKuServer/jingcaituijian/shalu.png",
//			"http://192.168.0.103:8080/NeiKuServer/jingcaituijian/qy.png",
//			"http://192.168.0.103:8080/NeiKuServer/jingcaituijian/king.png",
//			"http://192.168.0.103:8080/NeiKuServer/jingcaituijian/tmsn.png",
//			"http://192.168.0.103:8080/NeiKuServer/jingcaituijian/bloody.png"
//	};
	String[] urls = {
			Contants.ComicHttpUrl+"jingcaituijian/yaohu.png",
			Contants.ComicHttpUrl+"jingcaituijian/shalu.png",
			Contants.ComicHttpUrl+"jingcaituijian/qy.png",
			Contants.ComicHttpUrl+"jingcaituijian/king.png",
			Contants.ComicHttpUrl+"jingcaituijian/tmsn.png",
			Contants.ComicHttpUrl+"jingcaituijian/bloody.png"
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		myappliction = new MyApplication();
		queue = myappliction.getMyappliction().getQueue();
		Bundle bundle = getArguments();
		tag = bundle.getString("tag");
		//根据不同的tag发送不同的http请求
		if("0".equals(tag)){
			v = inflater.inflate(R.layout.activity_jingcaituijian, null);
			gridView = (StaggeredGridView) v.findViewById(R.id.staggeredGridView1);
			
			//sendHttpRequestGetRemMenJson();
			int margin = getResources().getDimensionPixelSize(R.dimen.margin);
			
			gridView.setItemMargin(margin); // set the GridView margin
			
			gridView.setPadding(margin, 0, margin, 0); // have the margin on the sides as well 
			
			StaggeredAdapter adapter = new StaggeredAdapter(getActivity(), R.id.imageView1, urls);
			
			gridView.setAdapter(adapter);
			
			adapter.notifyDataSetChanged();			
		}
		
		else if("1".equals(tag)){
			
			
			v = inflater.inflate(R.layout.activity_fragment_remenlianzai, null);
			gd_remen = (GridView) v.findViewById(R.id.gd_remen);
			
			sendHttpRequestGetRemMenJson();
			
			gd_remen.setOnItemClickListener(new OnItemClickListener() {
				
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					ComicBean comicBean =  (ComicBean) ((HomeAdapter) parent.getAdapter()).getItem(position);
					ComicBeanParcelable parcelable = new ComicBeanParcelable(comicBean.getComicId(), comicBean.getComicFmImgUrl(), comicBean.getComicName(), comicBean.getComicFmJiesao(), comicBean.getComicJqJiesao(), comicBean.getComicAuthor(), comicBean.getComicComat(), comicBean.getComicSource(), comicBean.getComicUpdateTime(), comicBean.getComicIma01Url(), comicBean.getComicIma02Url(), comicBean.getComicIma03Url(), comicBean.getComicIma04Url(), comicBean.getComicIma05Url(), comicBean.getComicIma06Url(), comicBean.getComicIma07Url(),comicBean.getComicIma08Url(),comicBean.getComicIma09Url(), comicBean.getComicIma10Url());
					urlList = new ArrayList<String>();
					urlList.add(parcelable.comicIma01Url);
					urlList.add(parcelable.comicIma02Url);
					urlList.add(parcelable.comicIma03Url);
					urlList.add(parcelable.comicIma04Url);
					urlList.add(parcelable.comicIma05Url);
					urlList.add(parcelable.comicIma06Url);
					urlList.add(parcelable.comicIma07Url);
					urlList.add(parcelable.comicIma08Url);
					urlList.add(parcelable.comicIma09Url);
					urlList.add(parcelable.comicIma10Url);
					Contants.comicUrlList = urlList;
					
					Intent intent = new Intent();
					intent.putExtra("parcelable", parcelable);
					intent.setClass(getActivity(), KanmanhuaActivity.class);
					startActivity(intent);
					
				}
			});
		}
		else if("2".equals(tag)){
			v = inflater.inflate(R.layout.activity_yuanchuangguoman, null);
		}
		
		return v;
	}
	
	public void sendHttpRequestGetRemMenJson(){
		String url = Contants.ComicHttpUrl+"comicAction!getComicList";
		JsonObjectRequest jsonRequest = new JsonObjectRequest(
				url,
				null,
				new Listener<JSONObject>() {//获取网络数据成功监听

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						try {
							array = response.getJSONArray("comic_remeng");
							for(int i = 1;i<array.length();i++){
								data = array.getJSONObject(i);
								ComicBean comicbean = new ComicBean();
								comicbean.setComicId(data.getInt("comicId"));
								comicbean.setComicFmImgUrl(fMImageUrl+data.getString("comicFmImgUrl"));
								comicbean.setComicName(data.getString("comicName"));
								comicbean.setComicFmJiesao(data.getString("comicFmJiesao"));
								comicbean.setComicJqJiesao(data.getString("comicJqJiesao"));
								comicbean.setComicAuthor(data.getString("comicAuthor"));
								comicbean.setComicComat(data.getString("comicComat"));
								comicbean.setComicSource(data.getString("comicSource"));
								comicbean.setComicUpdateTime(data.getString("comicUpdateTime"));
								comicbean.setComicIma01Url(fMImageUrl+data.getString("comicIma01Url"));
								comicbean.setComicIma02Url(fMImageUrl+data.getString("comicIma02Url"));
								comicbean.setComicIma03Url(fMImageUrl+data.getString("comicIma03Url"));
								comicbean.setComicIma04Url(fMImageUrl+data.getString("comicIma04Url"));
								comicbean.setComicIma05Url(fMImageUrl+data.getString("comicIma05Url"));
								comicbean.setComicIma06Url(fMImageUrl+data.getString("comicIma06Url"));
								comicbean.setComicIma07Url(fMImageUrl+data.getString("comicIma07Url"));
								comicbean.setComicIma08Url(fMImageUrl+data.getString("comicIma08Url"));
								comicbean.setComicIma09Url(fMImageUrl+data.getString("comicIma09Url"));
								comicbean.setComicIma10Url(fMImageUrl+data.getString("comicIma10Url"));
								cList.add(comicbean);
							}
							
							gd_remen.setAdapter(new HomeAdapter(getActivity(),cList,queue));
							
							
//							try {
//								Thread.sleep(2000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				},
				null);//获取网络数据失败监听
				queue.add(jsonRequest);
	}
}
