package com.onlinestore.zemoso.web.service;

import java.util.List;

import com.onlinestore.zemoso.dto.ProductDTO;

public interface ProductService {
	
	List<ProductDTO> getAllproducts();
	ProductDTO getProductDetails(Long product_id);
}
