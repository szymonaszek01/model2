package com.oro.model2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int row;

    private int number;

    @ManyToOne
    private Auditorium auditorium;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
}
