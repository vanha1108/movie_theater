package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.entity.ScheduleSeat;

@Repository
public interface ScheduleSeatRepository extends JpaRepository<ScheduleSeat, String> {

}
