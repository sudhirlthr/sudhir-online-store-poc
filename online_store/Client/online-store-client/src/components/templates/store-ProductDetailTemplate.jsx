import React from 'react';
import Grid from '../organisms/store-GridOrganism';

export default function ProductDetailtemplate(props){
    const product = props.product;
    const handleOnBuy = props.handleOnBuy;

    return(
        <Grid product={product} handleOnBuy={handleOnBuy} />
    );
}