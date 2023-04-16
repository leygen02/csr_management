

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
    <div>
    
      <Link to="/Event"><Button>EventList</Button></Link> 
      
    

        
    </div>
      
    );
  }
  // if oragniser view show {employeelist}
  export default Employee; 
