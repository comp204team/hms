import React, { Component } from 'react'
import DoctorService from '../services/DoctorService'


class ListDoctorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                doctors: []
        }
    }

 

    componentDidMount(){
        DoctorService.getAllDoctors().then((res) => {
            this.setState({ doctors: res.data});
        });
    }

    cancel(){
        this.props.history.push('');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Doctor List</h2>
                 <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Back</button>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th> Id</th>
                                    <th> Doctor First Name</th>
                                    <th> Doctor Last Name</th>
                                    <th> Doctor Department Id</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.doctors.map(
                                        doctor =>
                                        <tr key = {doctor.id}>
                                            <td>  {doctor.id}</td>
                                             <td> {doctor.name} </td>
                                             <td> {doctor.surname}</td>
                                             <td> {doctor.departmentId}</td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListDoctorComponent