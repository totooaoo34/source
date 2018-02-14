package com.zw.my_recreation;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ben.MyNews;


      /// ����json��
public class MovieManager {
	//��ȡ��Ӱ������
	static public List<MyNews> getMovieList(String data)
	{
		List<MyNews> list = new ArrayList<MyNews>();
		try {
			
			JSONObject root = new JSONObject(data);
			JSONArray array =root.getJSONArray("list");
			for(int i=0;i<array.length();i++)
			{
				MyNews mb = new MyNews();
				JSONObject movie = array.getJSONObject(i);
				mb.setName(movie.getString("name"));
				mb.setImages(movie.getString("imageUrl"));
				mb.setMoviePath(movie.getString("movie"));
				////CalendaerImagses CalendaerTel
				mb.setCalendaerImagses(movie.getString("Images"));//// ������ʷ��ͼ
				mb.setCalendaerTel(movie.getString("tel"));/// ������ʷ�ĵص�
				mb.setCalendaerName(movie.getString("CaName"));/// ������ʷ������
				mb.setVideoImages(movie.getString("videoimages"));/// ������Ƶ��ͼƬ
				mb.setVideoTel(movie.getString("videotel"));///������Ƶ������
				
				list.add(mb);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
