package com.android.tenementclient.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.tenementclient.content.RootContent;
import com.android.tenementclient.content.UserContent;
import com.android.tenementclient.entity.User;

public class UserJSON {

	public User getUserJson(String content) {
		JSONObject root;
		User user=null;
		try {
			root = new JSONObject(content);
			JSONArray array = root.getJSONArray(RootContent.TAG_USER_ROOT);
			JSONObject data = (JSONObject) array.get(0);
			user = new User();
			user.setUid(data.getInt(UserContent.TAG_USER_UID));
			user.setUname(data.getString(UserContent.TAG_USER_UNAME));
			user.setUlogin(data.getString(UserContent.TAG_USER_ULOGIN));
			user.setUimg(data.getString(UserContent.TAG_USER_UIMG));
			user.setUpass(data.getString(UserContent.TAG_USER_UPASS));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
