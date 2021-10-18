package com.simplilearn.flyaway.model;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created: 10/15/2021 - 8:41 AM
 * Project: FlyAway
 *
 * @author marcuma
 */
@Entity
@Table(name = "tbl_flight")
public class Flight {
    @Id
    @Column(name="flight_id")
    private Integer flightId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_source", referencedColumnName = "airport_id")
    private Airport source;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_destination", referencedColumnName = "airport_id")
    private Airport destination;
    @Column(name="date")
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_airline_id", referencedColumnName = "airline_id")
    private Airline airlineId;
    @Column(name="price")
    private double price;

    public Flight() {}
    public Integer getFlight_Id() {
        return flightId;
    }

    public void setFlight_Id(Integer flight_Id) {
        this.flightId = flight_Id;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Airline getAirline() {
        return airlineId;
    }

    public void setAirline(Airline airline) {
        this.airlineId = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
