package com.onlinestore.zemoso.service.purchase;

import com.onlinestore.zemoso.dao.ApplicationUserRepository;
import com.onlinestore.zemoso.dao.PurchaseOrderRepository;
import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.dto.PurchaseOrderDTO;
import com.onlinestore.zemoso.exception.PurchaseOrderNotFoundException;
import com.onlinestore.zemoso.model.ApplicationUser;
import com.onlinestore.zemoso.model.ProductEntity;
import com.onlinestore.zemoso.model.PurchaseOrderEntity;
import com.onlinestore.zemoso.service.product.ProductService;
import com.onlinestore.zemoso.util.ObjectMapperUtil;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ProductService productService;
    private final ApplicationUserRepository applicationUserRepository;

    PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, ApplicationUserRepository applicationUserRepository, ProductService productService) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.productService = productService;
    }

    @Override
    public PurchaseOrderDTO getPurchaseByPurchaseId(Long purchaseId) {
        PurchaseOrderEntity purchaseorderEntity = purchaseOrderRepository.findById(purchaseId).orElseThrow(PurchaseOrderNotFoundException::new);
        return ObjectMapperUtil.map(purchaseorderEntity, PurchaseOrderDTO.class);

    }

    @Override
    public List<PurchaseOrderDTO> getPurchaseByUsername(String email) {

        ApplicationUser applicationUser = applicationUserRepository.findByUsername(email);
        if (applicationUser == null) throw new UsernameNotFoundException(email);
        List<PurchaseOrderEntity> purchasedOrderByUser = purchaseOrderRepository.findByUser(email);
        if (purchasedOrderByUser == null || purchasedOrderByUser.isEmpty())
            throw new PurchaseOrderNotFoundException();
        return purchasedOrderByUser.stream()
                .map(entity -> ObjectMapperUtil.map(entity, PurchaseOrderDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        if (purchaseOrderDTO == null) throw new PurchaseOrderNotFoundException();
        PurchaseOrderEntity purchaseOrderEntity = ObjectMapperUtil.map(purchaseOrderDTO, PurchaseOrderEntity.class);
        List<ProductEntity> purchasedProducts = purchaseOrderEntity.getPurchasedProducts();
        purchasedProducts.forEach(productEntity -> productEntity.setSold(true));
        List<ProductDTO> products = new ArrayList<>();
        purchasedProducts.forEach(productEntity -> products.add(productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class))));
        purchaseOrderEntity.setPurchasedProducts(ObjectMapperUtil.mapAll(products, ProductEntity.class));
        return ObjectMapperUtil.map(purchaseOrderRepository.save(purchaseOrderEntity), PurchaseOrderDTO.class);
    }

}
