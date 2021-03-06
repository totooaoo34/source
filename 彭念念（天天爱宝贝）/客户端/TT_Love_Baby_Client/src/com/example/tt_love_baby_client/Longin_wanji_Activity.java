package com.example.tt_love_baby_client;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.application.MyApplication;
import com.util.Context_Util;
import com.util.JsonObjectPostRequest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Longin_wanji_Activity extends Activity {
	ImageView iv_OK;
	ImageView iv_back;
	EditText xinmima,quemima;
	
	RequestQueue mQueue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_longin_wanji_);
		mQueue = MyApplication.getMyApplication().getRequestQueue();
		
		iv_OK=(ImageView) findViewById(R.id.iv_wanji_OK);
		iv_back=(ImageView) findViewById(R.id.iv_wanji_back);
		xinmima=(EditText) findViewById(R.id.et_xingpws);
		quemima=(EditText) findViewById(R.id.et_que_pws);
		iv_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		iv_OK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(xinmima.getText().toString().equals(quemima.getText().toString())){
					update_user();
				}else{
					Toast.makeText(Longin_wanji_Activity.this, "两次密码不正确", 0).show();
				}
				
			}
		});
		
	}
	//修改密码
	public void update_user() {
		Intent intent = getIntent();
		final String shouji=intent.getStringExtra("shouji");
		//preferences = getSharedPreferences("cookiename1", MODE_PRIVATE);
		String LOGIN_URL = Context_Util.CONTEXT_LOGIN_URL
				+ "/userAction!updata_Ai_user?User_phone="+shouji
				+ "&User_password="+xinmima.getText().toString();
		StringRequest stringRequest = new StringRequest(
				LOGIN_URL, //请求的路径
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Toast.makeText(Longin_wanji_Activity.this,
								"修改成功", 
								0).show();
						longinuser(shouji,xinmima.getText().toString());
						
					}
				},//成功之后返回回调方法
				new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Toast.makeText(Longin_wanji_Activity.this,
								"修改失败", 
								0).show();
					}
				});//失败之后返回的回调方法
		mQueue.add(stringRequest);
	}
	
	//修改成功后登录
	public void longinuser(String shouji,String psw) {

		//preferences = getSharedPreferences("cookiename1", MODE_PRIVATE);
		String LOGIN_URL = Context_Util.CONTEXT_LOGIN_URL+"/userAction!findby"
				+ "?userphone="
				+ shouji
				+ "&userpassword="
				+ psw;
		JsonObjectPostRequest jsonObjectPostRequest = new JsonObjectPostRequest(
				LOGIN_URL, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						
						Intent intent = new Intent(Longin_wanji_Activity.this,
								MainActivity.class);
						Bundle bundle=new Bundle();			
						try {
							bundle.putString("User_id", response.getString("User_id"));
							bundle.putString("User_name", response.getString("User_name"));
							bundle.putString("User_headimage", response.getString("User_headimage"));
							bundle.putString("User_phone", response.getString("User_phone"));
							bundle.putString("User_password", response.getString("User_password"));
							bundle.putString("User_school", response.getString("User_school"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						intent.putExtra("userbundle", bundle);
						startActivity(intent);
						finish();
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Toast.makeText(Longin_wanji_Activity.this, "验证失败", 0)
						.show();
					}
				}, null);
		mQueue.add(jsonObjectPostRequest);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.longin_wanji_, menu);
		return true;
	}

}
