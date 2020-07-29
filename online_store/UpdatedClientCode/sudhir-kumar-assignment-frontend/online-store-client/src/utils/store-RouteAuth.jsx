import React from 'react'
import {Route} from 'react-router-dom';
import App from '../App';
import Login from '../components/molecules/store-LoginMolecule'


function requireAuth(replace) {
  console.log("in ao");
  
  if (true) {
    replace({
      pathname: '/login'
    })
  }
}

export default function routes() {
  console.log("in aoll");
  return (
    <Route path="/" component={App}>
      <Route path="/login" component={Login} onEnter={requireAuth}/>
    </Route>
  );
}