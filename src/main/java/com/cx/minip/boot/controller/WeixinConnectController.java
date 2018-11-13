package com.cx.minip.boot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cx.mini.boot.kit.SecurityKit;
import com.cx.mini.boot.msg.MessageKit;
import com.cx.mini.boot.quartz.RefreshAccessTokenTask;

/**
 * 微信连接 和  获取access_token
 */

@Controller
public class WeixinConnectController {
	
	// 随机自定义的token, 不过与微信中的相同
	public static final String TOKEN = "domain";
	
	// 验证消息的确来自微信服务器
	@RequestMapping("/wget")
	public void init(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// 得到相关的4个参数值
		
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		// 对这三个参数排序
		String[] arrs = {WeixinConnectController.TOKEN, timestamp, nonce};
		Arrays.sort(arrs);
		
		StringBuffer shal = new StringBuffer();
		// 排序后拼接
		for (String str : arrs) {
			shal.append(str);
		}
		
		// 对拼接后的字符串加密(调用自定义方法)
		String value = SecurityKit.sha(shal.toString());
		
		
		// 加密后的字符串与signature对比
		if (signature != null) {
			if (signature.equals(value)) {
				// 将这个echostr打印回去, 则配置成功
				res.getWriter().println(echostr);
			}
		}
	}

	// 用来得到access_token
	@RequestMapping("/at")
	public void getAccess_token(HttpServletResponse res) throws IOException {
		RefreshAccessTokenTask.refrashAccessToken();
		// String value = AccessTokenContent.getAccess_token();
		// res.getWriter().println(value);
	}
	
	
	// 菜单消息, 必需是post(因为微信推给我们是以pot的方法, 且以xml的形式返回数据)
	// 微信所有的消息推送, 都会进入在这个url中
	@RequestMapping(value="/wget", method=RequestMethod.POST)
	public void getWeixinMessage(HttpServletRequest req, HttpServletResponse res) throws IOException, DocumentException {
		Map<String, String> map = MessageKit.reqToMap(req);
		System.out.println(map);	
	}
	
}
