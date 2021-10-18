package com.simplilearn.flyaway.model;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created: 10/15/2021 - 8:41 AM
 * Project: FlyAway
 *
 * @author marcuma
 */

public class FlightView {

    private Integer flightId;
    private String source;
    private String destination;
    private LocalDate date;
    private String airline;
    private double price;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
