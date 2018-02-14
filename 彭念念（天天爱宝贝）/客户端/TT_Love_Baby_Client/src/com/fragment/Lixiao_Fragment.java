package com.fragment;

import java.util.ArrayList;
import java.util.List;

import com.adapter.LixiaoAdapter;
import com.entity.Lixiao;
import com.example.tt_love_baby_client.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Lixiao_Fragment extends Fragment{
	ListView lixiaolistview;
	List<Lixiao>list;
	private int[] image={R.drawable.student12};
	private String[] name={"³¿³¿"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.lixiao_fragment_layout, null);
		lixiaolistview=(ListView) view.findViewById(R.id.iv_lixiao_list);
		list=new ArrayList<Lixiao>();
		for (int i = 0; i < image.length; i++) {
			Lixiao lixiao=new Lixiao();
			lixiao.setStudentimage(image[i]);
			lixiao.setStudentname(name[i]);
			list.add(lixiao);
		}
		lixiaolistview.setAdapter(new LixiaoAdapter(list,getActivity()));
		return view;
	}
}
