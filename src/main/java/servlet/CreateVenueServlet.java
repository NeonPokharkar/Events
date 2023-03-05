package servlet;

import JDBC.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="createVenue")
public class CreateVenueServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        try {
            Database database=new Database();
            database.addVenue(name, address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/adminconsole");
    }
}
