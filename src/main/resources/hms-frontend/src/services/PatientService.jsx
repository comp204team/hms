import axios from 'axios'

const PATIENT_API_BASE_URL = "http://localhost:8080/api/patients";

class PatientService {

    getAllPatients(){
        return axios.get(PATIENT_API_BASE_URL);

    }
    getPatientById(patientId){
        return axios.get(PATIENT_API_BASE_URL + '/' + patientId);
    }

    createPatient(patient){
        return axios.post(PATIENT_API_BASE_URL, patient);
    }
    updatePatient(patient, patientId){
        return axios.put(PATIENT_API_BASE_URL + '/' + patientId, patient);
    }

    deletePatient(patientId){
        return axios.delete(PATIENT_API_BASE_URL + '/' + patientId);
    }
}
export default new PatientService();