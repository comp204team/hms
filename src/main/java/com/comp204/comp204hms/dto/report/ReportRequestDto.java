package com.comp204.comp204hms.dto.report;

import com.comp204.comp204hms.dto.doctor.DoctorDto;
import com.comp204.comp204hms.dto.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequestDto {
    private String disease;
    private String description;
    private String photoUrl;

    private Long doctorId;

    private Long patientId;
}
