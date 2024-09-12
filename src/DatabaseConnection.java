import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    

    private static final String URL = "jdbc:mysql://localhost:3306/assignment"; 
    private static final String USER = "ahmadmohsin"; 
    private static final String PASSWORD = "Allah786"; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void main(String[] args) {
        
        Connection connection = getConnection();
        
        if (connection != null) {
            System.out.println("Connected to the database successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
