import React from 'react';
import './App.css';
import ProductPage from './components/pages/store-ProductPage';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import AboutProduct from './components/pages/store-ProductDetailPage';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
        <Switch>
         <Route path="/" component={ProductPage} exact/>
         <Route path="/about/" component={AboutProduct} productId={3}/>
       </Switch>
    </div> 
  </BrowserRouter>
  );
}

export default App;
