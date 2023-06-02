package com.example.eksamen2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
    private Boat boat;

    @ManyToOne
    @JoinColumn(name="race_id", nullable=false)
    private Race race;

    private int points;
}
