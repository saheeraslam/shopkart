/**
 * 
 */
package com.example.onlinekart.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="Quantity_Discounts")
public class Quantity_Discount {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private Integer minQuantity;

	    private BigDecimal discountPercentage;

	    // Getters and Setters
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getMinQuantity() {
	        return minQuantity;
	    }

	    public void setMinQuantity(Integer minQuantity) {
	        this.minQuantity = minQuantity;
	    }

	    public BigDecimal getDiscountPercentage() {
	        return discountPercentage;
	    }

	    public void setDiscountPercentage(BigDecimal discountPercentage) {
	        this.discountPercentage = discountPercentage;
	    }
	
}
