import React from 'react';
import logo from './logo.svg';
import './App.css';
import Posts from './components/molecules/blog-GetAllPosts';
import PostTemplate from './components/templates/blog-PostTemplate';


function App() {
  return (
    <div className="App">
      {/* { <Posts /> } */}
      { <PostTemplate /> }
    </div>
  );
}

export default App;
