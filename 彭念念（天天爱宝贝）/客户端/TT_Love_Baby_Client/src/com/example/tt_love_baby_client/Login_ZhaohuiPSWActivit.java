package com.example.tt_love_baby_client;

import com.thinkland.sdk.sms.SMSCaptcha;
import com.thinkland.sdk.util.BaseData.ResultCallBack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login_ZhaohuiPSWActivit extends Activity {
	ImageView iv_OK;
	ImageView iv_back;
	EditText ZH_shouji;
	SMSCaptcha smsCaptcha;
	Button bthuoqu;
	EditText yanzm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login__zhaohui_psw);
		smsCaptcha = SMSCaptcha.getInstance();
		
		iv_OK=(ImageView) findViewById(R.id.iv_zhaohui_OK);
		iv_back=(ImageView) findViewById(R.id.iv_zhaohui_back);
		ZH_shouji=(EditText) findViewById(R.id.et_ZH_shouji);
		bthuoqu=(Button) findViewById(R.id.bt_huoqu);
		yanzm=(EditText) findViewById(R.id.et_check);
		
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
				check();
			}
		});
		
	
	}
//获取验证码
	public void Huoqu(View v){
		
		smsCaptcha.sendCaptcha(ZH_shouji.getText().toString(), new ResultCallBack() {
			
			@Override
			public void onResult(int arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				if(arg0==0){
					Toast.makeText(Login_ZhaohuiPSWActivit.this, arg2.toString(), 0).show();
					System.out.println(arg2.toString());
				}else{
					Toast.makeText(Login_ZhaohuiPSWActivit.this, "获取失败", 0).show();
				}
			}
		});
	}
	
	//校验验证码
	public void check(){
		smsCaptcha.commitCaptcha(ZH_shouji.getText().toString(), yanzm.getText().toString(), new ResultCallBack() {
			
			@Override
			public void onResult(int arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				if(arg0==0){
					Intent intent=new Intent(Login_ZhaohuiPSWActivit.this,Longin_wanji_Activity.class);
					intent.putExtra("shouji", ZH_shouji.getText().toString());
					startActivity(intent);
				}else{
					Toast.makeText(Login_ZhaohuiPSWActivit.this, "验证失败", 0).show();
				}
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login__zhaohui_psw, menu);
		return true;
	}

}
