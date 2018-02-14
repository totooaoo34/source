package com.android.tenementclient.activity;

import java.util.List;

import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tenementclient.R;
import com.android.tenementclient.adapte.FwxxAdapter;
import com.android.tenementclient.application.VolleyApplication;
import com.android.tenementclient.content.WebContent;
import com.android.tenementclient.entity.Fwxx;
import com.android.tenementclient.json.FwxxJSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * @author Administrator 所有房屋信息
 * 
 */
public class FwxxActivity extends Activity {

	ListView lv_fwxx;
	List<Fwxx> fwxxs;
	ProgressDialog dialog;
	Dialog dialog2;
	RequestQueue mQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fwxx);
		mQueue = VolleyApplication.getVolleyApplication().mQueue;
		lv_fwxx = (ListView) findViewById(R.id.lv_fwxx);
		// 服务器上房屋信息
		sendFwxxMessage();
		lv_fwxx.setOnItemClickListener(lv_fwxxClick);
	}

	private OnItemClickListener lv_fwxxClick = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			TextView tv_fwid = (TextView) arg1.findViewById(R.id.tv_fwid);
			String str = tv_fwid.getText().toString();
			Intent intent = new Intent(FwxxActivity.this,
					FwxxByIdActivity.class);
			// 通过bundle传递房屋ID号
			Bundle bundle = new Bundle();
			bundle.putString("fwid", str);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	};

	FwxxJSON fwxxJSON;

	public void sendFwxxMessage() {
		String url = WebContent.HOST + WebContent.ACTION;
		JsonObjectRequest jsonRequest = new JsonObjectRequest(url, null,
				new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						fwxxJSON = new FwxxJSON();
						List<Fwxx> fwxxs = fwxxJSON.getFwxxJsonList(response
								.toString());
						lv_fwxx.setAdapter(new FwxxAdapter(fwxxs,
								FwxxActivity.this, mQueue));
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Toast.makeText(FwxxActivity.this,
								"错误信息：" + error.getMessage(), Toast.LENGTH_SHORT)
								.show();
					}
				});
		mQueue.add(jsonRequest);
	}
}
