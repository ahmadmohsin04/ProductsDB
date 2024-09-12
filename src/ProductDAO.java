import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDAO {

    public void createProduct(Connection connection) {
Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Product ID: ");
    int id = scanner.nextInt();
        scanner.nextLine();  

    System.out.println("Enter Product Name: ");
    String name = scanner.nextLine();

        System.out.println("Enter Product Category: ");
     String category = scanner.nextLine();

System.out.println("Enter Product Price: ");
double price = scanner.nextDouble();

String sql = "INSERT INTO product (id, name, category, price) VALUES (?, ?, ?, ?)";

try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, category);
            pstmt.setDouble(4, price);
            pstmt.executeUpdate();
            System.out.println("Product inserted successfully!");
        } catch (SQLException e) {
            System.out.println("Error inserting product!");
            e.printStackTrace();
        }
    }

    
public void readProduct(Connection connection) {
Scanner scanner = new Scanner(System.in);

    System.out.println("Search by (1) ID (2) Name (3) Category");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

String sql = "";
        switch (choice) {
            case 1:
                System.out.println("Enter Product ID: ");
                int id = scanner.nextInt();
                sql = "SELECT * FROM product WHERE id = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Category: " + rs.getString("category"));
                        System.out.println("Price: " + rs.getDouble("price"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Enter Product Name: ");
                String name = scanner.nextLine();
                sql = "SELECT * FROM product WHERE name = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, name);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Category: " + rs.getString("category"));
                        System.out.println("Price: " + rs.getDouble("price"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Enter Product Category: ");
                String category = scanner.nextLine();
                sql = "SELECT * FROM product WHERE category = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, category);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Category: " + rs.getString("category"));
                        System.out.println("Price: " + rs.getDouble("price"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

 
    public void updateProduct(Connection connection) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Product ID to update: ");
    int id = scanner.nextInt();
     scanner.nextLine();  

    System.out.println("Enter new Product Name: ");
    String name = scanner.nextLine();

     System.out.println("Enter new Product Category: ");
    String category = scanner.nextLine();

        System.out.println("Enter new Product Price: ");
        double price = scanner.nextDouble();

     String sql = "UPDATE product SET name = ?, category = ?, price = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, category);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Product updated successfully! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void deleteProduct(Connection connection) {
     Scanner scanner = new Scanner(System.in);

     System.out.println("Enter Product ID to delete: ");
    int id = scanner.nextInt();

    System.out.println("Are you sure you want to delete this product? (yes/no)");
     String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("yes")) {
            String sql = "DELETE FROM product WHERE id = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Product deleted successfully! Rows affected: " + rowsAffected);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Deletion canceled.");
        }
    }
}
