import React, {Component} from 'react'
import PatientService from '../services/PatientService';
import ReportService from "../services/ReportService";

class CreatePatientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

            id: this.props.match.params.id,
            name: '',
            surname: '',
            departmentId: '',
            address: '',
            phoneNumber: '',
            email: '',
            doctorId: '',
            roomId: ''
        }

        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeSurnameHandler = this.changeSurnameHandler.bind(this);
        this.changeDepartmentIdHandler = this.changeDepartmentIdHandler.bind(this);
        this.changeAdressHandler = this.changeAdressHandler.bind(this);
        this.changePhoneNumberHandler = this.changePhoneNumberHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeDoctorIdHandler = this.changeDoctorIdHandler.bind(this);
        this.changeRoomIdHandler = this.changeRoomIdHandler.bind(this);
        this.updatePatient = this.updatePatient.bind(this);
    }


    componentDidMount() {

        PatientService.getPatientById(this.state.id).then((res) => {
            let patient = res.data;
            this.setState({
                name: patient.name,
                surname: patient.surname,
                departmentId: patient.departmentId,
                address: patient.address,
                phoneNumber: patient.phoneNumber,
                email: patient.email,
                doctorId: patient.doctorId,
                roomId: patient.roomId
            });
        });
    }

    updatePatient = (e) => {
        e.preventDefault();
        let patient = {
            name: this.state.name,
            surname: this.state.surname,
            departmentId: parseInt(this.state.departmentId),
            adress: this.state.adress,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            doctorId: parseInt(this.state.doctorId),
            roomId: parseInt(this.state.roomId)
        };
        console.log('patient => ' + JSON.stringify(patient));
        PatientService.updatePatient(patient).then(res => {
            this.props.history.push('');
        });
    }


    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }

    changeSurnameHandler = (event) => {
        this.setState({surname: event.target.value});
    }

    changeDepartmentIdHandler = (event) => {
        this.setState({departmentId: event.target.value});
    }

    changeAdressHandler = (event) => {
        this.setState({address: event.target.value});
    }
    changePhoneNumberHandler = (event) => {
        this.setState({phoneNumber: event.target.value});
    }
    changeEmailHandler = (event) => {
        this.setState({email: event.target.value});
    }
    changeDoctorIdHandler = (event) => {
        this.setState({doctorId: event.target.value});
    }
    changeRoomIdHandler = (event) => {
        this.setState({roomId: event.target.value});
    }

    cancel() {
        this.props.history.push('');
    }

    getTitle() {
        return <h3 className="text-center">Add Patient</h3>
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> Name: </label>
                                        <input placeholder="Name" name="firstName" className="form-control"
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Surname: </label>
                                        <input placeholder="Surname:" name="lastName" className="form-control"
                                               value={this.state.surname} onChange={this.changeSurnameHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Department Id: </label>
                                        <input placeholder="Department Id" name="Department Id" className="form-control"
                                               value={this.state.departmentId}
                                               onChange={this.changeDepartmentIdHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Surname: </label>
                                        <input placeholder="Adress:" name="adress" className="form-control"
                                               value={this.state.address} onChange={this.changeAdressHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Surname: </label>
                                        <input placeholder="Phone Number:" name="phoneNumber" className="form-control"
                                               value={this.state.phoneNumber} onChange={this.changePhoneNumberHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Surname: </label>
                                        <input placeholder="Email:" name="email" className="form-control"
                                               value={this.state.email} onChange={this.changeEmailHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label> Department Id: </label>
                                        <input placeholder="Room Id" name="RoomId" className="form-control"
                                               value={this.state.roomId}
                                               onChange={this.changeRoomIdHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Department Id: </label>
                                        <input placeholder="DoctorId" name="DoctorId" className="form-control"
                                               value={this.state.doctorId}
                                               onChange={this.changeDoctorIdHandler}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.savePatient}
                                            style={{marginLeft: "10px"}}>Save
                                    </button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}
                                            style={{marginLeft: "10px"}}>Cancel
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default CreatePatientComponent

