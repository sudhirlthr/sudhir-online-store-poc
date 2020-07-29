package com.onlinestore.zemoso.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.onlinestore.zemoso.model.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseOrderDTO {
	private Long purchaseId;
	@NotEmpty(message = "Username should not be empty")
	private String user;
	@NotEmpty(message = "Products products should not be empty")
	private List<ProductEntity> purchasedProducts;
	@NotEmpty(message = "Date of purchase should not be empty")
	private LocalDate dateOfPurchase;
	@NotEmpty(message = "Total amount should not be empty")
	private Double totalAmount;
}
