package com.example.onlinekart.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onlinekart.model.Quantity_Discount;

@Repository
public interface quantityrepo extends JpaRepository<Quantity_Discount, Integer>{

	@Query("select q from Quantity_Discount q where q.minQuantity= :quantity")
	Optional<Quantity_Discount> findbyquant(@Param("quantity") int quantity);
	
	
	

}
