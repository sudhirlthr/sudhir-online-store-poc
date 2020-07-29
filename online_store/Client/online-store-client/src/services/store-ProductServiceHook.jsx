import { useState, useEffect } from 'react';
import axios from 'axios';

export default function useProductService() {
    const [products, setProducts] = useState([]);
    const api = "http://localhost:8080/products/";

    useEffect(() => {
        const fetchdata = async() => {
            const response = await axios.get(api);
        setProducts(response.data);
        }
        fetchdata();
    },[]);
    return products;
  }