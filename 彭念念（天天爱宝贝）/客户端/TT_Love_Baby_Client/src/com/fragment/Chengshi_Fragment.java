package com.fragment;

import com.adapter.MychengshiAdapter;
import com.example.tt_love_baby_client.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Chengshi_Fragment extends Fragment{
	ListView listView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.chengshi_fragment_layout, null);
		listView=(ListView) view.findViewById(R.id.lv_chengshi_list);
		//listView.setAdapter(new MychengshiAdapter(getActivity(),list));
		return view;
	}
}
