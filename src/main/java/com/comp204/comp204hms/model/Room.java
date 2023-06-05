package com.comp204.comp204hms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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

    @OneToMany(mappedBy = "room")
    private List<Patient> patients;

    @ManyToOne
    @JoinColumn(name = "nurse_id", referencedColumnName = "id")
    private Nurse nurse;

    //TODO: roomtype maybe
}
