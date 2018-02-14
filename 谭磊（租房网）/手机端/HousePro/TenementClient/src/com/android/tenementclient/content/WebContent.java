package com.android.tenementclient.content;

/**
 * @author Administrator 请求服务器端的URL
 * 
 */
public class WebContent {

	public final static String HOST = "http://192.168.100.2:8080/Tenement";
//	 public final static String HOST = "http://192.168.1.105:8080/Tenement";
	// 查询所有房屋信息
	public final static String ACTION = "/fwxxAction!inntFwxxJson";
	// 查询当个房屋信息详情
	public final static String ACTION_FWXX_BYID = "/fwxxAction!inntFwxxByIdJson";
	// 房屋照片
	public final static String HOUSE_IMG = "/house_img/";
	// 用户照片
	public final static String USER_IMG = "/user_img/";
	
	// 二维码扫描手机端用户登录验证
	public final static String ACTION_USER_QRCODE_LOGIN = "/userAction!inntQRCodeLogin";
	// 手机端普通登录验证
	public final static String ACTION_USER_LOGIN = "/userAction!inntClienLogin";

}
