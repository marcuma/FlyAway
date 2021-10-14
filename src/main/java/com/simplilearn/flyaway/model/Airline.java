package com.simplilearn.flyaway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created: 10/14/2021 - 2:53 PM
 * Project: FlyAway
 *
 * @author marcuma
 */
@Entity
@Table(name = "tbl_airline")
public class Airline {

    @Id
    private int airline_id;
    @Column(name = "airline_name")
    private String airlineName;

    public Airline() {
        super();
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
