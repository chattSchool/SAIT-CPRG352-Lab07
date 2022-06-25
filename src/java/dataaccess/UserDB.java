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
                String first_name = rs.getString(3);
                String last_name = rs.getString(4);
                String password = rs.getString(5);
                int role = rs.getInt(6);
                
                User user = new User(email, active, first_name, last_name, password, role);
                
                users.add(user);
            }
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            cp.freeConnection(con);
        }
        
        return users;
    };
}
