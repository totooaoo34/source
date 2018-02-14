package imagses;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
		/***
		 * ��������
		 * @author Administrator
		 *
		 */
public class MyViewPageAdapter extends PagerAdapter{
	List<View> viewList;
	public MyViewPageAdapter(List<View> viewList){
		this.viewList=viewList;
	}
	/***
	 * ��õ�ǰ������
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(viewList!=null){
			return viewList.size();
		}
		return 0;
	}
	/***
	 * �ж��Ƿ��ɶ������ɽ���
	 */
	@Override
	public boolean isViewFromObject(View view, Object obj) {
		// TODO Auto-generated method stub
		return view==obj;
	}
	/***
	 * ����positionλ�õĽ���
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager)container).removeView(viewList.get(position));
	}
	/***
	 * ��ʼ��positionλ�õĽ���
	 */
	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		((ViewPager)container).addView(viewList.get(position),0);
		return viewList.get(position);
	}
}
