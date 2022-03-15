package com.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SCHEDULE_SEAT")
public class ScheduleSeat {
	
	@Id
	@Column(name = "SCHEDULE_SEAT_ID")
	private String id;
	
	@Column(name = "MOVIE_ID", length = 255)
	private String movieId;
	
	@Column(name = "SCHEDULE_ID", length = 10)
	private Integer scheduleId;
	
	@Column(name = "SEAT_ID", length = 10)
	private Integer seatId;
	
	@Column(name = "SEAT_COLUMN", length = 255)
	private String seatColumn;
	
	@Column(name = "SEAT_ROW", length = 10)
	private Integer seatRow;
	
	@Column(name = "SEAT_STATUS", length = 1)
	private Integer seatStatus;
	
	@Column(name = "SEAT_TYPE", length = 1)
	private Integer seatType;
}
