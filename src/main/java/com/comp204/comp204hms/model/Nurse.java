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
@Table(name = "nurses")
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tckn", unique = true)
    private String tckn;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "nurse")
    private List<Room> rooms;
}
