package dataaccess;

import java.sql.*;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class UserDB {
    
    public ArrayList<User> getAll() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM User";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                String email = rs.getString(1);
                boolean active = rs.getBoolean(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String password = rs.getString(5);
                int role = rs.getInt(6);
                
                User user = new User(email, active, firstName, lastName, password, role);
                
                users.add(user);
            }
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            cp.freeConnection(con);
        }
        
        return users;
    };
    
    public User getUser(String userEmail) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM User WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userEmail);
            rs = ps.executeQuery();
            
            rs.next();
            
            String email = rs.getString(1);
            boolean active = rs.getBoolean(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String password = rs.getString(5);
            int role = rs.getInt(6);
            
            user = new User(email, active, firstName, lastName, password, role);
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            cp.freeConnection(con);
        }
        
        return user;
    }
    
    public void addUser(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO User (email, active, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.isActive());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole());
            ps.executeUpdate();
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
