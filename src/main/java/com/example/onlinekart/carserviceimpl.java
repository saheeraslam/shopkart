package com.example.onlinekart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onlinekart.model.Quantity_Discount;
import com.example.onlinekart.model.products;
import com.example.onlinekart.model.promo_codes;
import com.example.onlinekart.model.user_type;
import com.example.onlinekart.repo.productrepo;
import com.example.onlinekart.repo.promocoderepo;
import com.example.onlinekart.repo.quantityrepo;
import com.example.onlinekart.repo.usertyperepo;

@Service
public class carserviceimpl implements cartservice{

	@Autowired
	productrepo productrepo;
	@Autowired
	usertyperepo usertyperepo;
	@Autowired
	promocoderepo promocoderepo;
	@Autowired
	quantityrepo quantityrepo;
	
	@Override
	public ResponseEntity<Map<String, Object>> order(String productId, int quantity, String promocode, String usertyp) {

		if(quantity<1) {
			throw new RuntimeException("no quantity");
		}
		
		Optional<products> product=Optional.ofNullable(productrepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId)));
		
			BigDecimal discount=BigDecimal.ZERO;
			List<Map<String, Object>> appliedDiscounts = new ArrayList<>();
			Optional<user_type> usertype=usertyperepo.findById(usertyp);
			if(usertype.isPresent()) {
				user_type usertypeobj=usertype.get();
				discount=discount.add(usertypeobj.getDiscountPercentage());
				adddisc("usertype",usertypeobj.getDiscountPercentage(),appliedDiscounts);
			}
			Optional<promo_codes> procode=promocoderepo.findById(promocode);
			if(procode.isPresent()) {
				promo_codes promocodeobj=procode.get();
				discount=discount.add(promocodeobj.getDiscountPercentage());
				adddisc("promocode",promocodeobj.getDiscountPercentage(),appliedDiscounts);
			}
			
			
			if(quantity>=10) {
				Optional<Quantity_Discount> quantity_Dis=quantityrepo.findbyquant(10);	
				if(quantity_Dis.isPresent()) {
					Quantity_Discount discobj=quantity_Dis.get();
				discount=discount.add(discobj.getDiscountPercentage());
				adddisc("quantity",discobj.getDiscountPercentage(),appliedDiscounts);
				}
			}
			else if (quantity>=5) {
				Optional<Quantity_Discount> quantity_Dis=quantityrepo.findbyquant(5);	
				if(quantity_Dis.isPresent()) {
					Quantity_Discount discobj=quantity_Dis.get();
				discount=discount.add(discobj.getDiscountPercentage());
				adddisc("quantity",discobj.getDiscountPercentage(),appliedDiscounts);
				}
			}else if (quantity>=3) {
				Optional<Quantity_Discount> quantity_Dis=quantityrepo.findbyquant(3);	
				if(quantity_Dis.isPresent()) {
					Quantity_Discount discobj=quantity_Dis.get();
				discount=discount.add(discobj.getDiscountPercentage());
				adddisc("quantity",discobj.getDiscountPercentage(),appliedDiscounts);
				}
			}
			
			products selectedproduct=product.get();
			BigDecimal totalsaving=selectedproduct.getBasePrice().multiply(discount.divide(BigDecimal.valueOf(100)));
			
			
			BigDecimal fianalpirce=selectedproduct.getBasePrice().subtract(totalsaving);
			
			 Map<String, Object> responce = new HashMap<>();
			 responce.put("productId", selectedproduct.getId());
			 responce.put("originalPrice", selectedproduct.getBasePrice());
			 responce.put("finalPrice", fianalpirce);
			 responce.put("appliedDiscounts", appliedDiscounts);
			 responce.put("totalSavings", totalsaving);
			 
			 return ResponseEntity.ok(responce);
			
	}
	public void adddisc(String type,BigDecimal per,List<Map<String, Object>> appliedDiscounts ) {
		Map<String, Object> addeddiscount = new HashMap<>();
		
		addeddiscount.put("type",type);
		addeddiscount.put("percentage",per);
		appliedDiscounts.add(addeddiscount);
	}
	

}
