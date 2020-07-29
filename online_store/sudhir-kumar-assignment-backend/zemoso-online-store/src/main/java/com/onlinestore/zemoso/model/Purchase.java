package com.onlinestore.zemoso.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "purchase")
public class Purchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3251898189623675547L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long purchase_id;
	
	private Users user;
	
	private List<Product> products_purchased;
	
	private Date date_of_purchase;
	
	private Double total_amount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_of_purchase == null) ? 0 : date_of_purchase.hashCode());
		result = prime * result + ((products_purchased == null) ? 0 : products_purchased.hashCode());
		result = prime * result + ((purchase_id == null) ? 0 : purchase_id.hashCode());
		result = prime * result + ((total_amount == null) ? 0 : total_amount.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Purchase other = (Purchase) obj;
		if (date_of_purchase == null) {
			if (other.date_of_purchase != null)
				return false;
		} else if (!date_of_purchase.equals(other.date_of_purchase))
			return false;
		if (products_purchased == null) {
			if (other.products_purchased != null)
				return false;
		} else if (!products_purchased.equals(other.products_purchased))
			return false;
		if (purchase_id == null) {
			if (other.purchase_id != null)
				return false;
		} else if (!purchase_id.equals(other.purchase_id))
			return false;
		if (total_amount == null) {
			if (other.total_amount != null)
				return false;
		} else if (!total_amount.equals(other.total_amount))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
