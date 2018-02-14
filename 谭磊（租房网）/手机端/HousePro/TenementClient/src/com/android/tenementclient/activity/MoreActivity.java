package com.android.tenementclient.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.tenementclient.R;
import com.android.tenementclient.adapte.MoreBaseAdapter;
import com.android.tenementclient.entity.GuessMsg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * @author Administrator home 更多
 *
 */
public class MoreActivity extends Activity {

	ListView lv_more_in;
	GridView gv_more_top;
	View more_top_more;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more);

		more_top_more = LayoutInflater.from(this).inflate(
				R.layout.activity_more_top, null);

		initGridHome();

		lv_more_in = (ListView) findViewById(R.id.lv_more_in);

		lv_more_in.setDividerHeight(0);
		lv_more_in.addHeaderView(more_top_more);
		initListMore();

	}

	public void initGridHome() {
		String[] home_names = { "房贷计算器", "税费计算器", "扫一扫" };
		int[] home_imgs = { R.drawable.loan_icon, R.drawable.tax_icon,
				R.drawable.scan_icon };
		// 初始化GridView
		gv_more_top = (GridView) more_top_more.findViewById(R.id.gv_more_top);
		// 初始化数据
		ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> rows;
		for (int i = 0; i < home_names.length; i++) {
			rows = new HashMap<String, Object>();
			rows.put("names", home_names[i]);
			rows.put("imgs", home_imgs[i]);
			data.add(rows);
		}
		// 初始化适配器
		SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.grid_more,
				new String[] { "names", "imgs" }, new int[] { R.id.tv_more_txt,
						R.id.iv_more_icon });
		gv_more_top.setAdapter(sa);
	}

	// 初始化more页面第一个listView
	private void initListMore() {
		MoreBaseAdapter adapter = new MoreBaseAdapter(this, guessMsgs01());
		lv_more_in.setAdapter(adapter);
	}

	int[] imgs01 = { R.drawable.more_update, R.drawable.icon_qingchuhuancun,
			R.drawable.more_about, R.drawable.icon_declare };

	String[] title01 = { "检查更新", "清除缓存", "关于我们", "免责声明" };

	public List<GuessMsg> guessMsgs01() {
		List<GuessMsg> list = new ArrayList<GuessMsg>();

		for (int i = 0; i < imgs01.length; i++) {
			GuessMsg msg = new GuessMsg();
			msg.setGuessImg(imgs01[i]);
			msg.setGuessTitle(title01[i]);
			list.add(msg);
		}
		return list;
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, TabHostActivity.class);
//		this.overridePendingTransition(R.anim.left_in, R.anim.left_out);
		startActivity(intent);
		this.finish();
	}
}
