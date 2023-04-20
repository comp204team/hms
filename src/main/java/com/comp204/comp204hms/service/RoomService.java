package com.comp204.comp204hms.service;

import com.comp204.comp204hms.dto.room.RoomDto;
import com.comp204.comp204hms.dto.room.RoomRequestDto;
import com.comp204.comp204hms.exception.NotFoundException;
import com.comp204.comp204hms.mapper.RoomMapper;
import com.comp204.comp204hms.model.Room;
import com.comp204.comp204hms.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDto create(RoomRequestDto roomRequestDto){
        Room room = RoomMapper.INSTANCE.roomRequestDtoToRoom(roomRequestDto);
        room = roomRepository.save(room);
        return RoomMapper.INSTANCE.roomToRoomDto(room);
    }

    public List<RoomDto> getAll(){
        return roomRepository.findAll().stream().map(RoomMapper.INSTANCE::roomToRoomDto).collect(Collectors.toList());
    }

    public void update(Long id, RoomRequestDto roomRequestDto){
        Room room = getRoomByIdOrThrowNotFoundError(id);

        if(roomRequestDto.getRoomNumber() != null){
            room.setRoomNumber(roomRequestDto.getRoomNumber());
        }

        roomRepository.save(room);
    }

    public void delete(Long id){
        Room room = getRoomByIdOrThrowNotFoundError(id);

        roomRepository.delete(room);
    }


    private Room getRoomByIdOrThrowNotFoundError(Long id){
        return roomRepository.findById(id).orElseThrow(() -> new NotFoundException("Room",
                "No room found with this id"));
    }
}
