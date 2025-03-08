package com.example.flightplan.repository;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private com.example.flightplan.repository.Seat seat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public com.example.flightplan.repository.Seat getSeat() {
        return seat;
    }

    public void setSeat(com.example.flightplan.repository.Seat seat) {
        this.seat = seat;
    }

}