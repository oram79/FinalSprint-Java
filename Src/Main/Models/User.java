package Src.Main.Models;

// Constructors
public class User {
    private String username;
    private String password;
    private String email;
    private String role;

    public User(){
    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    
    // Getters
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
        return "Username: " + this.username + ", Password: " + this.password + ", Email: " + this.email + ", Role: " + this.role;
    }
}
