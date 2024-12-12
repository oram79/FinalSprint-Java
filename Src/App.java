package Src;

import java.util.List;
import java.util.Scanner;

import Src.Main.Models.Product;
import Src.Main.Models.User;
import Src.Main.Services.ProductService;
import Src.Main.Services.UserService;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(null);
        ProductService productService = new ProductService(null);

        System.out.println("Welcome to the E-Commerce Platform!");

        // Login or Register
        User loggedInUser = null;
        while (loggedInUser == null) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Login
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                loggedInUser = userService.addUser(username, password);
                if (loggedInUser == null) {
                    System.out.println("Invalid username or password. Try again.");
                }
            } else if (choice == 2) {
                // Register
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter role (buyer/seller/admin): ");
                String role = scanner.nextLine();
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setPassword(password);
                newUser.setEmail(email);
                newUser.setRole(role);

                userService.registerUser(newUser);
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        // Role-based menu
        boolean exit = false;
        while (!exit) {
            if ("buyer".equalsIgnoreCase(loggedInUser.getRole())) {
                // Buyer Menu
                System.out.println("\nBuyer Menu:");
                System.out.println("1. View All Products");
                System.out.println("2. Search Product by Name");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        List<Product> products = productService.getAllProducts();
                        for (Product product : products) {
                            System.out.println(product);
                        }
                        break;
                    case 2:
                        System.out.print("Enter product name to search: ");
                        String productName = scanner.nextLine();
                        List<Product> searchedProducts = productService.searchProductsByName(productName);
                        for (Product product : searchedProducts) {
                            System.out.println(product);
                        }
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } else if ("seller".equalsIgnoreCase(loggedInUser.getRole())) {
                // Seller Menu
                System.out.println("\nSeller Menu:");
                System.out.println("1. Add Product");
                System.out.println("2. View My Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        Product newProduct = new Product(quantity, name, price, quantity, quantity);
                        newProduct.setName(name);
                        newProduct.setPrice(price);
                        newProduct.setQuantity(quantity);
                        newProduct.getSeller_Id(loggedInUser.getId());

                        productService.addProduct(newProduct);
                        break;
                    case 2:
                        List<Product> myProducts = productService.getProductsBySellerId(loggedInUser.getId());
                        for (Product product : myProducts) {
                            System.out.println(product);
                        }
                        break;
                    case 3:
                        System.out.print("Enter product ID to update: ");
                        int productIdToUpdate = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        System.out.print("Enter new product name: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        double updatedPrice = scanner.nextDouble();
                        System.out.print("Enter new quantity: ");
                        int updatedQuantity = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        Product updatedProduct = new Product();
                        updatedProduct.setId(productIdToUpdate);
                        updatedProduct.setName(updatedName);
                        updatedProduct.setPrice(updatedPrice);
                        updatedProduct.setQuantity(updatedQuantity);

                        productService.updateProduct(updatedProduct);
                        break;
                    case 4:
                        System.out.print("Enter product ID to delete: ");
                        int productIdToDelete = scanner.nextInt();
                        productService.deleteProduct(productIdToDelete);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } else if ("admin".equalsIgnoreCase(loggedInUser.getRole())) {
                // Admin Menu
                System.out.println("\nAdmin Menu:");
                System.out.println("1. View All Users");
                System.out.println("2. Delete User");
                System.out.println("3. View All Products");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        List<User> users = userService.getAllUsers();
                        for (User user : users) {
                            System.out.println(user);
                        }
                        break;
                    case 2:
                        System.out.print("Enter user ID to delete: ");
                        int userIdToDelete = scanner.nextInt();
                        userService.deleteUser(userIdToDelete);
                        break;
                    case 3:
                        List<Product> allProducts = productService.getAllProducts();
                        for (Product product : allProducts) {
                            System.out.println(product);
                        }
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
