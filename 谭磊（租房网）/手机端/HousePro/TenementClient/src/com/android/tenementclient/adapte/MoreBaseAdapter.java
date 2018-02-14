package com.android.tenementclient.adapte;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tenementclient.R;
import com.android.tenementclient.entity.GuessMsg;

/**
 * @author Administrator home->更多 页面适配器
 * 
 */
public class MoreBaseAdapter extends BaseAdapter {

	private List<GuessMsg> mMsgs;
	private Context mContext;

	public MoreBaseAdapter(Context context, List<GuessMsg> msgs) {
		mContext = context;
		mMsgs = msgs;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mMsgs.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mMsgs.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.list_more,
					null);
			viewHolder.iv_like_img = (ImageView) view
					.findViewById(R.id.lv_more_img);
			viewHolder.tv_like_title = (TextView) view
					.findViewById(R.id.tv_more_txt);
			;
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		// 根据position进行赋值
		GuessMsg msg = mMsgs.get(position);
		viewHolder.iv_like_img.setImageResource(msg.getGuessImg());
		viewHolder.tv_like_title.setText(msg.getGuessTitle());
		return view;
	}

	class ViewHolder {
		ImageView iv_like_img;
		TextView tv_like_title;
	}
}
