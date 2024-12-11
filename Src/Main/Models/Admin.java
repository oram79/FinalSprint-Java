package Src.Main.Models;

import java.util.ArrayList;

public class Admin {
    private int ID;
    private String username;
    private String password;
    private String email;
    private String role;
    private String name;
    private double price;
    private int quantity;
    private int seller_id;

    private ArrayList<Admin> listofUsers = new ArrayList<Admin>();
    private ArrayList<Admin> listofProducts = new ArrayList<Admin>();

    public Admin() {
    }

    public Admin(int ID, String username, String password, String email, String role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Admin(String name, double price, int quantity, int seller_id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller_id = seller_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSeller_Id() {
        return this.seller_id;
    }

    public void setSeller_Id(int seller_id) {
        this.seller_id = seller_id;
    }

    public ArrayList<Admin> getListofUsers() {
        return listofUsers;
    }

    public void setListofUsers(ArrayList<Admin> listofUsers) {
        this.listofUsers = listofUsers;
    }

    public ArrayList<Admin> getListofProducts() {
        return listofProducts;
    }

    public void setListofProducts(ArrayList<Admin> listofProducts) {
        this.listofProducts = listofProducts;
    }

    public void addUser(Admin admin){
        listofUsers.add(admin);
    }

    public void deleteUser(Admin admin){
        listofUsers.remove(admin);
    }

    public void printlistofUsers(){
        for(Admin admin: listofUsers){
            System.out.println("User ID: " + admin.getID());
            System.out.println("User Name: " + admin.getUsername());
            System.out.println("User Password: " + admin.getPassword());
            System.out.println("User Email: " + admin.getEmail());
            System.out.println("User Role: " + admin.getRole());
        }
    }

    public void addProduct(Admin admin){
        listofProducts.add(admin);
    }

    public void printlistofProducts(){
        for(Admin admin: listofProducts){
            System.out.println("Product Name: " + admin.getName());
            System.out.println("Product Price: " + admin.getPrice());
            System.out.println("Product Quantity: " + admin.getQuantity());
            System.out.println("Product Seller ID: " + admin.getSeller_Id());
        }
    }
}
