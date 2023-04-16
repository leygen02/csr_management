
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
    <div>
    <Container>  
      <Link to="/Event"><Button  variant="outlined">EventList</Button></Link> 
      <Button  variant="outlined">Create Event</Button>
      
    </Container>

        
    </div>
      
    );
  }
  // if oragniser view show {employeelist}
  export default Oragniser; 
