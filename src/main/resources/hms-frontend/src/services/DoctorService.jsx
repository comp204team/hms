import axios from 'axios'

const DOCTOR_API_BASE_URL = "http://localhost:8080/api/doctors";

class DoctorService {

    getAllDoctors(){
        return axios.get(DOCTOR_API_BASE_URL);

    }

    createDoctor(doctor){
        return axios.post(DOCTOR_API_BASE_URL, doctor);
    }

}
export default new DoctorService();