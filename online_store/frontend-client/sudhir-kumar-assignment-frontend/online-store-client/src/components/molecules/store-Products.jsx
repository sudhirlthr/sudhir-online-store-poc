import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import StoreCard from "../atoms/store-Card";

export default function Products(){
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get("http://localhost:8080/products/");
            setProducts(response.data);
        };
        fetchData();
    },[]);


    return(        
            <div><label>{products.length}</label>
                {
                    products.map(product => 
                        <StoreCard product={product} />
                    )
                }
            </div>
    );
}