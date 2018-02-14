package com.json;

import com.content.JsonNameContent;
import com.content.UserContent;
import com.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Administrator ������ϢJSON����
 * 
 */
public class UserJSON {

	// ��¼��֤�û�
	public String loginJson(User user) {
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject value = new JSONObject();
		
		value.put(UserContent.TAG_USER_UID, user.getUid());
		value.put(UserContent.TAG_USER_UNAME, user.getUname());//�˻���
		value.put(UserContent.TAG_USER_ULOGIN, user.getUlogin());//��¼��
		value.put(UserContent.TAG_USER_UIMG, user.getUimg());
		value.put(UserContent.TAG_USER_UPASS, user.getUpass());
		array.add(value);
		
		root.put(JsonNameContent.TAG_USER_ROOT, array);
		return root.toString();
	}

}
