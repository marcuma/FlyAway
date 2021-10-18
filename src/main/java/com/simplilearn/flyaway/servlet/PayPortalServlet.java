package com.simplilearn.flyaway.servlet; /**
 * Created: 10/18/2021 - 11:51 AM
 * Project: FlyAway
 *
 * @author marcuma
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PayPortalServlet", value = "/pay")
public class PayPortalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        request.getSession().setAttribute("firstName", firstName);
        request.getSession().setAttribute("lastName", lastName);
        request.getSession().setAttribute("address", address);
        request.getSession().setAttribute("city", city);
        request.getSession().setAttribute("state", state);
        request.getSession().setAttribute("zip", zip);
        response.sendRedirect("confirmation.jsp");


    }
}
