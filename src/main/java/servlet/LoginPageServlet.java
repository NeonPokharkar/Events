package servlet;

import JDBC.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/classes/loginpage.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Database database=new Database();
            String name=req.getParameter("name");
            String password=req.getParameter("password");
            String passwordcheck=database.getUserPassword(name);
            System.out.println(passwordcheck+":"+password);
            HttpSession session=req.getSession();
            if(passwordcheck.equals(password)){
                session.setAttribute("name",name);
                session.setAttribute("password",password);
                resp.sendRedirect("/dashboard");
            }
            else {
                resp.sendRedirect("/home");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}