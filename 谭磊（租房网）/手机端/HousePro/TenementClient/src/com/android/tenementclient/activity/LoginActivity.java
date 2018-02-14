package com.android.tenementclient.activity;

import org.json.JSONObject;

import com.android.tenementclient.R;
import com.android.tenementclient.application.VolleyApplication;
import com.android.tenementclient.content.WebContent;
import com.android.tenementclient.dialog.MyDialogLoading;
import com.android.tenementclient.entity.User;
import com.android.tenementclient.json.UserJSON;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	Button btn_login;
	EditText et_login_ulogin, et_login_upass;
	RequestQueue mQueue;
	String ulogin;
	String upass;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mQueue = VolleyApplication.getVolleyApplication().mQueue;

		btn_login = (Button) findViewById(R.id.btn_login);
		et_login_ulogin = (EditText) findViewById(R.id.et_login_ulogin);
		et_login_upass = (EditText) findViewById(R.id.et_login_upass);

		btn_login.setOnClickListener(this);

		btn_login.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				switch (arg1.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_login.setBackgroundResource(R.drawable.btn_blue_s);
					break;
				case MotionEvent.ACTION_MOVE:
					btn_login.setBackgroundResource(R.drawable.btn_blue_s);
					break;
				case MotionEvent.ACTION_UP:
					btn_login.setBackgroundResource(R.drawable.btn_blue_n);
					break;
				}
				return false;
			}
		});
	}

	/**
	 *  ‰»ÎøÚ ‰»Î∆’Õ®µ«¬º
	 */
	public void sendFwxxMessage() {
		if (ulogin == null || ulogin.equals("")) {
			Toast.makeText(this, "«Î ‰»Î’À∫≈...", Toast.LENGTH_SHORT).show();
			return;
		} else if (upass == null || upass.equals("")) {
			Toast.makeText(this, "«Î ‰»Î√‹¬Î...", Toast.LENGTH_SHORT).show();
			return;
		}
		final ProgressDialog dialog = new MyDialogLoading(this,
				R.style.MyDialog_style_NoTitle);
		dialog.show();
		String url = WebContent.HOST + WebContent.ACTION_USER_LOGIN
				+ "?ulogin=" + ulogin + "&upass=" + upass;
		JsonObjectRequest objectRequest = new JsonObjectRequest(url, null,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						UserJSON userJSON = new UserJSON();
						User u = userJSON.getUserJson(response.toString());
						dialog.dismiss();
						intent = getIntent();
						if (u != null) {
							intent.putExtra("uname", u.getUname());
							intent.putExtra("uimg", u.getUimg());
							setResult(RESULT_OK, intent);
							finish();
						}
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						Toast.makeText(LoginActivity.this,
								"¥ÌŒÛÃ· æ£∫" + error.toString(), Toast.LENGTH_SHORT)
								.show();
					}
				});
		mQueue.add(objectRequest);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		// µ«¬º
		case R.id.btn_login:
			ulogin = et_login_ulogin.getText().toString();
			upass = et_login_upass.getText().toString();
			sendFwxxMessage();
			break;
		}
	}
}
