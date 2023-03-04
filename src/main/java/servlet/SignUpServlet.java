package servlet;

import JDBC.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="home")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Database database=new Database();
            database.addUser(req.getParameter("name"),req.getParameter("password"),0,req.getParameter("phone"),req.getParameter("address"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("WEB-INF/classes/homepage.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/classes/signupage.jsp").forward(req,resp);
    }
}