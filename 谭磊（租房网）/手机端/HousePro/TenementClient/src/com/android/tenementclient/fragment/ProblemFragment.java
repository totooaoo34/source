package com.android.tenementclient.fragment;

import com.android.tenementclient.R;
import com.android.tenementclient.view.DIYImageView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Administrator 问答-Fragment
 *
 */
public class ProblemFragment extends Fragment {

	private DIYImageView ftmj;
	private DIYImageView fwls;
	private DIYImageView hqf;

	private float BTN_TEXTSIZE = 30f;
	private int BTN_TEXTCOLOR = Color.BLACK;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_baike_problem, null);

		ftmj = (DIYImageView) view.findViewById(R.id.dIY01);
		fwls = (DIYImageView) view.findViewById(R.id.dIY02);
		hqf = (DIYImageView) view.findViewById(R.id.dIY03);
		
		ftmj.setText("公滩面积");
		fwls.setText("房屋律师");
		hqf.setText("回迁房");
		
		ftmj.setColor(BTN_TEXTCOLOR);
		fwls.setColor(BTN_TEXTCOLOR);
		hqf.setColor(BTN_TEXTCOLOR);
		
		ftmj.setTextSize(BTN_TEXTSIZE);
		fwls.setTextSize(BTN_TEXTSIZE);
		hqf.setTextSize(BTN_TEXTSIZE);
		return view;
	}
}
