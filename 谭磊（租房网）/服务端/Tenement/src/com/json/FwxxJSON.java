package com.json;

import java.util.List;

import com.content.FwlxContent;
import com.content.FwxxContent;
import com.content.JdContent;
import com.content.JsonNameContent;
import com.content.QxContent;
import com.entity.Fwlx;
import com.entity.Fwxx;
import com.entity.Jd;
import com.entity.Qx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Administrator 房屋信息JSON解析
 * 
 */
public class FwxxJSON {

	// 房屋信息查询
	public String inntJson(List<Fwxx> fwxxs) {
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < fwxxs.size(); i++) {
			JSONObject value = new JSONObject();
			value.put(FwxxContent.TAG_FWXX_FWID, fwxxs.get(i).getFwid());
			value.put(FwxxContent.TAG_FWXX_TITLE, fwxxs.get(i).getTitle());
			value.put(FwxxContent.TAG_FWXX_SHI, fwxxs.get(i).getShi());
			value.put(FwxxContent.TAG_FWXX_TING, fwxxs.get(i).getTing());
			value.put(FwxxContent.TAG_FWXX_ZJ, fwxxs.get(i).getZj());
			value.put(FwxxContent.TAG_FWXX_DATE, fwxxs.get(i).getDate()
					.substring(0, 10));
			value.put(FwxxContent.TAG_FWXX_IMG, fwxxs.get(i).getImg());
			value.put(FwxxContent.TAG_FWXX_TELEPHONE, fwxxs.get(i)
					.getTelephone());
			array.add(value);
		}
		root.put(JsonNameContent.TAG_FWXX_ROOT, array);
		return root.toString();
	}

	// 单个房屋信息查询
	public String fwxxByIdJson(Fwxx fwxx, Fwlx fwlx, Jd jd, Qx qx) {
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject value = new JSONObject();
		value.put(FwxxContent.TAG_FWXX_TITLE, fwxx.getTitle());
		value.put(FwxxContent.TAG_FWXX_IMG, fwxx.getImg());
		value.put(FwlxContent.TAG_FWLX_LX, fwlx.getFwlx());
		value.put(FwxxContent.TAG_FWXX_SHI, fwxx.getShi());
		value.put(FwxxContent.TAG_FWXX_TING, fwxx.getTing());
		value.put(FwxxContent.TAG_FWXX_ZJ, fwxx.getZj());
		value.put(QxContent.TAG_QX_QX, qx.getQx());
		value.put(JdContent.TAG_JD_JD, jd.getJd());
		value.put(FwxxContent.TAG_FWXX_DATE, fwxx.getDate().substring(0, 16));
		value.put(FwxxContent.TAG_FWXX_FWXX, fwxx.getFwxx());
		value.put(FwxxContent.TAG_FWXX_LXR, fwxx.getLxr());
		value.put(FwxxContent.TAG_FWXX_TELEPHONE, fwxx.getTelephone());
		array.add(value);
		root.put(JsonNameContent.TAG_FWXX_BYID_ROOT, array);
		return root.toString();
	}
}
