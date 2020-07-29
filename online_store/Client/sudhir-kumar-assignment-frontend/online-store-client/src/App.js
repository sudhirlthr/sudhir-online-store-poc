import React from 'react';
import logo from './logo.svg';
import './App.css';
import Card from './components/atoms/store-CardWithDropDownAtom';
import Products from './components/molecules/store-ProductsMolecule';
import LoginForm from './components/molecules/store-LoginMolecule';
import Singup from './components/molecules/store-SingUpMolecule';

function App() {
  return (
    <div className="App">
      {/* <Card />
      <Products /> */
      <Singup />
      }
    </div>
  );
}

export default App;
