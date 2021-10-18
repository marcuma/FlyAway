package com.simplilearn.flyaway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created: 10/14/2021 - 4:04 PM
 * Project: FlyAway
 *
 * @author marcuma
 */
@Entity
@Table(name="tbl_airport")
public class Airport {
    @Id
    @Column(name="airport_id")
    private int airportId;
    @Column(name="airport_code")
    private String airportCode;
    @Column(name="airport_name")
    private String airportName;
    @Column(name="airport_location")
    private String airportLocation;

    public Airport() {
        super();
    }

    public int getAirport_id() {
        return airportId;
    }

    public void setAirport_id(int airport_id) {
        this.airportId = airport_id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }
}
