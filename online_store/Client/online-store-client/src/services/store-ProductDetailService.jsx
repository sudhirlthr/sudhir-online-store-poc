import { useState, useEffect } from 'react';
import axios from 'axios';

export default function ProductDetails(productId){
    const [product, setProduct] = useState({});
    
    const api = "http://localhost:8080/products/"+productId;

    useEffect(() => {
        const fetchdata = async() =>{
            const response = await axios.get(api);
        setProduct(response.data);
        }
        fetchdata();
    },[]);
    
    return product;
}