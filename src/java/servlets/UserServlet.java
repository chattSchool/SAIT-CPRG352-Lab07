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
        String action = request.getParameter("action");
        
        try {
           //Gets all users
           ArrayList<User> users = us.getAll();
           request.setAttribute("users", users);
         
           //Gets all role names
           ArrayList<Role> roles = rs.getAll();
           request.setAttribute("roles", roles);
           
           if(action != null) {
            
                if(action.equals("delete")) {
                    String userEmail = request.getParameter("userEmail");
                    System.out.println(userEmail);
                    us.deleteUser(userEmail);
                    users = us.getAll();
                    request.setAttribute("users", users);
                    
                    response.sendRedirect("users");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("message", e);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        session.setAttribute("message", null);
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
                        Role role = rs.getRole(Integer.parseInt(request.getParameter("new_roles")));
                        us.addUser(email, active, firstName, lastName, password, role);
                    case "update":

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
