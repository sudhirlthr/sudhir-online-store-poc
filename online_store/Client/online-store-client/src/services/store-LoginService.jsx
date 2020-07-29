import React, { useEffect } from 'react';
import axios from 'axios';

export default function LoginDervice(props){
    const username = props.username;
    const password = props.password;
    const loginApi = "http://localhost:8080/login";

    useEffect(async() => {
        const fetchResponse = await axios.post(loginApi,{
                                                            username:{username},
                                                            password:{password}
                                                        }
                                                ).then((response) => {
                                                    console.log(rresponsees.data.token);
                                                    localStorage.setItem("Authorization", response.data.token);
                                                }, (error) => {console.log()});
    })
}