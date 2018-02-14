package com.android.tenementclient.adapte;

import com.android.tenementclient.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	Context mContext;
	private LayoutInflater mInflater;
	private static final int[] ids = { R.drawable.anima01, R.drawable.anima02 };

	public ImageAdapter(Context context) {
		this.mContext = context;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// 返回很大的值使得getView中的position不断增大来实现循环
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.image_item, null);
		}
		((ImageView) convertView.findViewById(R.id.imgView))
				.setImageResource(ids[position % ids.length]);
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 在这里可以设置跳转界面
				// Intent intent = new Intent(mContext,DetailActivity.class);
				// Bundle bundle = new Bundle();
				// bundle.putInt("image_id", ids[position%ids.length]);
				// intent.putExtras(bundle);
				// mContext.startActivity(intent);
			}
		});
		return convertView;
	}

}
