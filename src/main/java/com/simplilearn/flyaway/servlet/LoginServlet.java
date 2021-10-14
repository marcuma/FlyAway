package com.simplilearn.flyaway.servlet; /**
 * Created: 10/09/2021 - 3:51 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

import com.simplilearn.flyaway.model.User;
import com.simplilearn.flyaway.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
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

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.equal(root.get("userName"), userName));

        org.hibernate.query.Query<User> query = session.createQuery(cr);
        User user;
        try {
            user = query.getSingleResult();
        if (user.getUserName().equals(request.getParameter("userName"))
            && user.getPassword().equals(request.getParameter("password")))
            response.sendRedirect("AdminHome.jsp");
        } catch (NoResultException ex) {
            response.sendRedirect("error/error.jsp?message=Username or Password incorrect");
        }
        session.close();
    }
}

