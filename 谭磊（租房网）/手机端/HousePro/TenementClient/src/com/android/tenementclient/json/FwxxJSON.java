package com.android.tenementclient.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.android.tenementclient.content.FwlxContent;
import com.android.tenementclient.content.FwxxContent;
import com.android.tenementclient.content.JdContent;
import com.android.tenementclient.content.QxContent;
import com.android.tenementclient.content.RootContent;
import com.android.tenementclient.entity.Fwxx;
import com.android.tenementclient.entity.FwxxById;

/**
 * @author Administrator 房屋信息JSON解析
 * 
 */
public class FwxxJSON {

	/**
	 * 解析查询所有房屋信息json
	 * 
	 * @param content
	 *            上下文
	 * @return 房屋信息集合
	 */
	public List<Fwxx> getFwxxJsonList(String content) {
		List<Fwxx> list = new ArrayList<Fwxx>();
		JSONObject root;
		try {
			root = new JSONObject(content);
			JSONArray array = root.getJSONArray(RootContent.TAG_FWXX_ROOT);
			Log.d("show",  "array   "+array.toString());
			for (int i = 0; i < array.length(); i++) {
				JSONObject data = (JSONObject) array.get(i);
				Fwxx fwxx = new Fwxx();
				fwxx.setFwid(data.getInt(FwxxContent.TAG_FWXX_FWID));
				fwxx.setTitle(data.getString(FwxxContent.TAG_FWXX_TITLE));
				fwxx.setShi(data.getInt(FwxxContent.TAG_FWXX_SHI));
				fwxx.setTing(data.getInt(FwxxContent.TAG_FWXX_TING));
				fwxx.setZj(data.getInt(FwxxContent.TAG_FWXX_ZJ));
				fwxx.setDate(data.getString(FwxxContent.TAG_FWXX_DATE));
				fwxx.setImg(data.getString(FwxxContent.TAG_FWXX_IMG));
				fwxx.setTelephone(data
						.getString(FwxxContent.TAG_FWXX_TELEPHONE));
				list.add(fwxx);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析查询当个详情信息json
	 * 
	 * @param content
	 *            上下文
	 * @return 房屋信息单个详情对象
	 */
	public FwxxById getFwxxByIdJson(String content) {
		JSONObject root;
		FwxxById fwxx = new FwxxById();
		try {
			root = new JSONObject(content);
			JSONArray array = root.getJSONArray(RootContent.TAG_FWXX_BYID_ROOT);
			for (int i = 0; i < array.length(); i++) {
				JSONObject data = (JSONObject) array.get(i);
				fwxx.setImg(data.getString(FwxxContent.TAG_FWXX_IMG));
				fwxx.setTitle(data.getString(FwxxContent.TAG_FWXX_TITLE));
				fwxx.setFwlx(data.getString(FwlxContent.TAG_FWLX_LX));
				fwxx.setShi(data.getInt(FwxxContent.TAG_FWXX_SHI));
				fwxx.setTing(data.getInt(FwxxContent.TAG_FWXX_TING));
				fwxx.setZj(data.getInt(FwxxContent.TAG_FWXX_ZJ));
				fwxx.setQx(data.getString(QxContent.TAG_QX_QX));
				fwxx.setJd(data.getString(JdContent.TAG_JD_JD));
				fwxx.setDate(data.getString(FwxxContent.TAG_FWXX_DATE));
				fwxx.setFwxx(data.getString(FwxxContent.TAG_FWXX_FWXX));
				fwxx.setLxr(data.getString(FwxxContent.TAG_FWXX_LXR));
				fwxx.setTelephone(data
						.getString(FwxxContent.TAG_FWXX_TELEPHONE));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fwxx;
	}

}
