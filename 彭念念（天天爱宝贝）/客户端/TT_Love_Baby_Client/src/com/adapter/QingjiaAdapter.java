package com.adapter;

import java.util.List;

import com.entity.Qingjia;
import com.example.tt_love_baby_client.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QingjiaAdapter extends BaseAdapter{
	List<Qingjia> list;
	Context cn;
	
	public QingjiaAdapter(List<Qingjia> list, Context cn) {
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
		ViewHolder holder;
		if(view==null){
			view=LayoutInflater.from(cn).inflate(R.layout.show_qingjialist_layout, null);
			
			holder=new ViewHolder();
			holder.qingjianame=(TextView) view.findViewById(R.id.tv_qingjia_name);
			holder.qingjiacontext=(TextView) view.findViewById(R.id.tv_qingjia_context);
			holder.qingjiaimage=(ImageView) view.findViewById(R.id.iv_qingjia_image);
			holder.qingjia_tag=(ImageView) view.findViewById(R.id.iv_qingjia_type);
			holder.qingjia_title=(TextView) view.findViewById(R.id.tv_qingjia_type);
			holder.qingjia_bk=(ImageView) view.findViewById(R.id.iv_qingjia_bktitle);
			view.setTag(holder);
		}
		
		holder=(ViewHolder) view.getTag();
		Qingjia qingjia = list.get(arg0);
		holder.qingjianame.setText(qingjia.getQingqname());
		holder.qingjiaimage.setImageResource(qingjia.getQingjiaimage());
		holder.qingjiacontext.setText(qingjia.getQingjiacontext());
		holder.qingjia_title.setText(qingjia.getQingjiatype());
		if(arg0%2==0){
			holder.qingjia_bk.setImageResource(R.drawable.blue_color);
		}else{
			holder.qingjia_bk.setImageResource(R.drawable.red_color);
		}
		if(qingjia.getQingjiatype().equals("����")){
			holder.qingjia_tag.setImageResource(R.drawable.disease);
		}else if(qingjia.getQingjiatype().equals("�¼�")){
			holder.qingjia_tag.setImageResource(R.drawable.things);
		}
		
		return view;
	}
	class ViewHolder{
		TextView qingjianame;
		TextView qingjiatype;
		ImageView qingjiaimage;
		TextView qingjiacontext;
		TextView qingjia_title;
		ImageView qingjia_tag;
		ImageView qingjia_bk;
	}
}
