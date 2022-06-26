package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Role;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class RoleDB {
    
    public ArrayList<Role> getAll() throws Exception {
        ArrayList<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM Role";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                
                Role role = new Role(id, name);
                
                roles.add(role);
            }
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            cp.freeConnection(con);
        }

        return roles;
    }
}
