
import './App.css';

import ViewSelect from './pages/ViewSelect';
import Box from '@mui/material/Box';

import 'react-vertical-timeline-component/style.min.css';
import Event from './components/Event';
import ReactDOM from "react-dom/client";
import NoPage from './nopage';
import { BrowserRouter as Router,Route,Routes,Link } from "react-router-dom";
import Employee from './pages/Employee';
import Organiser from './pages/Organiser';
import { Button } from '@mui/material';
import AppBar from '@mui/material/AppBar';

import navbar from './NavBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';



export default function App() {
  return (
    <Router>
            
           <div className="App">
            <navbar/>
           <Routes>
                 <Route exact path='/' element={< ViewSelect />}></Route>
                 <Route exact path='/Organiser' element={< Organiser />}></Route>
                 <Route exact path='/Employee' element={< Employee />}></Route>
                 <Route exact path='/Event' element={< Event />}></Route>
          </Routes>
           
          </div>
       </Router>
       
  );
}


