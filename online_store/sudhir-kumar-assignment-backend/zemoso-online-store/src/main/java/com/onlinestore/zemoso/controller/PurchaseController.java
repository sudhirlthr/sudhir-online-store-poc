package com.onlinestore.zemoso.controller;

import com.onlinestore.zemoso.dto.PurchaseOrderDTO;
import com.onlinestore.zemoso.service.purchase.PurchaseOrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

    private final PurchaseOrderService purchaseOrderService;
    PurchaseController(PurchaseOrderService purchaseOrderService){
        this.purchaseOrderService = purchaseOrderService;
    }

     @GetMapping("/user")
    public List<PurchaseOrderDTO> getUserPurchaseProducts(Authentication authentication){
         return purchaseOrderService.getPurchaseByUsername(authentication.getName());
     }

     @GetMapping("/{purchaseId}")
     public PurchaseOrderDTO getPurchaseOrderByPurchaseId(@PathVariable Long purchaseId){
        return purchaseOrderService.getPurchaseByPurchaseId(purchaseId);
     }

     @PostMapping("/createPurchase")
    public PurchaseOrderDTO createPurchasedOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        return purchaseOrderService.createPurchaseOrder(purchaseOrderDTO);
     }
}
