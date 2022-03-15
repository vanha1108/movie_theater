package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.entity.ShowDate;

@Repository
public interface ShowDatesRepository extends JpaRepository<ShowDate, Integer> {

}
