import React, {Component} from 'react'
import PatientService from '../services/PatientService'


class ListPatientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            patients: []
        }
    }


    componentDidMount() {
        PatientService.getAllPatients().then((res) => {
            this.setState({patients: res.data});
        });
    }

    cancel() {
        this.props.history.push('');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Patient List</h2>
                <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Back
                </button>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th> Id</th>
                            <th> First Name</th>
                            <th> Last Name</th>
                            <th> Department Id</th>
                            <th> Adress</th>
                            <th> Phone Number</th>
                            <th> Email</th>
                            <th> Room Id</th>
                            <th> DoctorId</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.patients.map(
                                patient =>
                                    <tr key={patient.id}>
                                        <td>  {patient.id}</td>
                                        <td>  {patient.name} </td>
                                        <td>  {patient.surname}</td>
                                        <td>  {patient.adress}</td>
                                        <td>  {patient.phoneNumber}</td>
                                        <td>  {patient.email}</td>
                                        <td>  {patient.roomId}</td>
                                        <td>  {patient.doctorId}</td>
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

export default ListPatientComponent