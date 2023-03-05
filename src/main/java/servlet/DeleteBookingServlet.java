package servlet;

import JDBC.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="deleteBooking")
public class DeleteBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String from=req.getParameter("from");
        try {
            Database database=new Database();
            database.deleteBooking(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(from.equals("admin"))
        {
            resp.sendRedirect("/adminconsole");
        }
        else{
            resp.sendRedirect("/dashboard");
        }
    }
}
