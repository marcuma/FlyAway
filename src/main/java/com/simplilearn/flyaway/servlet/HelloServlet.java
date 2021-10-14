package com.simplilearn.flyaway.servlet;


import com.simplilearn.flyaway.model.User;
import com.simplilearn.flyaway.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.equal(root.get("employeeId"), (int) 2));
        org.hibernate.query.Query<User> query = session.createQuery(cr);
        List<User> employees = query.getResultList();
        session.close();

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("employees.jsp");
        request.setAttribute("employeeData", employees);
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.getWriter().println(e);
        }

    }

    public void destroy() {
    }
}