package servlet;

import JDBC.Database;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="createEvent")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String price=req.getParameter("price");
        String description=req.getParameter("description");
        try {
            Database database=new Database();
            database.addEvent(name,description,price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/adminconsole");
    }
}
