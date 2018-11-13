package com.cx.minip.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.minip.boot.dao.SectionDao;
import com.cx.minip.boot.domain.Section;

@Controller
public class ApplicationComtroller {

	@Autowired
	private SectionDao sectionDao;
	
	@RequestMapping("/index2")
	@ResponseBody						// 表示返回提json对象
	public Object index2() {
		List<Section> json = sectionDao.findAll();
		
		return json;
	}
	
	@RequestMapping("/index3")
	@ResponseBody						
	public Object index3(String title) {
		List<Section> findByTitle = sectionDao.findByTitle(title);
		System.out.println(findByTitle.get(0).getPid());
		return findByTitle;
	}

	
	@RequestMapping("/index4")
	@ResponseBody						
	public Object index4(String title,Integer id) {
		List<Section> findByTitle = sectionDao.findByTitleAndSid(title, id);
		System.out.println(findByTitle.get(0).getPid());
		return findByTitle;
	}
}
