package com.onlinestore.zemoso.service.product;

import com.onlinestore.zemoso.dao.ProductRepository;
import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.exception.ProductNotFoundException;
import com.onlinestore.zemoso.model.ProductEntity;
import com.onlinestore.zemoso.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllproducts() {
        List<ProductEntity> products = productRepository.findAll();
        return ObjectMapperUtil.mapAll(products, ProductDTO.class);
    }

    @Override
    public ProductDTO getProductDetails(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        return ObjectMapperUtil.map(productEntity, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ObjectMapperUtil.map(productDTO, ProductEntity.class);
        productEntity = productRepository.save(productEntity);
        return ObjectMapperUtil.map(productEntity, ProductDTO.class);
    }

}
