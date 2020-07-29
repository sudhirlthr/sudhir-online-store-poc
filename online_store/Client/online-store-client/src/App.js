import React from 'react';
import './App.css';
import ProductPage from './components/pages/store-ProductPage';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import AboutProduct from './components/pages/store-ProductDetailPage';
import LoginPage from './components/pages/store-LoginPage';


function App() {
  return (
    <BrowserRouter>
    <div className="App">
        <Switch>
         <Route path="/" component={ProductPage} exact/>
         <Route path="/about/" component={AboutProduct} productId={3}/>
         <Route path="/login/" component={LoginPage} productId={3}/>
       </Switch>
    </div> 
  </BrowserRouter>
  );
}

export default App;
