import axios from 'axios'

const PATIENT_API_BASE_URL = "http://localhost:8080/api/doctors";

class PatientService {

    getAllDoctors(){
        return axios.get(PATIENT_API_BASE_URL);

    }

    createDoctor(laborant){
        return axios.post(PATIENT_API_BASE_URL, laborant);
    }

}
export default new PatientService();