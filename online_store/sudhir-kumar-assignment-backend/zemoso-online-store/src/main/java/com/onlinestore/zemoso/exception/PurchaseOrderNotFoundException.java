package com.onlinestore.zemoso.exception;

public class PurchaseOrderNotFoundException extends RuntimeException {
	public PurchaseOrderNotFoundException() {
		super("Purchase order not found for given username or purcahse id");
	}
}
