import React from 'react';
import ProductOrganism from '../organisms/store-ProductsOrganism';
import Navbar from '../organisms/store-NavbarOrganism';

export default function ProductTemplate(props){
    const products = props.products;
    const handleOnBuy = props.handleOnBuy;
    return (
            <>
                <Navbar />
                <ProductOrganism products ={products} handleOnBuy={handleOnBuy}/>
            </>
        );
}