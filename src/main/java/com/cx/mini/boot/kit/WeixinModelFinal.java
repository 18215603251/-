package com.cx.mini.boot.kit;

/*
 * 存放常量
 */
public class WeixinModelFinal {    
	// 获取access_token的URL
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	// APPID
	public static String APPID = "wx0a4f0884aacadd53";
	
	// APPSECRET
	public static String APPSECRET = "2f85cb00be6c71e4156767112a7f9622";
	
	// 创建菜单的URL
	public static  String POST_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	// 消息类型
	public static String MSG_TEXT_YE ="text";
	public static String MSG_IMAGE_YE ="image";
	public static String MSG_VIDEO_YE ="video";
	public static String MSG_VOICE_YE ="voice";
	public static String MSG_SHORTVIDEO_YE ="shortvideo";
	public static String MSG_LOCATION_YE ="location";
	public static String MSG_EVENT_YE ="event";
}
