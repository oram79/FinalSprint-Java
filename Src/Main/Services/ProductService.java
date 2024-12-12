package Src.Main.Services;

import java.sql.SQLException;
import java.util.List;

import Src.Main.Dao.ProductDAO;
import Src.Main.Models.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(int id, String name, double price, int quantity, int seller_id) throws SQLException{
        Product product = new Product(id, name, price, quantity, seller_id);
        productDAO.createProduct(product);
        System.out.println("Product Listed!");
    }

    public void removeProduct(int id) throws SQLException{
        productDAO.deleteProduct(id);
        System.out.println("Product Removed!");
    }

    public void updateProduct(int id, String name, double price, int quantity, int seller_id) throws SQLException{
        Product product = new Product(id, name, price, quantity, seller_id);
        productDAO.updateProduct(product);
        System.out.println("Product Updated!");
    }

    public void viewProduct(int id, String name, double price, int quantity, int seller_id) throws SQLException{
        List<Product> products = productDAO.getAllProducts();
        System.out.println("LISTED PRODUCTS:");
        for (Product product : products) {
            System.out.println("~~~~~~~~~~~");
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
        }
    }

    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    public List<Product> searchProductsByName(String productName) {
        throw new UnsupportedOperationException("Unimplemented method 'searchProductsByName'");
    }

    public List<Product> getProductsBySellerId(Object id) {
        throw new UnsupportedOperationException("Unimplemented method 'getProductsBySellerId'");
    }

    public void updateProduct(Product updatedProduct) {
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    public void addProduct(Product newProduct) {
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    public void deleteProduct(int productIdToDelete) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }
}
