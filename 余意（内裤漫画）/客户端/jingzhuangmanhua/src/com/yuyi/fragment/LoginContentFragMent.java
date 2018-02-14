package com.yuyi.fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.ab.util.AbDialogUtil;
import com.yuyi.contants.Contants;
import com.yuyi.neikumanhua.R;
import com.yuyi.ui.DialogActivity;
import com.yuyi.ui.HomeActivity;
import com.yuyi.ui.LoginActivity;
import com.yuyi.ui.SetActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginContentFragMent extends Fragment {
	String tag;
	TextView tv_login_fragment, tv_sina,userPwd_zhuce,userName_zhuce,userName_login,userPwd_login;
	ListView lv_shoucang,lv_lishi;
	AttributeSet attr;
	View v,login_dialog_view,zhuce_dialog_view;
	
	Button bto_login,bto_dialog_zhuceA,bto_dialog_zhuceB,bto_dialog_loginA;
	
	LinearLayout layout_shoucang_list;
	
	SharedPreferences preferences;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		login_dialog_view = LayoutInflater.from(getActivity()).inflate(R.layout.login, null);
		
		bto_dialog_loginA = (Button) login_dialog_view.findViewById(R.id.loginBtn);
		
		zhuce_dialog_view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_zhuce, null);
		userPwd_login = (TextView) zhuce_dialog_view.findViewById(R.id.userPwd);
		
		Bundle bundle = getArguments();
		tag = (String) bundle.get("tag");
		if ("0".equals(tag)) {	
			List<String> scList = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				scList.add("收藏" + i);
			}
			v = inflater.inflate(R.layout.activity_shoucang, null);
			bto_login = (Button) v.findViewById(R.id.bto_login);
			lv_shoucang = (ListView) v.findViewById(R.id.lv_shoucang);
			lv_shoucang.setAdapter(new MyAdpter(getActivity(), scList));
			
			bto_login.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					bto_dialog_zhuceA = (Button) login_dialog_view.findViewById(R.id.registerBtn);
					//第一个dialog登录监听
					bto_dialog_loginA.setOnClickListener(new OnClickListener() {
						StringBuffer sb;
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							userName_login = (TextView) login_dialog_view.findViewById(R.id.userName);
							userPwd_login = (TextView) login_dialog_view.findViewById(R.id.userPwdLogin);
							preferences = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
							//Toast.makeText(getActivity(), Contants.sb, 0).show();
							Thread thread = new Thread(){
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									if(preferences.getBoolean("islogin", false)==true&&!preferences.getString("sessionid","").equals(Contants.sb)){//登录成功
										Intent intent = new Intent();
										intent.setClass(getActivity(),HomeActivity.class);
										startActivity(intent);
										
										//成功登录过跳转到主页面
									}else{
										
										HttpClient httpclient = new DefaultHttpClient();
										HttpPost request = new HttpPost(Contants.ComicHttpUrl+"comicAction!userLogin");
										
										StringEntity se;
										try {
											se = new StringEntity(userName_login.getText().toString()+"/"+userPwd_login.getText().toString(), "utf-8");
											
											request.setEntity(se);
											
											try {
												HttpResponse response = httpclient.execute(request);
												//可以通过response拿到服务端out流写过来的数据
												HttpEntity entity = response.getEntity();
												InputStream is = entity.getContent();
												//将字节流转换为字符流
												BufferedReader br = new BufferedReader(new InputStreamReader(is));
												
												String line;
												//sb = new StringBuffer();
												//将数据读取出来
												while((line=br.readLine())!=null){
													Contants.sb.append(line);
												}
												Log.d("sessionid", Contants.sb.toString());
												
												if(!"".equals(Contants.sb.toString())){
													Editor edit = preferences.edit();
													edit.putBoolean("islogin", true);
													edit.putString("sessionid", Contants.sb.toString());
													edit.commit();
													edit.apply();
													Intent intent = new Intent();
													intent.setClass(getActivity(),HomeActivity.class);
													startActivity(intent);
												}
												
											} catch (ClientProtocolException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
										} catch (UnsupportedEncodingException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									
								}
							};
							thread.start();
						}
					});
					bto_dialog_zhuceA.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub							
							bto_dialog_zhuceB = (Button) zhuce_dialog_view.findViewById(R.id.registerBtn);
							userName_zhuce = (TextView) zhuce_dialog_view.findViewById(R.id.userName);
							userPwd_zhuce = (TextView) zhuce_dialog_view.findViewById(R.id.userPwd);
							AbDialogUtil.showFullScreenDialog(zhuce_dialog_view);
							bto_dialog_zhuceB.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									Toast.makeText(getActivity(), userName_zhuce.getText().toString()+"---"+userPwd_zhuce.getText().toString(), 0).show();
									Thread thread = new Thread(){
										@Override
										public void run() {
											// TODO Auto-generated method stub
											//发射装置
											HttpClient httpcliect = new DefaultHttpClient();
											//发射内容
											HttpPost request = new HttpPost(Contants.ComicHttpUrl+"comicAction!postzhucexinxi");
											StringEntity se;
											try {
												se = new StringEntity(userName_zhuce.getText().toString()+"/"+userPwd_zhuce.getText().toString(),"utf-8");
												
												request.setEntity(se);
												try {
													HttpResponse response = httpcliect.execute(request);
												} catch (ClientProtocolException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											} catch (UnsupportedEncodingException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									};
									thread.start();
									Intent intent = new Intent();
									intent.setClass(getActivity(),HomeActivity.class);
									startActivity(intent);
							}
							});
						}
					});
					AbDialogUtil.showFullScreenDialog(login_dialog_view);
				}
			});
			
			
		} else {
			List<String> lsList = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				lsList.add("历史" + i);
			}
			v = inflater.inflate(R.layout.activity_lishi, null);
			lv_lishi = (ListView) v.findViewById(R.id.lv_lishi);
			lv_lishi.setAdapter(new MyAdpter(getActivity(), lsList));
			
		}
		return v;
	}

	class MyAdpter extends BaseAdapter{
		public Context context;
		public List<String> list;
		
		public MyAdpter(Context context, List<String> list) {
			super();
			this.context = context;
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(view ==null){
				view = LayoutInflater.from(context).inflate(R.layout.activity_list_item, null);
			}
			TextView tv = (TextView) view.findViewById(R.id.tv_freeName);
			tv.setText(list.get(position));
			return view;
		}
	}
	
}
