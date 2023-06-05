package com.comp204.comp204hms.dto.room;

import com.comp204.comp204hms.dto.nurse.NurseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDto {

    private Long id;

    private String roomNumber;

    private NurseDto nurse;
}
