
// import React, { useEffect, useState } from "react";

import Button from '@mui/material/Button';
import { Container } from '@mui/material';
import {Link} from "react-router-dom";
function Oragniser() {
    
    /*const [events, setEvents] = useState([]);
   

      useEffect(() => {
        fetchEventData()
      }, [])

     */ 
    return(
    <div  style={{ margin: 'auto',padding: '400px'}}>
     
      <Link to="/Event"><Button variant='outlined'  style={{margin: '10px'}} ><h1>EventList</h1></Button></Link> 
      <Button  variant="outlined"  style={{margin: '10px'}}  ><h1>Create Event</h1></Button>
      
   

        
    </div>
      
    );
  }
  // if oragniser view show {employeelist}
  export default Oragniser; 
