package servlet;

import JDBC.Database;
import model.Booking;
import model.Product;
import model.User;
import model.Venue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

@WebServlet(name="booking")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Product> events=new ArrayList<>();
            ArrayList<Venue> venues= new ArrayList<>();
            Database database=new Database();
            events=database.getProducts();
            venues=database.getVenues();
            req.setAttribute("eventList",events);
            req.setAttribute("venueList",venues);
            req.getRequestDispatcher("WEB-INF/classes/booking.jsp").forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Database database=new Database();
            database.addBooking((String)req.getSession().getAttribute("name"),Integer.parseInt(req.getParameter("event")),Integer.parseInt(req.getParameter("venue")),Integer.parseInt(req.getParameter("paymentmode")),req.getParameter("date"));
            resp.sendRedirect("/dashboard");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}