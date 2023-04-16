
// import React, { useEffect, useState } from "react";

import { Container } from '@mui/material';


/* <AppBar component="nav">
        <Toolbar>
          
          <Typography
            variant="h6"
            component="div"
            sx={{ flexGrow: 1, display: { xs: 'none', sm: 'block' } }}
          >
            IMPACTHUB
          </Typography>
          <Box sx={{ display: { xs: 'none', sm: 'block' } }}>
              <Link to='/'>
              <Button sx={{ color: '#fff' }}>
                HOME
              </Button>
            </Link>
          </Box>
        </Toolbar>
      </AppBar> */


import 'react-vertical-timeline-component/style.min.css';

import { Link } from "react-router-dom";

import { Button } from '@mui/material';


// requried for appbar
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

function ViewSelect() {
    
    /*const [events, setEvents] = useState([]);
   

      useEffect(() => {
        fetchEventData()
      }, [])

     */ 
    return(
    <div className='App'>
   
   
      
      <Link to="/Employee"><Button  variant="outlined" style={{padding:'1 rem'}}><h1>Find an Event</h1></Button></Link> 
      <Link to="/Organiser"><Button  variant="outlined" style={{padding:' 1 rem'}}><h1>Post an Event</h1></Button></Link>
    
      
    
    
        
    </div>
      
    );
  }
  // if oragniser view show {employeelist}
  export default ViewSelect; 
