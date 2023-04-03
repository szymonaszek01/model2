package com.oro.model2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Discount discount;

    @ManyToOne
    private Reservation reservation;

    @ManyToOne
    private Screening screening;

    @ManyToOne
    private Seat seat;
}
