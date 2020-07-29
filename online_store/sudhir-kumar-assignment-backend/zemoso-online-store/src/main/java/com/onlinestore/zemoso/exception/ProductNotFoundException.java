package com.onlinestore.zemoso.exception;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(){
		super("No products not found");
	}

	public ProductNotFoundException(Long productId) {
		super(String.format("Product not found, for productId %d", productId));
	}
}
