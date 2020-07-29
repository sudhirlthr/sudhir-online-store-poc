package com.onlinestore.zemoso.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDTO {
	private Long purchase_id;
	private UsersDTO user;
	private List<ProductDTO> products_purchased;
	private Date date_of_purchase;
	private Double total_amount;	
}
