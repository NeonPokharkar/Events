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

@WebServlet(name="adminconsole")
public class AdminConsoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Database database =new Database();
            ArrayList<Product> products=database.getProducts();
            ArrayList<Venue> venues=database.getVenues();
            ArrayList<Booking> bookings= database.getBookings();
            req.setAttribute("bookingsList",bookings);
            req.setAttribute("eventList",products);
            req.setAttribute("venueList",venues);
            req.getRequestDispatcher("WEB-INF/classes/adminconsole.jsp").forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
