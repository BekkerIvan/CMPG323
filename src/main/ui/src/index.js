import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import TopNav from './components/top-nav'
global.isLoggedIn = false;
ReactDOM.render(
  <React.StrictMode>
      <TopNav isLoggedIn={global.isLoggedIn}/>
      <App/>
  </React.StrictMode>,
  document.getElementById('root')
);
