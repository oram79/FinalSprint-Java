package Src.Main.Models;

/**
 * class for program admins
 */

public class Admin extends User {
    public Admin(int ID, String username, String password, String email, String role) {
        super(ID, username, password, email, role);
    }
}
