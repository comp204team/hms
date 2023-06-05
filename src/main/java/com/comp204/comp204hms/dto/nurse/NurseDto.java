package com.comp204.comp204hms.dto.nurse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurseDto {
    private Long id;

    private String tckn;

    private String name;

    private String surname;
}
