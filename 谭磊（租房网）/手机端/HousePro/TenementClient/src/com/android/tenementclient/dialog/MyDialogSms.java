package com.android.tenementclient.dialog;

import java.util.ArrayList;

import com.android.tenementclient.R;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Administrator ���Ͷ����Զ���Ի���
 */
public class MyDialogSms extends Dialog implements OnClickListener {

	Context mContext;
	/** �ֻ��� **/
	String phoneCode;
	/** �����ı� **/
	String smsContent;

	View view;

	Button btn_cancel_sms, btn_send_sms;
	EditText et_sms_content;
	TextView tv_fwxxbyid_telephone;

	public MyDialogSms(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	public MyDialogSms(Context context, int theme) {
		super(context, theme);
		this.mContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_sms);

		btn_cancel_sms = (Button) findViewById(R.id.btn_cancel_sms);
		btn_send_sms = (Button) findViewById(R.id.btn_send_sms);
		et_sms_content = (EditText) findViewById(R.id.et_sms_content);

		btn_cancel_sms.setOnClickListener(this);
		btn_send_sms.setOnClickListener(this);

		view = LayoutInflater.from(mContext).inflate(R.layout.list_fwxxbyid,
				null);

		tv_fwxxbyid_telephone = (TextView) view
				.findViewById(R.id.tv_fwxxbyid_telephone);

		phoneCode = tv_fwxxbyid_telephone.getText().toString();

		// ����ı�(������Ϣ)
		et_sms_content.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				if (et_sms_content.getText().toString().equals("������Ϣ")) {
					et_sms_content.setText("");
					et_sms_content.setTextColor(Color.BLACK);
					return true;
				} else {
					return false;
				}

			}
		});

		// ÿһ�θı�ʱ��ȡ���µ������ı�
		et_sms_content.addTextChangedListener(new TextWatcher() {

			// �ı��ı�
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
			}

			// ֮ǰ���ı��ı�
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			// ֮����ı��ı�
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				// ��ÿһ���ı��ı�֮�����»�ȡ���ı����������������
				smsContent = et_sms_content.getText().toString();
			}
		});

		// ȡ��
		btn_cancel_sms.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_cancel_sms
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				case MotionEvent.ACTION_UP:
					btn_cancel_sms
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_pressed);
					return false;
				case MotionEvent.ACTION_MOVE:
					btn_cancel_sms
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				}
				return false;
			}
		});

		// ����
		btn_send_sms.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					btn_send_sms
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				case MotionEvent.ACTION_UP:
					btn_send_sms
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_pressed);
					return false;
				case MotionEvent.ACTION_MOVE:
					btn_send_sms
							.setBackgroundResource(R.drawable.btn_style_alert_dialog_special_normal);
					return false;
				}
				return false;
			}
		});

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		// // ȡ��
		case R.id.btn_cancel_sms:
			this.dismiss();
			break;
		// ����
		case R.id.btn_send_sms:
			if (smsContent == null || "".equals(smsContent)) {
				Toast.makeText(mContext, "�������ݲ���Ϊ��", Toast.LENGTH_SHORT).show();
				break;
			} else {
				SmsManager smsManager = SmsManager.getDefault();
				Intent sentIntent = new Intent(
						"com.android.tenementclient.SMS_OK");
				// ���͹㲥
				PendingIntent sentPI = PendingIntent.getBroadcast(mContext, 0,//
						// �����߱��
						sentIntent, 0);
				// ��ֶ���
				ArrayList<String> list = smsManager.divideMessage(smsContent);
				for (int i = 0; i < list.size(); i++) {
					smsManager.sendTextMessage(phoneCode,// ��ϵ�˺���
							null,// �������ĺ���
							smsContent,// ��������
							sentPI,// �����Ƿ��ͳɹ�
							null);// ���ű��Է��յ�����ͼ
				}
				break;
			}
		}
	}

}
