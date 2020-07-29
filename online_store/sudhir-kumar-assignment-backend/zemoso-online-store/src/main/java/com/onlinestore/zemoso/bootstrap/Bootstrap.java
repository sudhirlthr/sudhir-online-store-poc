package com.onlinestore.zemoso.bootstrap;

import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.dto.PurchaseOrderDTO;
import com.onlinestore.zemoso.model.ApplicationUser;
import com.onlinestore.zemoso.model.ProductEntity;
import com.onlinestore.zemoso.model.PurchaseOrderEntity;
import com.onlinestore.zemoso.service.product.ProductService;
import com.onlinestore.zemoso.service.purchase.PurchaseOrderService;
import com.onlinestore.zemoso.service.user.ApplicationUserService;
import com.onlinestore.zemoso.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ProductService productService;

    @Autowired
    ApplicationUserService userService;

    @Autowired
    PurchaseOrderService purchaseService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        init();
    }

    private void init(){
        ApplicationUser user = new ApplicationUser();
        user.setUsername("abc@gmail.com");
        user.setPassword("123");
        userService.createApplicationUser(user);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setDeliveryTime(5);
        productEntity.setDescription("Adidas high neck grey color shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(1999.00);
        productEntity.setProductTitile("Adidas High Neck");
        productEntity.setRating(4.0f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Adidas high neck grey shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));


        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(3);
        productEntity.setDescription("Adidas high neck white color shoe for running");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(2999.00);
        productEntity.setProductTitile("Adidas High Neck");
        productEntity.setRating(3.5f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Adidas high neck shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));


        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(4);
        productEntity.setDescription("Adidas grey color shoe for basketball");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(2599.00);
        productEntity.setProductTitile("Adidas basketball.jpg");
        productEntity.setRating(4.5f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Adidas high neck shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(2);
        productEntity.setDescription("Canvas brown color shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(2199.00);
        productEntity.setProductTitile("Canvas shoe.jpg");
        productEntity.setRating(4.3f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Canvas shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(4);
        productEntity.setDescription("NB running shoe with cloudform");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(2599.00);
        productEntity.setProductTitile("NB running shoe");
        productEntity.setRating(4.5f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/NB shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));



        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(6);
        productEntity.setDescription("Nike high neck air shoe with brown and while color");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(1599.00);
        productEntity.setProductTitile("Nike high neck air shoe");
        productEntity.setRating(3.2f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike air shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));


        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(10);
        productEntity.setDescription("Nike black and white color running shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(1199.00);
        productEntity.setProductTitile("Nike running shoe");
        productEntity.setRating(2.2f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike black white shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(9);
        productEntity.setDescription("Nike grey and orange color jogger shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(1899.00);
        productEntity.setProductTitile("Nike jogger");
        productEntity.setRating(5.0f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike grey orange.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(3);
        productEntity.setDescription("Nike grey color a light weight running shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(1799.00);
        productEntity.setProductTitile("Nike light weight shoe");
        productEntity.setRating(4.2f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike grey shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(2);
        productEntity.setDescription("Nike high neck red black shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(3199.00);
        productEntity.setProductTitile("Nike high neck red & black");
        productEntity.setRating(2.2f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike high neck black red shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(1);
        productEntity.setDescription("Nike red color running shoe with form");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(2299.00);
        productEntity.setProductTitile("Nike RED running shoe");
        productEntity.setRating(4.5f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike red shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(5);
        productEntity.setDescription("Nike white color shoe with thick sole");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(1699.00);
        productEntity.setProductTitile("Nike heavy sole shoe");
        productEntity.setRating(2.4f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Nike white shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        productEntity = new ProductEntity();
        productEntity.setDeliveryTime(10);
        productEntity.setDescription("Nike black and white color running shoe");
        productEntity.setSold(Boolean.FALSE);
        productEntity.setPrice(2149.00);
        productEntity.setProductTitile("Nike trekking shoe");
        productEntity.setRating(4.8f);
        productEntity.setImageurl("/home/zadmin/IdeaProjects/zemoso-online-store/src/main/resources/static/images/Trekking shoe.jpg");
        productService.createProduct(ObjectMapperUtil.map(productEntity, ProductDTO.class));

        PurchaseOrderEntity purchaseOrderEntity = new PurchaseOrderEntity();
        purchaseOrderEntity.setDateOfPurchase(LocalDate.now());
        purchaseOrderEntity.setPurchaseId(ThreadLocalRandom.current().nextLong());
        purchaseOrderEntity.setTotalAmount(1999.00);
        purchaseOrderEntity.setUser("abc@gmail.com");
        List<ProductEntity> productList = new ArrayList<>();
        productList.add(productEntity);
        purchaseOrderEntity.setPurchasedProducts(productList);
        purchaseService.createPurchaseOrder(ObjectMapperUtil.map(purchaseOrderEntity, PurchaseOrderDTO.class));
    }
}
