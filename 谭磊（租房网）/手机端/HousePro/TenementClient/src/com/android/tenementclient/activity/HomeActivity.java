package com.android.tenementclient.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.tenementclient.widget.CircleFlowIndicator;
import com.android.tenementclient.R;
import com.android.tenementclient.adapte.GuessMsgAdapte;
import com.android.tenementclient.adapte.ImageAdapter;
import com.android.tenementclient.dialog.MyDialogExit;
import com.android.tenementclient.entity.GuessMsg;
import com.android.tenementclient.widget.ViewFlow;

/**
 * @author Administrator home主页
 * 
 */
public class HomeActivity extends Activity {

	GridView gv_home;
	ListView lv_home_in;
	View home_top_view;
	private ViewFlow viewFlow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		home_top_view = LayoutInflater.from(this).inflate(
				R.layout.activity_home_top, null);
		initGridHome();

		lv_home_in = (ListView) findViewById(R.id.lv_home_in);
		lv_home_in.setDividerHeight(0);
		lv_home_in.addHeaderView(home_top_view);
		initListHome();

		gv_home.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long postion) {
				// TODO Auto-generated method stub
				switch (arg2) {
				case 2:
					// 找租房
					Intent intent = new Intent(HomeActivity.this,
							FwxxActivity.class);
					startActivity(intent);
					break;
				}
			}
		});
		circleimage();
	}

	public void initGridHome() {
		String[] home_names = { "买新房", "买二手房", "找租房", "装修", "查房价", "我要买房",
				"我要出租", "更多" };
		int[] home_imgs = { R.drawable.home_xf, R.drawable.home_esf,
				R.drawable.home_zf, R.drawable.home_sfjj,
				R.drawable.home_pinggu, R.drawable.home_mf, R.drawable.home_cz,
				R.drawable.home_more };
		// 初始化GridView
		gv_home = (GridView) home_top_view.findViewById(R.id.gv_home);
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
		SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.grid_home,
				new String[] { "names", "imgs" }, new int[] { R.id.tv_home,
						R.id.iv_home });
		gv_home.setAdapter(sa);
	}

	private void initListHome() {
		GuessMsgAdapte adapter = new GuessMsgAdapte(this, guessMsgs());
		lv_home_in.setAdapter(adapter);
	}

	int[] imgs = { R.drawable.house01, R.drawable.house02, R.drawable.house03,
			R.drawable.house04, R.drawable.house05, R.drawable.house06, };
	String[] title = { "珠江丽城", "合能洋湖公馆", "澳海澜庭", "长房半岛蓝湾", "地铁口,学位房,紧邻月亮岛",
			"华丽家居套房" };
	String[] content = { "岳麓区中央大道与公交路交汇处东北角...", "岳麓区梅溪湖印月路...", "雨花区湘府东路..",
			"望城银星路999号..", "洋湖湿地公园北侧...", "猴子石大桥西行1000米...", };

	public List<GuessMsg> guessMsgs() {
		List<GuessMsg> list = new ArrayList<GuessMsg>();

		for (int i = 0; i < imgs.length; i++) {
			GuessMsg msg = new GuessMsg();
			msg.setGuessImg(imgs[i]);
			msg.setGuessTitle(title[i]);
			msg.setGuessContent(content[i]);
			list.add(msg);
		}
		return list;
	}
	
	void circleimage() {

		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new ImageAdapter(this));
		viewFlow.setmSideBuffer(2); // 实际图片张数， 我的ImageAdapter实际图片张数为3
		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setTimeSpan(2000);
		viewFlow.setSelection(0); // 设置初始位置
		viewFlow.startAutoFlowTimer(); // 启动自动播放
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Dialog dialog = new MyDialogExit(HomeActivity.this,
					R.style.MyDialog_style_NoTitle);
			dialog.show();
		}
		return super.onKeyDown(keyCode, event);
	}

}
