package com.vn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "SHOW_DATES")
public class ShowDate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHOW_DATE_ID", length = 10)
	private Integer id;
	
	@OneToMany(mappedBy = "showDateId")
	private List<MovieDate> movieDates;

	@Column(name = "SHOW_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "DATE_NAME", length = 255)
	private String name;
}
