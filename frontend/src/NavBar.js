import React from 'react';
import {  Link } from "react-router-dom";
const navbar= () =>{
  return (
  <div >
    <li>
      <Link to="/"><h1>HOME</h1></Link>
    </li>
    
  </div>
  );
}
export default navbar;