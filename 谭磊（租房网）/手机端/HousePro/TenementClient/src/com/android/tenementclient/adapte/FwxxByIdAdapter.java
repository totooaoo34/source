package com.android.tenementclient.adapte;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tenementclient.R;
import com.android.tenementclient.dialog.MyDialogSms;
import com.android.tenementclient.entity.FwxxById;

/**
 * @author Administrator 房屋信息详情适配器
 * 
 */
public class FwxxByIdAdapter extends BaseAdapter {

	FwxxById mFwxxByID;
	Context mContext;

	/** 电话号码 **/
	String phoneCode;
	/** 短信文本 **/
	String smsContent;
	/** 自定义发送信息对话框 **/
	
	public FwxxByIdAdapter(FwxxById fwxxByID, Context context) {
		this.mFwxxByID = fwxxByID;
		this.mContext = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.list_fwxxbyid, null);
			holder = new ViewHolder();
			holder.tv_fwxxbyid_title = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_title);
			holder.tv_fwxxbyid_fwlx = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_fwlx);
			holder.tv_fwxxbyid_shi = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_shi);
			holder.tv_fwxxbyid_ting = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_ting);
			holder.tv_fwxxbyid_zj = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_zj);
			holder.tv_fwxxbyid_qx = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_qx);
			holder.tv_fwxxbyid_jd = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_jd);
			holder.tv_fwxxbyid_date = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_date);
			holder.tv_fwxxbyid_fwxx = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_fwxx);
			holder.tv_fwxxbyid_lxr = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_lxr);
			holder.tv_fwxxbyid_telephone = (TextView) view
					.findViewById(R.id.tv_fwxxbyid_telephone);
			holder.iv_fwxxbyid_phone = (ImageView) view
					.findViewById(R.id.iv_fwxxbyid_phone);
			holder.iv_fwxxbyid_message = (ImageView) view
					.findViewById(R.id.iv_fwxxbyid_message);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		FwxxById fwxxById = this.mFwxxByID;

		holder.tv_fwxxbyid_title.setText(fwxxById.getTitle().toString());
		holder.tv_fwxxbyid_fwlx.setText(fwxxById.getFwlx().toString());
		holder.tv_fwxxbyid_shi.setText(fwxxById.getShi().toString());
		holder.tv_fwxxbyid_ting.setText(fwxxById.getTing().toString());
		holder.tv_fwxxbyid_zj.setText(fwxxById.getZj().toString());
		holder.tv_fwxxbyid_qx.setText(fwxxById.getQx().toString());
		holder.tv_fwxxbyid_jd.setText(fwxxById.getJd().toString());
		holder.tv_fwxxbyid_date.setText(fwxxById.getDate().toString());
		holder.tv_fwxxbyid_fwxx.setText(fwxxById.getFwxx().toString());
		holder.tv_fwxxbyid_lxr.setText(fwxxById.getLxr().toString());
		holder.tv_fwxxbyid_telephone
				.setText(fwxxById.getTelephone().toString());

		// 保存电话号码
		phoneCode = holder.tv_fwxxbyid_telephone.getText().toString();

		// 打电话监听
		holder.iv_fwxxbyid_phone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
						+ phoneCode));
				mContext.startActivity(intent);
			}
		});
		
		// 发短信
		holder.iv_fwxxbyid_message.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Dialog dialog = new MyDialogSms(mContext,R.style.MyDialog_style_NoTitle);
				dialog.show();
			}
		});
		return view;
	}

	class ViewHolder {
		ImageView iv_fwxxbyid_top_img;
		TextView tv_fwxxbyid_title;
		TextView tv_fwxxbyid_fwlx;
		TextView tv_fwxxbyid_shi;
		TextView tv_fwxxbyid_ting;
		TextView tv_fwxxbyid_zj;
		TextView tv_fwxxbyid_qx;
		TextView tv_fwxxbyid_jd;
		TextView tv_fwxxbyid_date;
		TextView tv_fwxxbyid_fwxx;
		TextView tv_fwxxbyid_lxr;
		TextView tv_fwxxbyid_telephone;
		ImageView iv_fwxxbyid_phone;
		ImageView iv_fwxxbyid_message;
	}

}
