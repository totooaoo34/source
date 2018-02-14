package com.yuyi.adapter;

import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;
import com.yuyi.ui.AffirmdownloadActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LookItemAdapter extends BaseAdapter {

	Context context;

	int itemSize;

	public LookItemAdapter(Context context, int itemSize) {
		super();
		this.context = context;
		this.itemSize = itemSize;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemSize;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = LayoutInflater.from(context).inflate(
					R.layout.activity_kanmanhua_item, null);
		}
		final TextView page = (TextView) view.findViewById(R.id.page);
		
		page.setText(position + 1 + "");
		
		return view;
		
	}

}
