package com.cx.minip.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cx.minip.boot.domain.Movie;

/*
 * 电影相关的接口
 */

public interface MovieDao extends JpaRepository<Movie, Integer> {
	// 根据电影的id查询
	public List<Movie> findById(Integer id);

}
