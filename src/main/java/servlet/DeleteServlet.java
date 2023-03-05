package servlet;

import JDBC.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="deleteEvent")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        try {
            Database database=new Database();
            database.deleteProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/adminconsole");
    }
}
