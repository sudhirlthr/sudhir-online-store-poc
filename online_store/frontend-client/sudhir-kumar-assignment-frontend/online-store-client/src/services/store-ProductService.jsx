import React from 'react';
import axios from 'axios';

export default function getProducts(props){
    const header = props.header;
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get("http://localhost:8080/products/");
            setProducts(response.data);
        };
        fetchData();
    },[]);
    return products;
}