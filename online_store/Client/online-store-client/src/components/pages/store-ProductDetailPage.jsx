import React from 'react';
import HandleOnBuyService from '../../services/store-ProductServices';
import ProductDetailService from '../../services/store-ProductDetailService';
import ProductTemplate from '../templates/store-ProductDetailTemplate'

export default function ProductDetail(props){ 
    const productId = (window.location.pathname).split("/")[2];
    const product = ProductDetailService(productId);
    function handleOnBuy(event) {
        HandleOnBuyService(event);
    }
    
    return(
        <ProductTemplate product={product} handleOnBuy={handleOnBuy}/>
    );
}