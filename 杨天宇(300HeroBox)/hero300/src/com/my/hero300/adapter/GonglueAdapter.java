package com.my.hero300.adapter;

import java.util.List;

import com.my.hero300.R;
import com.my.hero300.adapter.HeroAdapter.ViewHolder;
import com.my.hero300.bean.Hero;
import com.my.hero300.bean.HeroGonglue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GonglueAdapter extends BaseAdapter{

	LayoutInflater inflater;
	List<HeroGonglue> mList;
	Context mContext;
	public GonglueAdapter(Context context,List<HeroGonglue> list){
		this.mList = list;
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
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
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.gonglue_item, null);
			vh = new ViewHolder();
			vh.tx = (TextView) convertView.findViewById(R.id.tv_title);
			convertView.setTag(vh);
		}else{
			vh = (ViewHolder) convertView.getTag();
		}
		vh.tx.setText("¡¾"+mList.get(position).getType()+"¡¿"+mList.get(position).getTitle());
		return convertView;
	}
	
	class ViewHolder{
		public TextView tx;
	}
	
}
