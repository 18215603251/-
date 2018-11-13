package com.cx.minip.boot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*用于表示电影的实体类*/

@Entity							// 标注为实体
@Table(name="movie")			// 数据表
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id		//标注为主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)		// 自增
	private Integer id;
		
	// 电影名称
	private String name;
	// 电影图片的地址
	
	@Column(name="img_url")
	private String imgUrl;
	
	// 电影的年份
	private String year;
	// 导演
	private String artist;
	// 电影简述
	private String desc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
