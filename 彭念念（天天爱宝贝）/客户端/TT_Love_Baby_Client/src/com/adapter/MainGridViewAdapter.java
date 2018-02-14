package com.adapter;

import java.util.List;

import com.entity.MainGridView;
import com.example.tt_love_baby_client.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainGridViewAdapter extends BaseAdapter{
	List<MainGridView> list;
	Context cn;
	
	public MainGridViewAdapter(List<MainGridView> list, Context cn) {
		super();
		this.list = list;
		this.cn = cn;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Viewholder holder;
		if(view==null){
			view=LayoutInflater.from(cn).inflate(R.layout.mainlayout, null);
			holder=new Viewholder();
			holder.image=(ImageView) view.findViewById(R.id.iv_head);
			holder.name=(TextView) view.findViewById(R.id.tv_titlename);
			view.setTag(holder);
		}
		MainGridView mainGridView = list.get(arg0);
		holder=(Viewholder) view.getTag();
		holder.image.setImageResource(mainGridView.getHeadimage());
		holder.name.setText(mainGridView.getTitlename());
		return view;
	}
	class Viewholder{
		TextView name;
		ImageView image;
	}
}
