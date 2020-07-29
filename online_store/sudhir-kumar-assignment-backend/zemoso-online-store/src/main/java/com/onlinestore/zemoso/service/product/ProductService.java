package com.onlinestore.zemoso.service.product;

import java.util.List;

import com.onlinestore.zemoso.dto.ProductDTO;

public interface ProductService {
	
	ProductDTO createProduct(ProductDTO product);
	List<ProductDTO> getAllproducts();
	ProductDTO getProductDetails(Long productId);

	
}
