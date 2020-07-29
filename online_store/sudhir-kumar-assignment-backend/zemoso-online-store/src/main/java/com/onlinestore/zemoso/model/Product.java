package com.onlinestore.zemoso.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426958722062082014L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	
	@NotEmpty(message = "Please provide prouct title")
	private String product_titile;
	
	@NotEmpty(message = "Please provide prouct price")
	private Double price;
	
	@NotEmpty(message = "Please provide prouct rating")
	private Float rating;
	
	@NotEmpty(message = "Please provide prouct estimated delivery time")
	private Integer delivery_time;
	
	private Boolean isSold;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delivery_time == null) ? 0 : delivery_time.hashCode());
		result = prime * result + ((isSold == null) ? 0 : isSold.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((product_titile == null) ? 0 : product_titile.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (delivery_time == null) {
			if (other.delivery_time != null)
				return false;
		} else if (!delivery_time.equals(other.delivery_time))
			return false;
		if (isSold == null) {
			if (other.isSold != null)
				return false;
		} else if (!isSold.equals(other.isSold))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (product_titile == null) {
			if (other.product_titile != null)
				return false;
		} else if (!product_titile.equals(other.product_titile))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

}
