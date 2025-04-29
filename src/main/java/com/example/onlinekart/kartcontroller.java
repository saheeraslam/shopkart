package com.example.onlinekart;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/")
public class kartcontroller {

	@Autowired
	cartservice service;
	
	@PostMapping("price-calculation")
	public ResponseEntity<Map<String, Object>> postorder(@RequestBody Map<String, Object> request)
	{
		String orderid=(String) request.get("productId");
		int quantity=(int) request.get("quantity");
		String promocede=(String) request.get("promoCode");
		String usertype=(String) request.get("userType");
		
		return service.order(orderid,quantity,promocede,usertype);
	}
	
	
}
