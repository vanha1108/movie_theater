package com.vn.service;

import java.util.List;

import com.vn.entity.Movie;

public interface MovieService {
	
	 Boolean saveMovie(Movie movie);
	 
	 List<Movie> getAll();
	 
	 Movie getById(Integer id);
	 
	 Boolean deleteById(Integer id);
}
