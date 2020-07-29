package com.onlinestore.zemoso.controller;

import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	ProductController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping("/")
	public List<ProductDTO> getProductList() {
		return productService.getAllproducts();
	}

	@GetMapping(path = "/{id}")
	public ProductDTO getProductById(@PathVariable("id") Long id) {
		return productService.getProductDetails(id);
	}
	
	@PostMapping(path = "/create")
	public ProductDTO create(@RequestBody ProductDTO productDTO){
		productDTO = productService.createProduct(productDTO);
		return productDTO;
	}
}
