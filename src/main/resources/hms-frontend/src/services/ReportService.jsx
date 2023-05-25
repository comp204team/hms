import axios from 'axios'

const REPORT_API_BASE_URL = "http://localhost:8080/api/reports";

class ReportService {

    getReports(){
        return axios.get(REPORT_API_BASE_URL)
      
    }
    createReport(report){
        return axios.post(REPORT_API_BASE_URL, report);
    }

    getReportById(reportId){
        return axios.get(REPORT_API_BASE_URL + '/' + reportId);
    }

    updateReport(report, reportId){
        return axios.put(REPORT_API_BASE_URL + '/' + reportId, report);
    }

    deleteReport(reportId){
        return axios.delete(REPORT_API_BASE_URL + '/' + reportId);
    }
    // TODO ARAMAYI APIDEN MI GELEN VERININ TAMAMINDAN MI
    searchInApi(value){
        return axios.get(REPORT_API_BASE_URL+`/search/${value}`)
    }

}
export default new ReportService();