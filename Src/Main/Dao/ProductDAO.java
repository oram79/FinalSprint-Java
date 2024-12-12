package Src.Main.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Src.Main.Models.Product;
import Src.Main.Utils.DatabaseConnection;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Creating A New Product //
    public void createProduct(Product product) {
        String sql = "INSERT INTO Products (name, price, quantity, seller_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setInt(4, product.getSeller_Id(stmt));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Displaying A Product By ID //
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Products WHERE id = ?";
        Product product = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product(productId, sql, productId, productId, productId);
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSeller_Id(rs.getInt("seller_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    // Displaying All Products For Sale //
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM Products";
        List<Product> products = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(0, sql, 0, 0, 0);
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSeller_Id(rs.getInt("seller_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Updating A Product //
    public void updateProduct(Product product) {
        String sql = "UPDATE Products SET name = ?, price = ?, quantity = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deleting A Product //
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM Products WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Displaying All Products By A Certain Seller //
    public List<Product> getProductsBySellerId(int sellerId) {
        String sql = "SELECT * FROM Products WHERE seller_id = ?";
        List<Product> products = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, sellerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(sellerId, sql, sellerId, sellerId, sellerId);
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSeller_Id(rs.getInt("seller_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
