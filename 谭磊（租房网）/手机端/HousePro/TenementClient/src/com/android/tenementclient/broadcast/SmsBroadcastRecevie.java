package com.android.tenementclient.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Administrator 短信发送成功提示广播
 */
public class SmsBroadcastRecevie extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		switch (getResultCode()) {
		case Activity.RESULT_OK:
			Toast.makeText(context, "短信发送成功！", Toast.LENGTH_SHORT).show();
			break;
		default:
			Toast.makeText(context, "短信发送失败！", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
