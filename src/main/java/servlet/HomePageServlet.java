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

@WebServlet(name="home")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String users="";
        try {
            Database database=new Database();
            ArrayList<User> userArrayList=database.getUsers();
            for(int i=0;i<userArrayList.size();i++)
            {
                users+="Name: "+userArrayList.get(i).name+", Password: "+userArrayList.get(i).password+";\n";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("users",users);
        req.getRequestDispatcher("WEB-INF/classes/homepage.jsp").forward(req,resp);
    }
}
