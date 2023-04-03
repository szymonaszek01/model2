package com.oro.model2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    private BigDecimal cost;

    private LocalDateTime reservationStart;

    private LocalDateTime reservationEnd;

    @ManyToOne
    private Auditorium auditorium;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "screening", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
}
