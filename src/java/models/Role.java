package models;

import java.io.Serializable;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class Role implements Serializable {
    private int role_id;
    private String role_name;
    
    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }
}
