import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import StoreCard from "../atoms/store-CardWithDropDownAtom";
import StoreGrid from "../atoms/store-GridListAtom";

export default function Products(){
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get("http://localhost:8080/products/");
            setProducts(response.data);
        };
        fetchData();
    },[]);

    async function handleOnBuy(event){
        event.preventDefault();
        const productId =  event.target.id;
        const api = "http://localhost:8080/cart/addProduct/"+productId+"/";
        console.log(api);
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWRoaXIiLCJleHAiOjE1OTI1NDYyNTF9.-rwl6pL7ugYbzdMyBAu28KnzqD0q_WPbDli57gUadNfj2UGHCr7-RFBeGwFPThqCzY__1VqYHv5yaudZ7c8YyQ'
          }
        let response;
        const res = await axios.get(api, {
            headers: headers
          });
        if (!alert('Success!')) { window.location.reload(); }
    };
    

    return(        
            <div>
               <StoreGrid products ={products} handleOnBuy={handleOnBuy}/>
            </div>
    );
}