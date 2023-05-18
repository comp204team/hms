package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.patient.PatientDto;
import com.comp204.comp204hms.dto.room.RoomDto;
import com.comp204.comp204hms.dto.room.RoomRequestDto;
import com.comp204.comp204hms.model.Patient;
import com.comp204.comp204hms.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDto roomToRoomDto(Room room);

    Room roomRequestDtoToRoom(RoomRequestDto roomRequestDto);
}
