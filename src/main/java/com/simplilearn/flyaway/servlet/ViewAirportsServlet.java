package com.simplilearn.flyaway.servlet; /**
 * Created: 10/18/2021 - 2:49 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

import com.simplilearn.flyaway.model.Airline;
import com.simplilearn.flyaway.model.Airport;
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

@WebServlet(name = "ViewAirportsServlet", value = "/viewAirports")
public class ViewAirportsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Airport> cr = cb.createQuery(Airport.class);
        Root<Airport> root = cr.from(Airport.class);
        cr.select(root);

        org.hibernate.query.Query<Airport> query = session.createQuery(cr);
        List<Airport> list = query.getResultList();
        request.getSession().setAttribute("airports", list);
        response.sendRedirect("ViewAirports.jsp");
    }
}
