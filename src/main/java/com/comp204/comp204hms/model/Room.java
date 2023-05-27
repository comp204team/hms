package com.comp204.comp204hms.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_number", unique = true)
    private String roomNumber;

    @OneToOne(mappedBy = "room")
    private Patient patient;

    //TODO: roomtype maybe
}
