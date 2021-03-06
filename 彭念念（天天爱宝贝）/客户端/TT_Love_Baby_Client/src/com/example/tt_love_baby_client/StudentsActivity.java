package com.example.tt_love_baby_client;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.adapter.MyStudentAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.application.MyApplication;
import com.entity.Ai_student;
import com.util.Context_Util;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class StudentsActivity extends Activity {
	RequestQueue mQueue;
	GridView list;
	String LOGIN_URL = Context_Util.CONTEXT_LOGIN_URL
			+ "/student_action!findAll";

	int[] images = { R.drawable.student1, R.drawable.student2,
			R.drawable.student3, R.drawable.student4, R.drawable.student5,
			R.drawable.student6, R.drawable.student7, R.drawable.student8,
			R.drawable.student10, R.drawable.student11,R.drawable.student1,R.drawable.student2 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_students);
		mQueue = MyApplication.getMyApplication().getRequestQueue();

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View v = LayoutInflater.from(this).inflate(
				R.layout.students_actionbar_layout, null);
		TextView s_back = (TextView) v.findViewById(R.id.students_tvback);
		s_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		LayoutParams arg1 = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		actionBar.setCustomView(v, arg1);
		list = (GridView) findViewById(R.id.lv_students_listview);

		final List<Ai_student> studentlist = new ArrayList<Ai_student>();

		JsonObjectRequest request = new JsonObjectRequest(LOGIN_URL, null,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						try {
							JSONObject jsonObject = new JSONObject(response
									.toString());
							JSONArray jsonArray = jsonObject
									.getJSONArray("studentlist");
							for (int i = 0; i < jsonArray.length(); i++) {
								Ai_student ai_student = new Ai_student();
								JSONObject data = (JSONObject) jsonArray.get(i);
								ai_student.setS_id(data.getInt("S_id"));
								ai_student.setS_name(data.getString("S_name"));
								ai_student.setS_sex(data.getString("S_sex"));
								ai_student.setS_age(data.getInt("S_age"));
								ai_student.setS_phone(data.getString("S_phone"));
								ai_student.setS_address(data
										.getString("S_address"));
								// ai_student.setS_indate(data.getString("S_indate").toString());
								// ai_student.setS_outdate(data.getString("S_outdate").toString());
								ai_student.setS_image(images[i]);
								studentlist.add(ai_student);
							}
							list.setAdapter(new MyStudentAdapter(studentlist,
									StudentsActivity.this));

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

					}
				});
		mQueue.add(request);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.students, menu);
		return true;
	}

}
