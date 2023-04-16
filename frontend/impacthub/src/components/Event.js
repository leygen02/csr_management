import { VerticalTimeline, VerticalTimelineElement }  from 'react-vertical-timeline-component';
import 'react-vertical-timeline-component/style.min.css';
import React, { useEffect, useState } from "react";


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

    
    return(
      events.map(events=>(
      <VerticalTimeline>
      <VerticalTimelineElement
      className="vertical-timeline-element--work"
      contentStyle={{ background: 'rgb(33, 150, 243)', color: '#fff' }}
      contentArrowStyle={{ borderRight: '7px solid  rgb(33, 150, 243)' }}
      iconStyle={{ background: 'rgb(33, 150, 243)', color: '#fff' }}
      date={events.deadline}
      >
      <h3 className="vertical-timeline-element-title">{events.eventName}</h3>
      <h4 className="vertical-timeline-element-subtitle">{events.location}</h4>
      <p>
        
        {events.description} <br/>
        capacity: {events.capacity}
      
      </p>
    </VerticalTimelineElement>
    </VerticalTimeline>
      ))
    );
  }
  // if oragniser view show {employeelist}
  export default Event; 
