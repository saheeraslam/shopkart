package com.example.onlinekart;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface cartservice {

	public ResponseEntity<Map<String, Object>> order(String productId,int quantity,String promocode,String usertyp);
}
