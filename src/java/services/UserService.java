package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class UserService {
    
    public ArrayList<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        ArrayList<User> users = userDB.getAll();
        return users;
    }
}
