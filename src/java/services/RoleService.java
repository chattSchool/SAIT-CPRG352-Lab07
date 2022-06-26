package services;

import dataaccess.RoleDB;
import java.util.ArrayList;
import models.Role;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class RoleService {
    
    public ArrayList<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        ArrayList<Role> roles = roleDB.getAll();
        
        return roles;
    }
}
