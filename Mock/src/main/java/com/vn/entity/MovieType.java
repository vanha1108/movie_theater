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
@Table(name = "MOVIE_TYPE")
public class MovieType implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name ="TYPE_ID")
	public Type typeId;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	public Movie movieId;
}
