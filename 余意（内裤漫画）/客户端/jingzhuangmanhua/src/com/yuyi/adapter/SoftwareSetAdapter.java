package com.yuyi.adapter;

import java.util.List;

import com.yuyi.bean.SoftwareSetBean;
import com.yuyi.neikumanhua.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SoftwareSetAdapter extends BaseAdapter{
	
	public Context context;
	
	public List<SoftwareSetBean> sList;
	
	public SoftwareSetAdapter(Context context, List<SoftwareSetBean> sList) {
		super();
		this.context = context;
		this.sList = sList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return sList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view==null){
			view = LayoutInflater.from(context).inflate(R.layout.activity_softwareset_item, null);
		}
		TextView tv_setTitle = (TextView) view.findViewById(R.id.tv_setTitle);
		TextView tv_setContent = (TextView) view.findViewById(R.id.tv_setContent);
		ImageView iv_beaconImage = (ImageView) view.findViewById(R.id.iv_beaconImage);
		SoftwareSetBean softwareSetBean = sList.get(position);
		tv_setTitle.setText(softwareSetBean.getSetTitle());
		tv_setContent.setText(softwareSetBean.getSetContent());
		iv_beaconImage.setImageResource(softwareSetBean.getBeaconImage());
		return view;
	}

}
