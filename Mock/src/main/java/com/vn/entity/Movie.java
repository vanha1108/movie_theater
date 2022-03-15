package com.vn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID", length = 10)
	private Integer id;
	
	@OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL)
	private List<MovieType> movieTypes;
	
	@OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL)
	private List<MovieSchedule> movieSchedules;
	
	@OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL)
	private List<MovieDate> movieDates;
	
	@Column(name = "ACTOR" , length = 255, nullable = false)
	private String actor;
	
	@Column(name = "CINEMA_ROOM_ID" , length = 10, nullable = false)
	private Integer cinemaRoomId;
	
	@Column(name = "CONTENT" , length = 1000)
	private String content;
	
	@Column(name = "DIRECTOR", length = 255, nullable = false)
	private String director;
	
	@Column(name = "DURATION", length = 10)
	private Float duration;

	@Column(name = "FROM_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
	
	@Column(name = "MOVIE_PRODUCT_COMPANY", length = 255)
	private String movieProductCompany;

	@Column(name = "TO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	@Column(name = "VERSION", length = 255)
	private String version;
	
	@Column(name = "MOVIE_NAME_ENGLISH", length = 255, nullable = false)
	private String movieNameEnglish;
	
	@Column(name = "MOVIE_NAME_VN", length = 255, nullable = false)
	private String movieNameVn;
	
	@Column(name = "LARGE_IMAGE", length = 255)
	private String largeImage;
	
	@Column(name = "SMALL_IMAGE", length = 255)
	private String smallImage;

}
