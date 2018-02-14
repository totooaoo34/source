package com.my.hero300.adapter;

import java.util.List;

import com.my.hero300.R;
import com.my.hero300.adapter.HeroAdapter.ViewHolder;
import com.my.hero300.bean.Equip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EquipAdapter extends BaseAdapter{
	LayoutInflater inflater;
	List<Equip> mList;
	Context mContext;
	public EquipAdapter(Context context,List<Equip> list){
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
			convertView = inflater.inflate(R.layout.equip_item, null);
			vh = new ViewHolder();
			vh.iv = (ImageView) convertView.findViewById(R.id.iv_lv_equip_pic);
			vh.tx = (TextView) convertView.findViewById(R.id.tv_lv_equip_name);
			convertView.setTag(vh);
		}else{
			vh = (ViewHolder) convertView.getTag();
		}
		vh.iv.setImageResource(mList.get(position).getPicPath());
		vh.tx.setText(mList.get(position).getEquipName());
		return convertView;
	}
	
	class ViewHolder{
		public ImageView iv;
		public TextView tx;
	}
}
