package com.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adapter.MainGridViewAdapter.Viewholder;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.entity.Ai_student;
import com.entity.MainGridView;
import com.example.tt_love_baby_client.R;

public class MyStudentAdapter extends BaseAdapter {
	List<Ai_student> list;
	Context cn;
	
	public MyStudentAdapter(List<Ai_student> studentlist, Context cn) {
		super();
		this.list = studentlist;
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
		Viewholder holder;
		if(view==null){
			view=LayoutInflater.from(cn).inflate(R.layout.students_layout, null);
			holder=new Viewholder();
			holder.image=(ImageView) view.findViewById(R.id.iv_studentimage);
			holder.name=(TextView) view.findViewById(R.id.iv_studentname);
			view.setTag(holder);
		}
		Ai_student ai_student = list.get(arg0);
		holder=(Viewholder) view.getTag();
		holder.image.setImageResource(ai_student.getS_image());
		holder.name.setText(ai_student.getS_name());
		return view;
	}
	class Viewholder{
		TextView name;
		ImageView image;
	}
	

}
