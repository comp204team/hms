package com.comp204.comp204hms.service;

import com.comp204.comp204hms.dto.patient.PatientDto;
import com.comp204.comp204hms.dto.patient.PatientRequestDto;
import com.comp204.comp204hms.exception.NotFoundException;
import com.comp204.comp204hms.mapper.PatientMapper;
import com.comp204.comp204hms.model.Doctor;
import com.comp204.comp204hms.model.Patient;
import com.comp204.comp204hms.model.Room;
import com.comp204.comp204hms.repository.DoctorRepository;
import com.comp204.comp204hms.repository.PatientRepository;
import com.comp204.comp204hms.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private final RoomRepository roomRepository;

    public PatientService(PatientRepository patientRepository, DoctorRepository doctorRepository, RoomRepository roomRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.roomRepository = roomRepository;
    }

    public PatientDto create(PatientRequestDto patientRequestDto){
        Patient patient = PatientMapper.INSTANCE.toEntity(patientRequestDto);
        if(patientRequestDto.getDoctorId() != null){
            patient.setDoctor(doctorRepository.findById(patientRequestDto.getDoctorId()).orElse(null));
        }
        if(patientRequestDto.getRoomId() != null){
            patient.setRoom(roomRepository.findById(patientRequestDto.getRoomId()).orElse(null));
        }

        return PatientMapper.INSTANCE.toDto(patientRepository.save(patient));

    }

    public List<PatientDto> getAll() {
        return patientRepository.findAll().stream().map(PatientMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public PatientDto getById(Long id){
        return PatientMapper.INSTANCE.toDto(getByIdOrThrowNotFoundError(id));
    }

    public PatientDto update(Long id, PatientRequestDto patientRequestDto){
        Patient patient = getByIdOrThrowNotFoundError(id);

        if(patientRequestDto.getName() != null){
            patient.setName(patientRequestDto.getName());
        }
        if(patientRequestDto.getSurname() != null){
            patient.setSurname(patientRequestDto.getSurname());
        }
        if(patientRequestDto.getEmail() != null){
            patient.setEmail(patientRequestDto.getEmail());
        }
        if(patientRequestDto.getAddress() != null){
            patient.setAddress(patientRequestDto.getAddress());
        }
        if(patientRequestDto.getPhoneNumber() != null){
            patient.setPhoneNumber(patientRequestDto.getPhoneNumber());
        }
        if(patientRequestDto.getDoctorId() != null){
            Doctor doctor = doctorRepository.findById(patientRequestDto.getDoctorId()).orElse(null);
            patient.setDoctor(doctor);
        }
        if(patientRequestDto.getRoomId() != null){
            Room room = roomRepository.findById(patientRequestDto.getRoomId()).orElse(null);
            patient.setRoom(room);
        }

        return PatientMapper.INSTANCE.toDto(patientRepository.save(patient));
    }

    public void deleteById(Long id){
        Patient patient = getByIdOrThrowNotFoundError(id);
        patientRepository.delete(patient);
    }

    protected Patient getByIdOrThrowNotFoundError(Long id){
        return patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient"));
    }
}
