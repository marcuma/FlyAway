package com.simplilearn.flyaway.repository;

import com.simplilearn.flyaway.model.Flight;
import com.simplilearn.flyaway.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

/**
 * Created: 10/15/2021 - 9:48 PM
 * Project: FlyAway
 *
 * @author marcuma
 */
public class FlightRepository {
    private static Session session;

    public FlightRepository() {
        session = HibernateUtil.getSession();
    }
    public List<Flight> findAll() {
        String sql = "From Flight";
        return session.createQuery(sql).getResultList();
    }

    public List<Object[]> findByDate(LocalDate ld, String source, String destination) {
        Session session = HibernateUtil.getSession();
        String sql = new StringBuilder()
                .append("SELECT ")
                .append("flight.flightId, flight.date, source.airportName, dest.airportName, airline.airlineName, flight.price")
                .append(" FROM ")
                .append("Flight flight")
                .append(" JOIN Airport source")
                .append(" ON source.airportId = flight.source")
                .append(" JOIN Airport dest")
                .append(" ON dest.airportId = flight.destination")
                .append(" JOIN Airline airline")
                .append(" ON airline.airlineId = flight.airlineId")
                .append(" where flight.date = '" + ld + "'")
                .append(" and flight.source = " + source)
                .append(" and flight.destination = " + destination).toString();

        Query qry = session.createQuery(sql);
        List<Object[]> result;
        result = qry.getResultList();
        session.close();
        return result;
    }
}
