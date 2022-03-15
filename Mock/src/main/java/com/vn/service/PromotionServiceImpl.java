package com.vn.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vn.entity.Promotion;
import com.vn.repository.PromotionRepository;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private PromotionRepository repo; 

	@Override
	public Page<Promotion> listAll(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 5);
		return repo.findAll(pageable);
	}

	@Override
	public Promotion save(Promotion promotion) {
		return repo.save(promotion);
	}

	@Override
	public Promotion get(Integer id) {
		Optional<Promotion> optional = repo.findById(id);
		Promotion promotion = null;
		if (optional.isPresent()) {
			promotion = optional.get();
		} else {
			throw new RuntimeException("Promotion not found for id :: " + id);
		}
		return promotion;
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
