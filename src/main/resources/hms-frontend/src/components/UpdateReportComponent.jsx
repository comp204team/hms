import React, {Component} from 'react'
import ReportService from '../services/ReportService';


class UpdateReportComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            disease: '',
            description: '',
            photoUrl: '',
            doctorId: '',
            patientId: '',
        }
        this.changeDiseaseHandler = this.changeDiseaseHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this)
        this.changePhotoUrlHandler = this.changePhotoUrlHandler.bind(this);
        this.changeDoctorIdHandler = this.changeDoctorIdHandler.bind(this);
        this.changePatientIdHandler = this.changePatientIdHandler.bind(this);
        this.updateReport = this.updateReport.bind(this);
    }


    componentDidMount() {

        ReportService.getReportById(this.state.id).then((res) => {
            let report = res.data;
            this.setState({
                patientId: report.patientId,
                disease: report.disease,
                description: report.description,
                doctorId: report.doctorId,
                photoUrl: report.photoUrl
            });
        });
    }

    updateReport = (e) => {
        e.preventDefault();
        let report = {
            patientId: parseInt(this.state.patientId),
            disease: this.state.disease,
            description: this.state.description,
            doctorId: parseInt(this.state.doctorId),
            photoUrl: this.state.photoUrl
        };
        console.log('report => ' + JSON.stringify(report));
        console.log('id => ' + JSON.stringify(this.state.id));
        ReportService.updateReport(report, this.state.id).then(res => {
            this.props.history.push('');
        });
    }


    changePatientIdHandler = (event) => {
        this.setState({patientId: event.target.value});
    }

    changeDiseaseHandler = (event) => {
        this.setState({disease: event.target.value});
    }
    changeDescriptionHandler = (event) => {
        this.setState({description: event.target.value});
    }
    changeDoctorIdHandler = (event) => {
        this.setState({doctorId: event.target.value});
    }
    changePhotoUrlHandler = (event) => {
        this.setState({photoUrl: event.target.value});
    }

    cancel() {
        this.props.history.push('');
    }

    getTitle() {

        return <h3 className="text-center">Add Report</h3>

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
                                        <label> National ID: </label>
                                        <input placeholder="PatientID" name="PatientId" className="form-control"
                                               value={this.state.patientId} onChange={this.changePatientIdHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Disease: </label>
                                        <input placeholder="Disease" name="Disease" className="form-control"
                                               value={this.state.disease} onChange={this.changeDiseaseHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Description: </label>
                                        <input placeholder="Description" name="Description" className="form-control"
                                               value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Doctor Id: </label>
                                        <input placeholder="Doctor" name="Doctor" className="form-control"
                                               value={this.state.doctorId} onChange={this.changeDoctorIdHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label> Photo Url: </label>
                                        <input placeholder="Photo Url" name="photoUrl" className="form-control"
                                               value={this.state.photoUrl} onChange={this.changePhotoUrlHandler}/>
                                    </div>


                                    <button className="btn btn-success" onClick={this.updateReport}>Save</button>
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

export default UpdateReportComponent