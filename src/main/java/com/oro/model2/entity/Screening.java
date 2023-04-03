package com.oro.model2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String film;

    private LocalDate start;

    private LocalDate end;

    @ManyToOne
    private Auditorium auditorium;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "screening", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
}
