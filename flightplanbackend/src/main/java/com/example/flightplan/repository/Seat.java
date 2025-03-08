package com.example.flightplan.repository;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(name = "letter", length = 1)
    private String letter;

    @Column(name = "is_window")
    private Boolean isWindow;

    @Column(name = "is_legroom")
    private Boolean isLegroom;

    @Column(name = "is_near_exit")
    private Boolean isNearExit;

    @Column(name = "is_sbs")
    private Boolean isSbs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Boolean getIsWindow() {
        return isWindow;
    }

    public void setIsWindow(Boolean isWindow) {
        this.isWindow = isWindow;
    }

    public Boolean getIsLegroom() {
        return isLegroom;
    }

    public void setIsLegroom(Boolean isLegroom) {
        this.isLegroom = isLegroom;
    }

    public Boolean getIsNearExit() {
        return isNearExit;
    }

    public void setIsNearExit(Boolean isNearExit) {
        this.isNearExit = isNearExit;
    }

    public Boolean getIsSbs() {
        return isSbs;
    }

    public void setIsSbs(Boolean isSbs) {
        this.isSbs = isSbs;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

}