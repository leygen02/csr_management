

// import React, { useEffect, useState } from "react";
import Button from '@mui/material/Button';
import { Container } from '@mui/material';
import {Link} from "react-router-dom";
function Employee() {
    
    /*const [events, setEvents] = useState([]);
   

      useEffect(() => {
        fetchEventData()
      }, [])

     */ 
    return(
    <div style={{ position: 'static',padding: '300px'}}>
    
      <Link to="/Event"><Button variant='outlined' style={{margin: '20px'}} ><h1 >EVENT LIST</h1></Button></Link> 
      
    

        
    </div>
      
    );
  }
  // if oragniser view show {employeelist}
  export default Employee; 
