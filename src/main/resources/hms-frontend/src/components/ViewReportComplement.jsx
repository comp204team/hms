import React, {Component} from 'react'
import ReportService from '../services/ReportService'

class ViewReportComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            report: {}
        }
        this.cancel = this.cancel.bind(this);
    }

    cancel() {
        this.props.history.push('');
    }

    componentDidMount() {
        ReportService.getReportById(this.state.id).then(res => {
            this.setState({report: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3" style={{
                    margin: "auto",
                    padding: "15px",
                    maxWidth: "600px",
                    alignContent: "center",
                }}>
                    <h3 className="text-center"> View Report Details</h3>
                    <button className="btn btn-danger" onClick={this.cancel}>Back</button>
                    <div className="card-body">

                        <div className="row">
                            <label> National ID: </label>
                            <div> {this.state.report.patientId}</div>
                        </div>
                        <div className="row">
                            <label> Disease : </label>
                            <div> {this.state.report.disease}</div>
                        </div>
                        <div className="row">
                            <label> Description : </label>
                            <div> {this.state.report.description}</div>
                        </div>
                        <div className="row">
                            <label> Doctor Id : </label>
                            <div> {this.state.report.doctorId}</div>
                        </div>

                        <img src={this.state.report.photoUrl} alt="" style={{width: "500px"}}/>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewReportComponent