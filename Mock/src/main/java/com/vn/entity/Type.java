package com.vn.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "TYPE")
public class Type implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_ID", length = 10)
	private Integer id;
	
	@OneToMany(mappedBy = "typeId", cascade = CascadeType.ALL)
	private List<MovieType> movieTypes;
	
	@Column(name = "TYPE_NAME", length = 255)
	private String name;
}
