package Src.Main.Models;

/**
 * class for users on the program
 */

// Constructors
public class User {
    private int ID;
    private String username;
    private String password;
    private String email;
    private String role;

    public User(){
    }

    public User(int ID, String username, String password, String email, String role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    
    // Getters
    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public String getRole() {
        return role;
    }

    // Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    // Output
    public String toString() {
        return "ID: " + this.ID + ", Username: " + this.username + ", Password: " + this.password + ", Email: " + this.email + ", Role: " + this.role;
    }
}