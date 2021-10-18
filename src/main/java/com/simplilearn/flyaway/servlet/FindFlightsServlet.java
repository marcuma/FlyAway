package com.simplilearn.flyaway.servlet;
/**
 * Created: 10/14/2021 - 4:24 PM
 * Project: FlyAway
 *
 * @author marcuma
 */


import com.simplilearn.flyaway.model.FlightView;
import com.simplilearn.flyaway.repository.FlightRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindFlightsServlet", value = "/findFlights")
public class FindFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        LocalDate ld = null;
        String date = request.getParameter("date");
        if (!date.isEmpty()) { ld = LocalDate.parse(date); }
        String source = request.getParameter("source");
        String dest = request.getParameter("destination");

        List<FlightView> queriedFlights = new ArrayList<>();
        FlightRepository flights = new FlightRepository();
        if (date.isEmpty() || source.isEmpty() || dest.isEmpty()) {
            request.getSession().setAttribute("errorMessage", "Date, Source, and Destination are required");
            response.sendRedirect("index.jsp");
        } else {
            List<Object[]> list = flights.findByDate(ld, source, dest);
            FlightView fv = new FlightView();
            for (Object[] flight : list) {
                fv.setFlightId((Integer) flight[0]);
                LocalDate localDate = LocalDate.parse(flight[1].toString());
                fv.setDate(localDate);
                fv.setSource(flight[2].toString());
                fv.setDestination(flight[3].toString());
                fv.setAirline(flight[4].toString());
                fv.setPrice(Double.parseDouble(flight[5].toString()));
                queriedFlights.add(fv);

            }
            request.getSession().setAttribute("flights", queriedFlights);
            response.sendRedirect("flights.jsp");
        }
    }
}

