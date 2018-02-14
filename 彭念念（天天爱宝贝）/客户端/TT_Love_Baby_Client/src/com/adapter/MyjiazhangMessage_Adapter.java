package com.adapter;

import java.util.ArrayList;
import java.util.List;

import com.entity.Jiazhang_Message;
import com.example.tt_love_baby_client.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MyjiazhangMessage_Adapter extends BaseAdapter {
	List<Jiazhang_Message> list;
	Context cn;

	public MyjiazhangMessage_Adapter(List<Jiazhang_Message> list, Context cn) {
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
		if (view == null) {
			view = LayoutInflater.from(cn).inflate(
					R.layout.show_jiazhang_message_layout, null);
			holder = new ViewHolder();
			holder.userimag = (ImageView) view
					.findViewById(R.id.iv_message_userimage);
			holder.username = (TextView) view
					.findViewById(R.id.tv_message_username);
			holder.messagecontext = (TextView) view
					.findViewById(R.id.tv_messagecontext);
			holder.messagedate = (TextView) view
					.findViewById(R.id.tv_messagedate);
			holder.images = (GridView) view.findViewById(R.id.gv_messageimages);

			view.setTag(holder);
		}
		else{
			holder = (ViewHolder) view.getTag();
		}
		
		Jiazhang_Message jiazhang_Message = list.get(arg0);
		holder.userimag.setImageResource(jiazhang_Message.getUserimage());
		holder.username.setText(jiazhang_Message.getUsername());
		holder.messagecontext.setText(jiazhang_Message.getMessagecontext());
		holder.messagedate.setText(jiazhang_Message.getMessagedate());

		List<Integer> imagelist = new ArrayList<Integer>();
		Integer[] contextimages = jiazhang_Message.getContextimages();
		if (contextimages != null) {
			for (int i = 0; i < contextimages.length; i++) {
				imagelist.add(contextimages[i]);
			}
			holder.images.setAdapter(new Jiazhangmessage_gridViewAdapter(
					imagelist, cn));
		} else {
			holder.images.setVisibility(View.GONE);
		}
		return view;
	}

	class ViewHolder {
		ImageView userimag;
		TextView username, messagedate, messagecontext;
		GridView images;
	}
}
