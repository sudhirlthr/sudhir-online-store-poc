import React from 'react';
import ProductTemplate from '../templates/store-ProductTemplate';
import useProducts from '../../services/store-ProductServiceHook';
import BuyProductService from '../../services/store-ProductServices';

export default function ProductPage(props){
    const products = useProducts();
    
    function handleOnBuy(event){        
        BuyProductService(event);
    }
    return(<ProductTemplate products={products} handleOnBuy={handleOnBuy}/>);
    
}