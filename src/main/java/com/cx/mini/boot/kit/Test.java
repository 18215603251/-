package com.cx.mini.boot.kit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.cx.mini.boot.quartz.RefreshAccessTokenTask;
import com.cx.minip.boot.domain.AccessToken;
import com.cx.minip.boot.domain.WeixinMenu;

import net.sf.json.JSONObject;

public class Test {

	@org.junit.Test
	public void httpTest() {
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
					AccessToken accessToken = (AccessToken) JSONObject.toBean(object, AccessToken.class);

					System.out.println("执行成功: " + content);
					System.out.println("accessToken : " + accessToken.getAccess_token());
					System.out.println("expires_in : " + accessToken.getExpires_in());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("没有执行");
		}

	}

	@org.junit.Test
	public void testMenu() {
		// 创建主菜单
		List<WeixinMenu> menu_main = new ArrayList<WeixinMenu>();

		// 创建菜单1
		WeixinMenu menu1 = new WeixinMenu();
		menu1.setId(1);
		menu1.setName("学习网站");
		menu1.setType("view");
		menu1.setUrl("https://sina.cn");

		// 将菜单1加入
		menu_main.add(menu1);

		// 再构建建菜单2
		WeixinMenu menu2 = new WeixinMenu();
		menu2.setName("测试资源");

		List<WeixinMenu> menu_list2 = new ArrayList<WeixinMenu>();
		WeixinMenu menu = new WeixinMenu();
		menu.setId(2);
		menu.setName("事件测试");
		menu.setType("click");
		menu.setKey("A001");
		menu_list2.add(menu);

		menu = new WeixinMenu();
		menu.setId(3);
		menu.setName("扫描测试");
		menu.setType("click");
		menu.setKey("A002");
		menu_list2.add(menu);

		menu2.setSub_button(menu_list2);

		// 将菜单2加入
		menu_main.add(menu2);

		// 构建map
		Map<String, List<WeixinMenu>> map = new HashMap<String, List<WeixinMenu>>();
		map.put("button", menu_main);

		// 将map转为json串
		JSONObject json = JSONObject.fromObject(map);	//将java对象转换为json对象
		String jsonString = json.toString();			//将json对象转换为字符串
		
		/*如下使用post提交创建菜单*/
		// 创建请求客户端
		CloseableHttpClient client = HttpClients.createDefault();
		
		RefreshAccessTokenTask.refrashAccessToken();
		String url = WeixinModelFinal.POST_MENU;
		url = url.replace("ACCESS_TOKEN", AccessTokenContent.getAccess_token());
		
		// 创建POST请求
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json");
		
		// 创建实体
		StringEntity entity = new StringEntity(jsonString, 
				ContentType.create("application/json", "utf-8"));
		
		// 向post请求中注入实体
		post.setEntity(entity);
		
		try {
			// 执行post请求, 得到CloseableHttpResponse
			CloseableHttpResponse resp = client.execute(post);
			// 执行后得到状态代码
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode >= 200 && statusCode < 300) {
				// 提交后结果
				String str = EntityUtils.toString(resp.getEntity());
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
