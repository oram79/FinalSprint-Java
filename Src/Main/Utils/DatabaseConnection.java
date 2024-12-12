// DataBase Connection //
package Src.Main.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * utility file for establishing a connection between the databases and the java program
 */

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/FinalSprint-Java";
    private static final String USER = "postgre";
    private static final String PASSWORD = "Sadie2011!";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
