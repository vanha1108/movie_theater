package com.vn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "MOVIE_DATE")
public class MovieDate implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movieId;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "SHOW_DATE_ID")
	private ShowDate showDateId;
	
	
}
