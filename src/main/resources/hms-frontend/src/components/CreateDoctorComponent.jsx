import React, { Component } from 'react'
import DoctorService from '../services/DoctorService';

class CreateDoctorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
 
            id: this.props.match.params.id,
            name: '',
            surname: '',
            departmentId: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeSurnameHandler = this.changeSurnameHandler.bind(this);
        this.changeDepartmentIdHandler = this.changeDepartmentIdHandler.bind(this);
        this.saveDoctor = this.saveDoctor.bind(this);
    }

 
    saveDoctor = (e) => {
        e.preventDefault();
        let doctor = {
            name: this.state.name, 
            surname: this.state.surname, 
            departmentId: parseInt(this.state.departmentId)
        };
            console.log('doctor => ' + JSON.stringify(doctor));
            DoctorService.createDoctor(doctor).then(res =>{
                this.props.history.push('');
            });
        } 
    
    
    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeSurnameHandler= (event) => {
        this.setState({surname: event.target.value});
    }

    changeDepartmentIdHandler= (event) => {
        this.setState({departmentId: event.target.value});
    }

    cancel(){
        this.props.history.push('');
    }

    getTitle(){
            return <h3 className="text-center">Add Doctor</h3>
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Name: </label>
                                            <input placeholder="Name" name="firstName" className="form-control" 
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Surname: </label>
                                            <input placeholder="Surname:" name="lastName" className="form-control" 
                                                value={this.state.surname} onChange={this.changeSurnameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Department Id </label>
                                            <input placeholder="DepartmentId" name="emailId" className="form-control"
                                                value={this.state.departmentId} onChange={this.changeDepartmentIdHandler}/>
                                        </div>
                                        <button className="btn btn-success" onClick={this.saveDoctor} style={{marginLeft: "10px"}} >Save</button>
                                        <button className="btn btn-danger"  onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}
export default CreateDoctorComponent