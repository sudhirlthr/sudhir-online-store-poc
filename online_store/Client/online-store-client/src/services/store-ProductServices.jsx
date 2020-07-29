import React from 'react';

import axios from 'axios';
import App from '../App';

import { BrowserRouter, Route } from "react-router-dom";
import { Redirect } from 'react-router';
import interceptors from '../utils/store-Interceptor';
import Login from '../components/molecules/store-LoginMolecule';

export default async function handleOnBuy(event){
        // var jwtToken;
        // console.log(jwtToken);
        // jwtToken = localStorage.getItem("authorization");
        
        // console.log(jwtToken);
        // if(jwtToken == null){
          
        //   return(
        //     <Redirect to='/login' component={Login} />
        //   );
        // }


        event.preventDefault();
        const productId =  event.target.id;
        const api = "http://localhost:8080/cart/addProduct/"+productId+"/";
        console.log(api);
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWRoaXIiLCJleHAiOjE1OTI1NDYyNTF9.-rwl6pL7ugYbzdMyBAu28KnzqD0q_WPbDli57gUadNfj2UGHCr7-RFBeGwFPThqCzY__1VqYHv5yaudZ7c8YyQ'
          }
        const res = axios.get(api, {
            headers: headers
          });
        if (!alert('Success!')) { window.location.reload(); }
    }