package com.my.hero300.adapter;

import java.util.List;

import com.my.hero300.R;
import com.my.hero300.bean.Skill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SkillAdapter extends BaseAdapter{

	LayoutInflater inflater;
	List<Skill> mList;
	Context mContext;
	
	public SkillAdapter(Context context, List<Skill> list){
		this.mContext = context;
		this.mList = list;
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
			convertView = inflater.inflate(R.layout.skill_item, null);
			vh = new ViewHolder();
			vh.iv_skill = (ImageView) convertView.findViewById(R.id.iv_skill);
			vh.tv_skill_type = (TextView) convertView.findViewById(R.id.tv_skill_type);
			vh.tv_skill_name = (TextView) convertView.findViewById(R.id.tv_skill_name);
			vh.tv_skill_cd = (TextView) convertView.findViewById(R.id.tv_skill_cd);
			vh.tv_skill_consume = (TextView) convertView.findViewById(R.id.tv_skill_consume);
			vh.tv_skill_des = (TextView) convertView.findViewById(R.id.tv_skill_des);
			convertView.setTag(vh);
		}else{
			vh = (ViewHolder) convertView.getTag();
		}
		vh.iv_skill.setImageResource(mList.get(position).getSkillPath());
		vh.tv_skill_type.setText(mList.get(position).getSkillType());
		vh.tv_skill_name.setText(mList.get(position).getSkillName());
		vh.tv_skill_cd.setText(mList.get(position).getSkillCD());
		vh.tv_skill_consume.setText(mList.get(position).getSkillConsume());
		vh.tv_skill_des.setText(mList.get(position).getSkillDetail());
		return convertView;
	}
	
	class ViewHolder{
		TextView tv_skill_type;
		TextView tv_skill_name;
		TextView tv_skill_cd;
		TextView tv_skill_consume;
		TextView tv_skill_des;
		ImageView iv_skill;
	}
	
}
