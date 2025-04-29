package com.example.onlinekart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinekart.model.products;

@Repository
public interface productrepo extends JpaRepository<products, String>{

}
