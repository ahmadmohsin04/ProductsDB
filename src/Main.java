import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        ProductDAO productDAO = new ProductDAO();
        
        productDAO.createProduct(connection);
        
        productDAO.readProduct(connection);
        
        productDAO.updateProduct(connection);
        
        productDAO.deleteProduct(connection);
    }
}

