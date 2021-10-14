package com.simplilearn.flyaway.servlet; /**
 * Created: 10/14/2021 - 2:50 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

import com.simplilearn.flyaway.model.Airline;
import com.simplilearn.flyaway.model.Airport;
import com.simplilearn.flyaway.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Airline> cr = cb.createQuery(Airline.class);
        Root<Airline> root = cr.from(Airline.class);
        cr.select(root);
        org.hibernate.query.Query<Airline> query = session.createQuery(cr);
        List<Airline> airlines;
        airlines = query.getResultList();
        request.getSession().setAttribute("airlines", airlines);

        CriteriaQuery<Airport> apCq = cb.createQuery(Airport.class);
        Root<Airport> apRoot = apCq.from(Airport.class);
        apCq.select(apRoot);
        org.hibernate.query.Query<Airport> apQuery = session.createQuery(apCq);
        List<Airport> airports = apQuery.getResultList();
        request.getSession().setAttribute("airports", airports);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
