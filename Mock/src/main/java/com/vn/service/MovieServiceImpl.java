package com.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entity.Movie;
import com.vn.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Boolean saveMovie(Movie movie) {
		try {
			movieRepository.save(movie);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	public Movie getById(Integer id) {
		Movie movie = movieRepository.getById(id);
		return movie;
	}

	public Boolean deleteById(Integer id) {
		try {
			movieRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;

	}

}
