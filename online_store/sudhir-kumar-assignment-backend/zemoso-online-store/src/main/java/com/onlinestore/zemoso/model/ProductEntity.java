package com.onlinestore.zemoso.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426958722062082014L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	@Column(nullable = false)
	private String productTitile;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private Float rating;

	@Column(nullable = false)
	private Integer deliveryTime;

	@Column(nullable = false)
	private boolean isSold;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String imageurl;

	private PurchaseOrderEntity purchaseOrderEntity;

}
