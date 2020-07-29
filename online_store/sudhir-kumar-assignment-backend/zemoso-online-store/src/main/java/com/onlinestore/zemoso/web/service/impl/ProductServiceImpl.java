package com.onlinestore.zemoso.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.zemoso.dao.ProductRepository;
import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.web.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllproducts() {
		return productRepository.findAll();
	}

	@Override
	public ProductDTO getProductDetails(Long product_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
