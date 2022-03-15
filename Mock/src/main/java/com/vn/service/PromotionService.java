package com.vn.service;

import org.springframework.data.domain.Page;

import com.vn.entity.Promotion;

public interface PromotionService {
	
	public Page<Promotion> listAll(int pageNumber);
	
	public Promotion save(Promotion promotion);
	
	public Promotion get(Integer id);
	
	public void delete(Integer id);
	
}
