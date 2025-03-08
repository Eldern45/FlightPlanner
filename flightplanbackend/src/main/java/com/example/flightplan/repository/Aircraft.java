package com.example.flightplan.repository;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "aircrafts")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "total_rows")
    private Integer totalRows;

    @Column(name = "seats_per_row")
    private Integer seatsPerRow;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(Integer seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

}