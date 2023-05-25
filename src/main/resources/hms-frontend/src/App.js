import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListReportComponent from './components/ListReportComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateReportComponents from './components/CreateReportComponent';
import UpdateReportComponent from './components/UpdateReportComponent';
import ViewReportComponent from './components/ViewReportComplement';
import CreateLaborantComponent from './components/CreateDoctorComponent';
import ListDoctorComponent from './components/ListDoctorComponent';
import CreatePatientComponent from "./components/CreatePatientComponent";
import UpdatePatientComponent from "./components/UpdatePatientComponent";
import ListPatientComponent from "./components/ListPatientComponent";
function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container" style={{
          margin: "auto",
          padding: "15px",
          maxWidth: "1500px",
          alignContent: "center",
        }}>
                    <Switch>  
                          <Route path = "/" exact component = {ListReportComponent}></Route>
                          <Route path = "/reports" exact component = {ListReportComponent}></Route>
                          <Route path = "/add-report" exact component = {CreateReportComponents}></Route>
                          <Route path = "/update-report/:id" exact component = {UpdateReportComponent}></Route>
                          <Route path = "/update-patient/:id" exact component = {UpdatePatientComponent}></Route>
                          <Route path = "/view-report/:id" component = {ViewReportComponent}></Route>
                          <Route path = "/add-doctor" component = {CreateLaborantComponent}></Route>
                          <Route path = "/doctors" component = {ListDoctorComponent}></Route>
                          <Route path = "/patients" component = {ListPatientComponent}></Route>
                          <Route path = "/add-patient" exact component = {CreatePatientComponent}></Route>

                    </Switch>
                </div>
              {<FooterComponent />}
        </Router>
    </div>
  );
}

export default App;
