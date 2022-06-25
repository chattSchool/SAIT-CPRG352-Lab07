package models;

import java.io.Serializable;

/**
 *
 * @author Dakota Chatt
 * @version June 25, 2022
 */
public class User implements Serializable {
    private String email;
    private boolean active;
    private String first_name;
    private String last_name;
    private String password;
    private int role;
    
    public User(String email, boolean active, String first_name, String last_name, String password, int role) {
        this.email = email;
        this.active = active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
