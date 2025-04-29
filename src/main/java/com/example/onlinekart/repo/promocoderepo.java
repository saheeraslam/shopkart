package com.example.onlinekart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinekart.model.promo_codes;

@Repository
public interface promocoderepo extends JpaRepository<promo_codes, String>{
	
	
}
