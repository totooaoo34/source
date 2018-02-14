package com.yuyi.fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageRequest;
import com.yuyi.application.MyApplication;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LookComicFragment extends Fragment{
	View v;
	int tag;
	Bitmap bit;
	MyApplication myappliction;
	RequestQueue queue;
	ImageView iv_comicFragment;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.activity_comicfragment_item, null);
		
		myappliction = new MyApplication();
		queue = myappliction.getMyappliction().getQueue();
		
		Bundle bundle = getArguments();
		iv_comicFragment = (ImageView) v.findViewById(R.id.iv_comicFragment);
		
		tag = Integer.parseInt((String) bundle.get("tag"));
		if(tag==0){
			v = inflater.inflate(R.layout.activity_tishistart, null);
		}
		else if(tag==11){
			v = inflater.inflate(R.layout.tishistop, null);
		}
		for(int i = 1;i<=Contants.comicUrlList.size();i++){
			if(i==tag){
				ImageRequest imageRequest = new ImageRequest(Contants.comicUrlList.get(i-1), new Listener<Bitmap>() {
					
					@Override
					public void onResponse(Bitmap arg0) {
						// TODO Auto-generated method stub
						iv_comicFragment.setImageBitmap(arg0);
					}
				}, 940, 640, Config.ARGB_8888, null);
				queue.add(imageRequest);
			}
			else if(i!=tag+1){
				continue;
			}
		}
		return v;
	}
	public void RequestImage(){
		ImageRequest imageRequest = new ImageRequest(Contants.comicUrlList.get(tag), new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap arg0) {
				// TODO Auto-generated method stub
				
			}
		}, 160, 100, Config.ARGB_8888, null);
		queue.add(imageRequest);
	}
}
