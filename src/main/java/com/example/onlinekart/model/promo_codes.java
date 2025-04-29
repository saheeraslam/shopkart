package com.example.onlinekart.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class promo_codes {

	 @Id
	    private String code;

	    private BigDecimal discountPercentage;

	    private Boolean active = true; // Default true

	    private LocalDate validUntil;

	    // Getters and Setters
	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public BigDecimal getDiscountPercentage() {
	        return discountPercentage;
	    }

	    public void setDiscountPercentage(BigDecimal discountPercentage) {
	        this.discountPercentage = discountPercentage;
	    }

	    public Boolean getActive() {
	        return active;
	    }

	    public void setActive(Boolean active) {
	        this.active = active;
	    }

	    public LocalDate getValidUntil() {
	        return validUntil;
	    }

	    public void setValidUntil(LocalDate validUntil) {
	        this.validUntil = validUntil;
	    }
}
