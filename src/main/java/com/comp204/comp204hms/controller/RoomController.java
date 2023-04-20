package com.comp204.comp204hms.controller;

import com.comp204.comp204hms.dto.room.RoomDto;
import com.comp204.comp204hms.dto.room.RoomRequestDto;
import com.comp204.comp204hms.service.RoomService;
import com.comp204.comp204hms.util.ApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.RoomCtrl.CTRL)
public class RoomController {

    private final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody RoomRequestDto roomRequestDto){
        return new ResponseEntity<>(roomService.create(roomRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAll(){
        return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoomDto> update(@PathVariable Long id, @RequestBody RoomRequestDto roomRequestDto){
        roomService.update(id, roomRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDto> delete(@PathVariable Long id){
        roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
