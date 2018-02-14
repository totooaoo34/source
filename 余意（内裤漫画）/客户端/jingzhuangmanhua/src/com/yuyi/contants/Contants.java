package com.yuyi.contants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class Contants {
	
	public static final String  ComicHttpUrl = "http://192.168.2.69:8080/NeiKuServer/";//漫画获取http路径
	
	public static int comicPage;//选择当前漫画第几页
	
	public static List<String> comicUrlList;//漫画网络路径集合
	
	public static int httpUrlIndexChecked;//选中下载路劲
	
	public static int downLoaditem;//选中下载item
	
	public static List<String> httpUrlIndexCheckedList = new ArrayList<String>();//选中下载集合	
	
	public static Boolean istag = false;
	
	public static StringBuffer sb = new StringBuffer();
	
}
