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
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    private int percentage;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discount", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
}
