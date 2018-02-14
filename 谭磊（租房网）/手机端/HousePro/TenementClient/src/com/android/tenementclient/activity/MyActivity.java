package com.android.tenementclient.activity;

import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tenementclient.R;
import com.android.tenementclient.adapte.MyImageAdapter;
import com.android.tenementclient.application.VolleyApplication;
import com.android.tenementclient.content.WebContent;
import com.android.tenementclient.entity.User;
import com.android.tenementclient.json.UserJSON;
import com.android.tenementclient.widget.CircleFlowIndicator;
import com.android.tenementclient.widget.ViewFlow;
import com.android.tenementclient.zxing.activity.CaptureActivity;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * @author Administrator home �ҵ�
 * 
 */
public class MyActivity extends Activity {

	private Button btn_login;
	// ��¼
	private static final int REQUEST_CODE_LOGIN = 1;
	// ��ά��ɨ���¼
	private static final int REQUEST_QRCODE_LOGIN = 2;

	ProgressDialog dialog;
	Dialog dialog2;
	UserJSON userJSON;
	User user;
	public static ImageLoader imageLoader;// volley��ͼƬ������
	TextView tv_login_Struts;
	ImageView iv_user_img, iv_qrcode;
	RequestQueue mQueue;
	String sessionid;
	private ViewFlow viewFlow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		mQueue = VolleyApplication.getVolleyApplication().mQueue;

		btn_login = (Button) findViewById(R.id.diy_login);
		tv_login_Struts = (TextView) findViewById(R.id.tv_login_Struts);
		iv_user_img = (ImageView) findViewById(R.id.iv_user_img);
		iv_qrcode = (ImageView) findViewById(R.id.iv_qrcode);
		// ���������¼��ʽ
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text = btn_login.getText().toString();
				if (text.equals("ע��")) {
					Bitmap bitmap = BitmapFactory.decodeResource(
							getResources(), R.drawable.video_connect_icon);
					Bitmap output = getRoundedCornerBitmap(bitmap, 2);
					iv_user_img.setImageBitmap(output);
					tv_login_Struts.setText("δ��¼");
					btn_login.setText("�� ¼");
				} else if (text.equals("�� ¼")) {
					// ȥ��¼
					Intent intent = new Intent(MyActivity.this,
							LoginActivity.class);
					startActivityForResult(intent, REQUEST_CODE_LOGIN);
				}
			}

		});
		// ɨ���ά���¼��ʽ
		iv_qrcode.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openCameraIntent = new Intent(MyActivity.this,
						CaptureActivity.class);
				startActivityForResult(openCameraIntent, REQUEST_QRCODE_LOGIN);
			}
		});
		// ����ViewFlow
		circleimage();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case REQUEST_CODE_LOGIN:
			if (resultCode == RESULT_OK) {
				String uname = data.getStringExtra("uname");
				String uimg = data.getStringExtra("uimg");
				tv_login_Struts.setText(uname);
				btn_login.setText("ע��");
				// VolleyͼƬ������
				imageLoader = VolleyApplication.getVolleyApplication().mImageLoader;
				imageLoader.get(WebContent.HOST + WebContent.USER_IMG + uimg,
						ImageLoader.getImageListener(iv_user_img,
								R.drawable.icon_loading,// ��������ʾ��ͼƬ
								R.drawable.pic_loading_offline));// ʧ�ܵ�ͼƬ
			}
			break;
		case REQUEST_QRCODE_LOGIN:
			if (resultCode == RESULT_OK) {
				sessionid = data.getStringExtra("result");
				sendUserLogin();
			}
			break;
		}
	}

	public void sendUserLogin() {
		String url = WebContent.HOST + WebContent.ACTION_USER_QRCODE_LOGIN
				+ "?sessionid=" + sessionid;
		JsonObjectRequest jsonRequest = new JsonObjectRequest(url, null,
				new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						userJSON = new UserJSON();
						user = userJSON.getUserJson(response.toString());
						tv_login_Struts.setText(user.getUname());
						btn_login.setText("ע��");

						// VolleyͼƬ������
						imageLoader = VolleyApplication.getVolleyApplication().mImageLoader;
						imageLoader.get(WebContent.HOST + WebContent.USER_IMG
								+ user.getUimg(), ImageLoader.getImageListener(
								iv_user_img, R.drawable.icon_loading,// ��������ʾ��ͼƬ
								R.drawable.video_connect_icon));// ʧ�ܵ�ͼƬ
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						Toast.makeText(MyActivity.this,
								"������Ϣ��" + error.getMessage(),
								Toast.LENGTH_SHORT).show();
					}
				});
		mQueue.add(jsonRequest);
	}

	/**
	 * ��ͼƬ��ȡΪԲ��ͼƬ
	 * 
	 * @param bitmap
	 *            ԭͼƬ
	 * @param ratio
	 *            ��ȡ�����������8����Բ�ǰ뾶�ǿ�ߵ�1/8�������2������Բ��ͼƬ
	 * @return Բ�Ǿ���ͼƬ
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float ratio) {

		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		canvas.drawRoundRect(rectF, bitmap.getWidth() / ratio,
				bitmap.getHeight() / ratio, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

	void circleimage() {
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new MyImageAdapter(this));
		viewFlow.setmSideBuffer(3); // ʵ��ͼƬ������ �ҵ�ImageAdapterʵ��ͼƬ����Ϊ3
		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(2000);
		viewFlow.setSelection(0); // ���ó�ʼλ��
		viewFlow.startAutoFlowTimer(); // �����Զ�����
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, TabHostActivity.class);
		// this.overridePendingTransition(R.anim.left_in, R.anim.left_out);
		startActivity(intent);
		this.finish();
	}
}
