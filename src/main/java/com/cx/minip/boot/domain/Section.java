package com.cx.minip.boot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		// 表示实体
@Table(name="section")	// 表示数据表
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id		//代表主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)		//主健自动增长
	private Integer sid;
	
	@Column(name="stitle")		// name的值是表中的字段名(此属性与表中字段名不同, 所以需要注解)
	private String title;
	private String description;
	private Integer pid;
	
	@Column(name="imgurl")		// 因为表中是大写的u, 它默认会变成img_url, 这就导致了表字段与属性不同, 所以也要注解
	private String imgUrl;
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
