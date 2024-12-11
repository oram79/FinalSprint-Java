package Src.Main.Services;

import java.sql.SQLException;
import java.util.List;

import Src.Main.Dao.UserDAO;
import Src.Main.Models.User;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(int ID, String username, String password, String email, String role) throws SQLException{
        User user = new User(ID, username, password, email, role);
        userDAO.createUser(user);
        System.out.println("User Added!");
    }

    public void removeUser(int ID) throws SQLException{
        userDAO.deleteUser(ID);
        System.out.println("User Removed!");
    }

    public void updateUser(int ID, String username, String password, String email, String role) throws SQLException{
        User user = new User(ID, username, password, email, role);
        userDAO.updateUser(user);
        System.out.println("User Updated!");
    }

    public void viewUser(int ID, String username, String password, String email, String role) throws SQLException{
        List<User> users = userDAO.getAllUsers();
        System.out.println("LISTED USERS:");
        for (User user : users) {
            System.out.println("~~~~~~~~~~~");
            System.out.println("ID: " + user.getID());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Role: " + user.getRole());
        }
    }
}
