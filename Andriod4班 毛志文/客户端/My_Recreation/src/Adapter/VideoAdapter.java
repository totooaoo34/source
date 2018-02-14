package Adapter;


import httpUrl.News_Url;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zw.my_recreation.R;

import ben.MyNews;

import Adapter.MyAdapter.MyTask;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/// �������ӵ�������
public class VideoAdapter extends BaseAdapter{
   List<MyNews> mList;
   LayoutInflater lif;
   String sdcardPath;
   static Map<String,Bitmap> imageCeche = new HashMap<String, Bitmap>();
   
   public VideoAdapter(List<MyNews> list,Context context)
	{
		mList = list;
		lif = LayoutInflater.from(context);
		if(isSdcardExist())
	    {		sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath();
		}else
		{
		sdcardPath ="/data/data/com.zw.my_recreation/VideoImages";
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	//// ������������ǵ���ͼ�Ϳؼ�
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view == null)
		{
			view = lif.inflate(R.layout.video_gridview, null);
		}
		
		ImageView iv_icon  = (ImageView) view.findViewById(R.id.iv_VideoImages);
	    
		TextView tv_name =	(TextView) view.findViewById(R.id.tv_videoTel);
           
	    MyNews mb = mList.get(position);
		
		//iv_icon.setImageResource(R.drawable.laoding);
		
		tv_name.setText(mb.getVideoTel().substring(0,10)+"......");
	    //getVideoImagesCalendaerImagses
        String imageUrl = "http://192.168.1.101:8080/WebServerPlay/VideoImages"+"/"+mb.getVideoImages();	
          /// String imageUrl = News_Url.WEB_HOST+News_Url.WEB_IMAGEs+"/"+mb.getImages();
//		//��ͼƬ����һ��tag����ȷ�������ʾ�����
        iv_icon.setTag(imageUrl);
//		
//		//����ͼƬ֮ǰ�������жϣ�
    if(imageCeche.containsKey(imageUrl))
     {
 	     Bitmap bm = imageCeche.get(imageUrl);
	     iv_icon.setImageBitmap(bm);
	     
      }else{
			File file = new File(sdcardPath,mb.getVideoImages());
			if(file.exists())//�ж�һ���ֻ��洢�ڴ����Ƿ����
			{
				FileInputStream fis;
				try {
					fis = new FileInputStream(file);
					Bitmap bm = BitmapFactory.decodeStream(fis);
					iv_icon.setImageBitmap(bm);
					//����Ҫ��bm���뵽�ڴ滺����
					imageCeche.put(imageUrl, bm);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				//����һ������,ȥ����
				MyTask task = new MyTask(iv_icon);
				//ִ������
				task.execute(imageUrl,mb.getVideoImages());
			}
		
		}
		
	    
		return view;
	}
	class MyTask extends AsyncTask{
		ImageView miv;
		String imageURLConfirm;
		public MyTask(ImageView iv)
		{
			miv = iv;
		}
		//�൱��thread��run���� 
		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub
			
			URL url;
			Bitmap bm = null;
			try {
				url = new URL((String)arg0[0]);
				InputStream is =  url.openStream();
				imageURLConfirm =(String)arg0[0];
				//ģ������Ч��
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    //�����ص�ͼƬ��������sdcard
			    //����һ��file
			    File file = new File(sdcardPath,(String)arg0[1]);
			    //���ƵĹ���
			    FileOutputStream fos = new FileOutputStream(file);
			    
			    byte[] buffer = new byte[1024];
			    int len = -1;
			    while( (len = is.read(buffer)) !=-1 )
			    {
			    	fos.write(buffer, 0, len);
			    }
			    
			    fos.flush();
			    fos.close();
			    is.close();
			    
			    //Ҫ���¼���һ�Σ���Ϊis���α��Ѿ��ߵ����û�����ݶ�ȡ��
			    //���´�һ��
			    FileInputStream fis = new FileInputStream(file);
			    
			    //Bitmap,ͼƬ�Ķ�����
			    bm = BitmapFactory.decodeStream(fis);
			    fis.close();
			    //���Ѿ����ص�ͼƬ����
			    imageCeche.put((String)arg0[0], bm);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return bm;
		}
		
		//�൱��handle��handleMessage
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stu
			//����ui
			if(((String)miv.getTag()).equals(imageURLConfirm))
			{	
				miv.setImageBitmap((Bitmap)result);
			}
			
		}
	}
	
	
	public boolean isSdcardExist()
	{
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			return true;
		}else
		{
			return false;
		}
	}

}
