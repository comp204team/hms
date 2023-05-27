package com.comp204.comp204hms.data;

import com.comp204.comp204hms.model.*;
import com.comp204.comp204hms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(1)
public class DataInitial implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private RoomRepository roomRepository;



    @Override
    public void run(String... args) throws Exception {
        Optional<Department> dbDept = departmentRepository.findById(1L);
        Optional<Room> dbRoom = roomRepository.findById(1L);
        Optional<Doctor> dbDoctor = doctorRepository.findById(1L);
        Optional<Patient> dbPatient = patientRepository.findById(1L);
        Optional<Report> dbReport = reportRepository.findById(1L);

        if(!dbDept.isPresent()){
            Department department = Department.builder()
                    .id(1L)
                    .name("Cardiology")
                    .description("about hearth")
                    .build();
            departmentRepository.save(department);
        }
        if(!dbRoom.isPresent()){
            Room room = Room.builder()
                    .id(1L)
                    .roomNumber("1")
                    .build();
            roomRepository.save(room);
        }
        if(!dbDoctor.isPresent()){
            Doctor doctor = Doctor.builder()
                    .id(1L)
                    .tckn("1")
                    .name("Berke")
                    .surname("Yıldırım")
                    .department(departmentRepository.findById(1L).orElse(null))
                    .build();
            doctorRepository.save(doctor);
        }
        if(!dbPatient.isPresent()){
            Patient patient = Patient.builder()
                    .id(1L)
                    .tckn("1")
                    .name("Mustafa")
                    .surname("Karaçukur")
                    .room(roomRepository.findById(1L).orElse(null))
                    .address("Trabzon")
                    .phoneNumber("123456789")
                    .build();
            patientRepository.save(patient);
        }
        if(!dbReport.isPresent()){
            Report report = Report.builder()
                    .id(1L)
                    .disease("Influenza")
                    .description("Disase description")
                    .photoUrl("https://static.vecteezy.com/system/resources/previews/004/493/181/original/hospital-building-for-healthcare-background-illustration-with-ambulance-car-doctor-patient-nurses-and-medical-clinic-exterior-free-vector.jpg")
                    .patient(patientRepository.findById(1L).orElse(null))
                    .doctor(doctorRepository.findById(1L).orElse(null))
                    .build();
            reportRepository.save(report);
        }


    }
}
