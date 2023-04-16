import { VerticalTimeline, VerticalTimelineElement }  from 'react-vertical-timeline-component';
import 'react-vertical-timeline-component/style.min.css';
import React, { useEffect, useState } from "react";
import Button from '@mui/material/Button';
import { Container } from '@mui/material';

function Event() {
    
    const [events, setEvents] = useState([]);
    const fetchEventData = () => {
        fetch("http://localhost:8080/api/events")
          .then(response => {
            return response.json()
          })
          .then(data => {
            setEvents(data)
          })
          .catch(function (err) {
            // This will fix your error since you are now handling the error thrown by your first catch block
            console.log(err.message)
        });
      }

      useEffect(() => {
        fetchEventData()
      }, [])

      events.sort((a, b) => {
        return new Date(b.deadline) - new Date(a.deadline); // ascending
      })
    return(
      
      <div>
        <h5>TITLE</h5>
        {events.map(events=>(
      <Container style={{width: '1170px'}}>
      <VerticalTimeline key={events.eventID} lineColor={ "#616161" } layout={'2-columns'}>
      <VerticalTimelineElement
      className="vertical-timeline-element--work"
      contentStyle={{ background: 'rgb(33, 150, 243)', color: '#fff' }}
      
      contentArrowStyle={{ borderRight: '7px solid  rgb(33, 150, 243)' }}
      iconStyle={{ background: 'rgb(33, 150, 243)', color: '#fff' }}
      
      
      >
      <h3 className="vertical-timeline-element-title">{events.eventName}</h3>
      <h4 className="vertical-timeline-element-subtitle">{events.location}</h4>
      <p>
        <br/>
        {events.deadline} <br/>
        <br/>
        {events.description} <br/>
        capacity: {events.capacity}
      
      </p>
      <br/>
      <Button variant="outlined" style={{color: "white", padding: '15px'}}>Register</Button>
    </VerticalTimelineElement>
    </VerticalTimeline> </Container>
    ))}
    </div>
      
    );
  }
  // if oragniser view show {employeelist}
  export default Event; 
