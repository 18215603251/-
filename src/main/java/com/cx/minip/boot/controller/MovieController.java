package com.cx.minip.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.minip.boot.dao.MovieDao;
import com.cx.minip.boot.domain.Movie;

@Controller
public class MovieController {
	@Autowired
	private MovieDao dao;
	
	@RequestMapping("/getMovies")
	@ResponseBody
	public Object getMovies() {
		List<Movie> movies = dao.findAll();
		return movies;
	}
	
}
