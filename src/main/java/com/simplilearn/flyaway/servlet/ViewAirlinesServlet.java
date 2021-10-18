package com.simplilearn.flyaway.servlet; /**
 * Created: 10/18/2021 - 2:30 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

import com.simplilearn.flyaway.model.Airline;
import com.simplilearn.flyaway.model.User;
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

@WebServlet(name = "ViewAirlinesServlet", value = "/viewAirlines")
public class ViewAirlinesServlet extends HttpServlet {

    public ViewAirlinesServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Session session = HibernateUtil.getSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Airline> cr = cb.createQuery(Airline.class);
//        Root<Airline> root = cr.from(Airline.class);
//        cr.select(root);
//
//        org.hibernate.query.Query<Airline> query = session.createQuery(cr);
//        List<Airline> list = query.getResultList();
//        request.getSession().setAttribute("airlines", list);
//        response.sendRedirect("ViewAirlines.jsp");
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Airline> cr = cb.createQuery(Airline.class);
        Root<Airline> root = cr.from(Airline.class);
        cr.select(root);

        org.hibernate.query.Query<Airline> query = session.createQuery(cr);
        List<Airline> list = query.getResultList();
        request.getSession().setAttribute("airlines", list);
        response.sendRedirect("ViewAirlines.jsp");
    }
}
