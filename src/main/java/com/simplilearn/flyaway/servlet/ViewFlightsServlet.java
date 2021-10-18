package com.simplilearn.flyaway.servlet; /**
 * Created: 10/18/2021 - 2:50 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

import com.simplilearn.flyaway.model.Airline;
import com.simplilearn.flyaway.model.Flight;
import com.simplilearn.flyaway.repository.FlightRepository;
import com.simplilearn.flyaway.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewFlightsServlet", value = "/viewFlights")
public class ViewFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightRepository repo = new FlightRepository();
        List<Flight> flights = repo.findAll();
        request.getSession().setAttribute("flights", flights);
        response.sendRedirect("ViewFlights.jsp");
    }
}
