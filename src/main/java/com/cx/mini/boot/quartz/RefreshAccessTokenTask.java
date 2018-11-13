package com.cx.mini.boot.quartz;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.cx.mini.boot.kit.AccessTokenContent;
import com.cx.mini.boot.kit.WeixinModelFinal;
import com.cx.minip.boot.domain.AccessToken;

import net.sf.json.JSONObject;

public class RefreshAccessTokenTask {

	// 刷新access_token
	public static void refrashAccessToken() {
		// 创建请求对象 (请求发起客户端)
		CloseableHttpClient client = HttpClients.createDefault();

		// 组合url
		String url = WeixinModelFinal.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinModelFinal.APPID);
		url = url.replaceAll("APPSECRET", WeixinModelFinal.APPSECRET);

		// 创建get请求, 参数目的地址(即向哪发送请求), 向这个要求的地址发get请求
		HttpGet get = new HttpGet(url);

		CloseableHttpResponse res = null;
		try {
			// 执行get请求
			res = client.execute(get);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (res != null) {
			// 获取响应状态栏, 再从状态栏中获取状态代码
			int statusCode = res.getStatusLine().getStatusCode();
			//
			if (statusCode >= 200 && statusCode < 300) {

				// 返回执行后返回的所有东西
				HttpEntity entity = res.getEntity();
				try {
					// 获取内容, 这个就是access_token
					String content = EntityUtils.toString(entity);

					// 可以将access_token封装一于java对象中, JSONObject类代表json
					JSONObject object = JSONObject.fromObject(content);
					AccessToken at = (AccessToken) JSONObject.toBean(object, AccessToken.class);
					// System.out.println(at.getAccess_token());
					// System.out.println(at.getExpires_in());
					// 利用静态属性将程序运行得到的acess_token保存起来
					AccessTokenContent.setAccess_token(at.getAccess_token());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("没有执行");
		}

	}
}
