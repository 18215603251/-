package com.cx.mini.boot.msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/*
 * 用于消息管理
 */
public class MessageKit {
	// 处理xml放入一个map中
	@SuppressWarnings("unchecked")
	public static Map<String, String> reqToMap(HttpServletRequest request) throws IOException, DocumentException {
		String xml = reqToXml(request);
		// 将xml这个字符串转换为Document对象(表示xml文档)
		Document document = DocumentHelper.parseText(xml);
		
		// 根元素root表示xml标签
		Element root = document.getRootElement();
		
		Map<String, String> map = new HashMap<String, String>();
		
		// 获得根标签root的所有子标签
		List<Element> elements = root.elements();
		
		// 以标签名和标签体的形式放入map中 
		for (Element e: elements) {
			map.put(e.getName(), e.getTextTrim());		
		}
		return map;
	}
	
	// 从request中读取到xml中, 以字符串的形式返回
	public static String reqToXml(HttpServletRequest request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		StringBuffer xmlContent = new StringBuffer();
		String str = "";
		while((str = br.readLine()) != null) {
			xmlContent.append(str);
		}
		
		return xmlContent.toString();
	}

	// 处理消息
	public static String handMesage(Map<String, String> map) {
		String MsgType = map.get("MsgType");
		Map<String, String> m = new HashMap<String, String>();
		m.put("ToUserName", map.get("FromUserName"));
		
		return null;
	}
}
