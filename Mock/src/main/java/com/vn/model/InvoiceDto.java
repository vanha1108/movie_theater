package com.vn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Long invoiceId;

    private Integer addScore;

    private Date bookingDate;

    private String movieName;

    private Date scheduleShow;

    private String scheduleShowTime;

    private Integer status;

    private Double totalMoney;

    private Integer useScore;

    private String seat;
}
