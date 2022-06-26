package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import services.*;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        //To be deleted, used to test DB methods
        try {
           ArrayList<User> users = us.getAll();
           request.setAttribute("users", users);
           
           User user = us.getUser("cprg352+anne@gmail.com");
           request.setAttribute("user", user);
           
           ArrayList<Role> roles = rs.getAll();
           request.setAttribute("roles", roles);
        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("message", e);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserService us = new UserService();
        RoleService rs = new RoleService();
        String action = request.getParameter("action");
        
        try {
            if(action != null) {
                switch(action) {
                    case "add":
                        boolean active = true; //Newly added user is assumed to be active upon adding to DB
                        String email = request.getParameter("new_email");
                        String firstName = request.getParameter("new_fname");
                        String lastName = request.getParameter("new_lname");
                        String password = request.getParameter("new_password");
                        int role = Integer.parseInt(request.getParameter("new_roles"));
                        us.addUser(email, active, firstName, lastName, password, role);
                    case "update":
                    case "delete":
                }
                session.setAttribute("message", action);
            }
        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("message", e);
        }
        
        response.sendRedirect("users");
        return;
    }
}
