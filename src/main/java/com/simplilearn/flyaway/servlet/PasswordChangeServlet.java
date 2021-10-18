package com.simplilearn.flyaway.servlet; /**
 * Created: 10/18/2021 - 12:30 PM
 * Project: FlyAway
 *
 * @author marcuma
 */

import com.simplilearn.flyaway.model.User;
import com.simplilearn.flyaway.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PasswordChangeServlet", value = "/changePassword")
public class PasswordChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        if (newPassword.isEmpty()) {
            request.getSession().setAttribute("errorMessage", "Password field must have a value");
            response.sendRedirect("ChangePassword.jsp");
        } else {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            User user = session.load(User.class, Integer.parseInt(request.getParameter("id")));
            user.setPassword(request.getParameter("newPassword"));
            session.save(user);
            tx.commit();
            session.close();
            response.sendRedirect("AdminLogin.jsp");

        }
    }
}
