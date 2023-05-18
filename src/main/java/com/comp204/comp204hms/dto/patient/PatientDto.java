package com.comp204.comp204hms.dto.patient;

import com.comp204.comp204hms.dto.doctor.DoctorDto;
import com.comp204.comp204hms.dto.room.RoomDto;
import com.comp204.comp204hms.model.Doctor;
import com.comp204.comp204hms.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private DoctorDto doctor;
    private RoomDto room;
}
