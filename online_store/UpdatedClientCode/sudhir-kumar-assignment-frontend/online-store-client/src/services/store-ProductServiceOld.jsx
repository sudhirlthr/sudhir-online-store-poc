import React, {useEffect, useState} from 'react';
import axios from 'axios';

export default function ProductService(){
    const [products, setProducts] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get("http://localhost:8080/products/");
            setProducts(response.data);
        };
        fetchData();
    },[]);
    return(products);
}