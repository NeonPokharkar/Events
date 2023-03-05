package servlet;

import JDBC.Database;
import model.Booking;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Database database=new Database();
            HttpSession session=req.getSession();
            String name=(String)session.getAttribute("name");
            ArrayList<Booking> bookings=database.getBookingsName(name);
            req.setAttribute("bookingsList",bookings);
            req.setAttribute("name",name);
            req.getRequestDispatcher("WEB-INF/classes/dashboard.jsp").forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        resp.sendRedirect("/home");
    }
}