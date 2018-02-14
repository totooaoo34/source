package com.yuyi.ui;

import java.util.ArrayList;
import java.util.List;

import com.yuyi.adapter.SoftwareSetAdapter;
import com.yuyi.bean.SoftwareSetBean;
import com.yuyi.neikumanhua.R;
import com.yuyi.neikumanhua.R.layout;
import com.yuyi.neikumanhua.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SoftwareSetActivity extends Activity {
	
	ListView lv_routineSet,lv_meshSet,lv_downloadSet;
	List<SoftwareSetBean> routineList,meshList,downloadList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_softwareset);
		lv_routineSet = (ListView) findViewById(R.id.lv_routineSet);
		lv_routineSet.setSelector(new ColorDrawable(Color.YELLOW));
		
		lv_meshSet = (ListView) findViewById(R.id.lv_meshSet);
		lv_downloadSet = (ListView) findViewById(R.id.lv_dwonloadSet);
		
		routineList = new ArrayList<SoftwareSetBean>();
		
		routineList.add(new SoftwareSetBean("阅读模式设置","横/竖屏阅读模式及高级模式",R.drawable.icon_enter));
		routineList.add(new SoftwareSetBean("启动页设置","漫画推荐"));
		lv_routineSet.setAdapter(new SoftwareSetAdapter(this,routineList));
		
		meshList = new ArrayList<SoftwareSetBean>();
		meshList.add(new SoftwareSetBean("使用移动网络", "没有无线网络时自动使用移动网络", R.drawable.close));
		lv_meshSet.setAdapter(new SoftwareSetAdapter(this, meshList));
		
		downloadList = new ArrayList<SoftwareSetBean>();
		downloadList.add(new SoftwareSetBean("修改下载目录", "/mnt/sdacard/cartoon/DownloadCache/", R.drawable.icon_enter));
		downloadList.add(new SoftwareSetBean("清除在线缓存", "每天都会自动清理一次", R.drawable.icon_enter));
		downloadList.add(new SoftwareSetBean("扫描漫画", "扫描下载的漫画"));
		lv_downloadSet.setAdapter(new SoftwareSetAdapter(this, downloadList));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.software_set, menu);
		return true;
	}

}
