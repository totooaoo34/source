package com.android.tenementclient.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Administrator ���ŷ��ͳɹ���ʾ�㲥
 */
public class SmsBroadcastRecevie extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		switch (getResultCode()) {
		case Activity.RESULT_OK:
			Toast.makeText(context, "���ŷ��ͳɹ���", Toast.LENGTH_SHORT).show();
			break;
		default:
			Toast.makeText(context, "���ŷ���ʧ�ܣ�", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
