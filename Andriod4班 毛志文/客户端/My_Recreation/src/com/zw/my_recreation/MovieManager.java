package com.zw.my_recreation;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ben.MyNews;


      /// 解析json类
public class MovieManager {
	//获取电影的数据
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
				mb.setCalendaerImagses(movie.getString("Images"));//// 艺术历史的图
				mb.setCalendaerTel(movie.getString("tel"));/// 艺术历史的地点
				mb.setCalendaerName(movie.getString("CaName"));/// 艺术历史的名称
				mb.setVideoImages(movie.getString("videoimages"));/// 艺术视频的图片
				mb.setVideoTel(movie.getString("videotel"));///艺术视频的名称
				
				list.add(mb);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
