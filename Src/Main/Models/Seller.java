package Src.Main.Models;

import java.util.ArrayList;

public class Seller {
    private String name;
    private int price;
    private int quantity;
    private int seller_id;

    private ArrayList<Seller> listofProducts = new ArrayList<Seller>();

    public Seller() {

    }

    public Seller(String name, int price, int quantity, int seller_id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller_id = seller_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
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

    public ArrayList<Seller> getListofProducts() {
        return listofProducts;
    }

    public void setListofProducts(ArrayList<Seller> listofProducts) {
        this.listofProducts = listofProducts;
    }

    public void addProduct(Seller seller){
        listofProducts.add(seller);
    }
    
    public void updateProduct(String itemName) {
        for(Seller seller: listofProducts){
            if(seller.getName().equals(itemName)){
                seller.setName("Playstation 5");
                seller.setPrice(499);
                seller.setQuantity(30);
                seller.setSeller_Id(4);
            }
        }
    }

    public void deleteProduct(Seller seller){
        listofProducts.remove(seller);
    }

    public void printlistofProducts(){
        for(Seller seller: listofProducts){
            System.out.println("Product Name: " + seller.getName());
            System.out.println("Product Price: " + seller.getPrice());
            System.out.println("Product Quantity: " + seller.getQuantity());
            System.out.println("Product Seller ID: " + seller.getSeller_Id());
        }
    }
}
