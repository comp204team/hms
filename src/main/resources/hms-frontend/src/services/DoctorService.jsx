import axios from 'axios'

const DOCTOR_API_BASE_URL = "http://localhost:8080/api/doctors";

class DoctorService {

    getAllDoctors(){
        return axios.get(DOCTOR_API_BASE_URL);

    }

    createDoctor(laborant){
        return axios.post(DOCTOR_API_BASE_URL, laborant);
    }

}
export default new DoctorService();