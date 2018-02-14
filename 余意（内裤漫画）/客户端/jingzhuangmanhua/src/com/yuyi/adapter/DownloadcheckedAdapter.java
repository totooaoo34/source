package com.yuyi.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;
import com.yuyi.ui.AffirmdownloadActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadcheckedAdapter extends BaseAdapter {
	Context context;

	int itemSize;

	public DownloadcheckedAdapter(Context context, int itemSize) {
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
					R.layout.activity_downloadchecked, null);
		}
		final TextView page = (TextView) view.findViewById(R.id.page);
		page.setText(position + 1 + "");
		page.setTag(false);
		
		page.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Boolean tag = (Boolean) page.getTag();
				if (tag == false) {
					page.setTag(true);
					page.setBackgroundResource(R.drawable.download_logo_bj);
					Contants.httpUrlIndexCheckedList.add(Contants.comicUrlList.get(Integer.parseInt(page
							.getText().toString())-1));
				} else {
					page.setTag(false);
					page.setBackgroundResource(R.drawable.rectang);
					// 判断集合中有没有此数据 有就删除
					for (Iterator it = Contants.httpUrlIndexCheckedList
							.iterator(); it.hasNext();) {
						String zhi = (String) it.next();
						if (zhi.equals(Contants.comicUrlList.get(Integer.parseInt(page
							.getText().toString())-1))) {
							it.remove();
						}
					}
				}
			}
		});
		return view;
	}

}
