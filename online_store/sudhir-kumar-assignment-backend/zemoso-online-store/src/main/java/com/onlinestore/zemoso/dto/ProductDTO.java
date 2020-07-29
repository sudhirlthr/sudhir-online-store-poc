package com.onlinestore.zemoso.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.onlinestore.zemoso.model.PurchaseOrderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

	@NotEmpty(message = "Product id should not be empty")
	private Long productId;

	@NotEmpty(message = "Product title should not be empty")
	private String productTitile;

	@NotEmpty(message = "Product price should not be empty")
	private Double price;

	private Float rating;

	@NotEmpty(message = "Product delivery date should not be empty")
	private Integer deliveryTime;

	private Boolean isSold;

	@NotEmpty(message = "Product description should not be empty")
	private String description;

	@NotEmpty
	private String imageurl;

	private PurchaseOrderEntity purchaseOrderEntity;
}
