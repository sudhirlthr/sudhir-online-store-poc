package com.onlinestore.zemoso.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseOrderEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3251898189623675547L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long purchaseId;

	@Column(nullable = false)
	private String user;

	@OneToMany(mappedBy = "purchaseOrderEntity")
	private List<ProductEntity> purchasedProducts;
	
	private LocalDate dateOfPurchase;
	
	private Double totalAmount;
}
