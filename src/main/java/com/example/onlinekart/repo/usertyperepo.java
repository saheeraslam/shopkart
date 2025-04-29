package com.example.onlinekart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinekart.model.user_type;

@Repository
public interface usertyperepo extends JpaRepository<user_type, String>{

}
