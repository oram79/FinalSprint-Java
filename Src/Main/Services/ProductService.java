package Src.Main.Services;

import java.sql.SQLException;
import java.util.List;

import Src.Main.Dao.ProductDAO;
import Src.Main.Models.Product;

public class ProductService {
    private final productDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(int id, String name, int price, int quantity, int seller_id){
        Product product = new Product(id, name, price, quantity, seller_id);
        try {
            productDAO.addProduct(product);
            System.out.println("Product Listed!");
        } catch (SQLException e) {
            System.err.println("ERROR: Product Couldn't be Listed.");
        }
    }

    public void removeProduct(int id){
        try {
            productDAO.deleteProduct(id);
            System.out.println("Product Removed!");
        } catch (SQLException e) {
            System.err.println("ERROR: Product Couldn't be Removed.");
        }
    }

    public void updateProduct(int id, String name, int price, int quantity, int seller_id){
        Product product = new Product(id, name, price, quantity, seller_id);
        try {
            productDAO.updateProduct(product);
            System.out.println("Product Updated!");
        } catch (SQLException e) {
            System.err.println("ERROR: Product Couldn't be Updated.");
        }
    }

    public void viewProduct(int id, String name, int price, int quantity, int seller_id){
        try {
            List<Product> products = productDAO.getAllProducts();
            System.out.println("LISTED PRODUCTS:");
            for (Product product : products) {
                System.out.println("~~~~~~~~~~~");
                System.out.println("Name: " + product.getName());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Products Couldn't be Listed.");
        }
    }
}
