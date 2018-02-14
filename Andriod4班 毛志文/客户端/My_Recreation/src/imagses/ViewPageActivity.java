package imagses;

import java.util.ArrayList;
import java.util.List;

import com.zw.my_recreation.News_Activity;
import com.zw.my_recreation.R;


 
 


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
/***
 * 滑动加载界面activity
 * @author 聂溁
 *
 */
public class ViewPageActivity extends Activity implements OnClickListener,OnPageChangeListener{
	//ListView lv=new ListView(this);
	private ViewPager viewPager;
	private List<View> viewList;
	/**引导图片资源*/
	private static final int[] draws=new int[]{
		R.layout.view1,
		R.layout.view2,
		R.layout.view3,
		};
	
	/**底部小点图片*/
	private ImageView[] points; 
	/** 选中的位置 */
	private int currentIndex;
	MyViewPageAdapter pagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_page);
		initView();
		initData();
	}
	/**初始化控件*/
	private void initView(){
		viewPager=(ViewPager)findViewById(R.id.viewpager);
		viewList=new ArrayList<View>();
		pagerAdapter=new MyViewPageAdapter(viewList);
	}
	/**初始化数据*/
	private void initData(){
		LayoutInflater mLi = LayoutInflater.from(this);
		for (int i = 0; i < draws.length; i++) { 
//			View view=mLi.inflate(draws[i], null);
			viewList.add(mLi.inflate(draws[i], null));
			viewPager.setAdapter(pagerAdapter);
			viewPager.setOnPageChangeListener(this);
			initPoint();
		}
	}
	private void initPoint() {
		// TODO Auto-generated method stub
		LinearLayout ll=(LinearLayout)this.findViewById(R.id.startly);
		
		points=new ImageView[draws.length];
		for (int i = 0; i < points.length; i++) {
			points[i]=(ImageView) ll.getChildAt(i);
			///te.setText("sssss");
			TextView te=(TextView) findViewById(R.id.textView1);
			points[i].setEnabled(true);
			points[i].setTag(i);
			points[i].setOnClickListener(this);
		}
		currentIndex=0;
		points[currentIndex].setEnabled(false);
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	public void btOpen(View view){
		Intent intent=new Intent(this,News_Activity.class);
		startActivity(intent);
		this.finish();
	}
	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		setCurrentDot(position);
	}
	private void setCurrentView(int position){
		if(position<0||position>=draws.length){
			return;
		}
		viewPager.setCurrentItem(position);
	}
	private void setCurrentDot(int position){
		if(position<0||position>=draws.length||position==currentIndex){
			return;
		}
		points[position].setEnabled(false);
		points[currentIndex].setEnabled(true);
		currentIndex=position;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int position=(Integer) v.getTag();
		setCurrentView(position);
		setCurrentDot(position);
	}
}
