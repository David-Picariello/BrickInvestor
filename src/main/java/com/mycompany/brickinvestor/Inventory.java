/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brickinvestor;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author davidpicariello
 */
public class Inventory {
    //fields
    private static Inventory instance;
    private ArrayList<Order> orders;
    private ArrayList<Sale> sales;
    private ArrayList<Order> inventory;
    private float totalAmountInvested;
    private int totalQuantity;
    
    private Inventory(){
        orders = new ArrayList<>();
        sales = new ArrayList<>();
        inventory = new ArrayList<>();
          
    }
    //Get method to return the only instance of Inventory
    //https://www.w3schools.blog/java-singleton-design-pattern
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    //Method to add order to orders
    public void addOrder(Order newOrder){
        orders.add(newOrder);

    }
    //Method to add sale to sales
    public void addSale(Sale newSale){
        sales.add(newSale);
    }
    
    // Method to add an order to the inventory
    public void addInventory(Order newOrder) {
        boolean orderExists = false;
        if (inventory.size() >= 1) {
            for (Order existingOrder : inventory) {
                if (existingOrder.getDescription().equals(newOrder.getDescription())) {
                    // Combine fields if the orders match
                    existingOrder.setQuantity(existingOrder.getQuantity() + newOrder.getQuantity());
                    existingOrder.setTotalCost(existingOrder.getTotalCost() + newOrder.getTotalCost());
                    orderExists = true;
                    break; // Exit the loop order has been added
                }
            }
        }
        // If the order doesn't exist or inventory is empty add order
        if (!orderExists) {
            inventory.add(new Order(newOrder.getSetID()
                    ,newOrder.getInitialCost()
                    ,newOrder.getQuantity()
                    ,newOrder.getRewardPoints()
                    ,newOrder.getDescription()
                    ,newOrder.getSupplier()
                    ,newOrder.getNumPieces()
                    ,newOrder.getUrl()
                    ,newOrder.getDatePurchased()
                    ,newOrder.getYearReleased()));
        }
            totalAmountInvested += newOrder.getTotalCost();
            totalQuantity += newOrder.getQuantity();
            
        }
  
    
     //Method to add sale to inventory
    public void removeInventory(Sale newSale) {
        try {
            for (Order existingOrder : inventory) {
                // Check if the order matches the setID and has enough quantity
                if (existingOrder.getSetID() == (newSale.getSetID()) && (existingOrder.getQuantity() >= newSale.getQuantity())) {
                    // Adjust the quantity of the existing order
                    existingOrder.setQuantity(existingOrder.getQuantity() - newSale.getQuantity());
                    // Adjust the totalCost of the existing order
                    existingOrder.setTotalCost(existingOrder.getTotalCost()-(newSale.getQuantity()*newSale.getInitialCostPerItem()));
                //quantity becomes zero than remove order
                if (existingOrder.getQuantity() == 0) {
                    inventory.remove(existingOrder); // Remove the order from the inventory list
                }
                // Exit the loop since the sale has been processed
                break;
                }
            }
            
             } catch (Exception e) {
                // Handle the exception by displaying a panel
                JOptionPane.showMessageDialog(null, "Error: Set ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            totalAmountInvested -= (newSale.getInitialCostPerItem()*newSale.getQuantity());
            totalQuantity -= newSale.getQuantity();
            }
    //Method to find existing order searches orders becasue if sold all quality it won't be in inventory
    public Order findOrder(Object setID){
          //https://www.w3docs.com/snippets/java/how-to-cast-an-object-to-an-int.html
       int tmp = ((Integer) setID);
       for (Order existingOrder : orders) {
           if (existingOrder.getSetID() == tmp)
               return existingOrder;
               }
       JOptionPane.showMessageDialog(null, "Error: Order not found", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
   
    public void updateInventoryList(){
        inventory.clear();
        totalAmountInvested = 0;
        totalQuantity = 0;
        //pass orders into inventory
        for (Order existingOrder : orders) {
                addInventory(existingOrder);
            }
        //remove each sale from inventory
            for (Sale existingSale : sales) {
                 removeInventory(existingSale);
            }
        //update the Inventory Jtable
        CurrentInventoryJFrame.setInventoryJTable();
    }
    // Method to get the list of orders in the orderlog
    public ArrayList<Order> getOrders() {
        return orders;
    }
    // Method to get the list of sales in the salelog
    public ArrayList<Sale> getSales() {
        return sales;
    }
    // Method to get the list of orders in the inventory
    public ArrayList<Order> getInventory() {
        return inventory;
    }
    
    //Method to get total amount invested
    public float getTotalAmountInvested(){
        return totalAmountInvested;
    }
    //method to get total quanity of inventory
    public int getTotalQuantity(){
        return totalQuantity;
    }
 
    //Setter Method sales
    public void setSales(ArrayList<Sale> sales){
        this.sales = sales;
    }
    //Setter Method orders
    public void setOrders(ArrayList<Order> orders){
        this.orders = orders;
    }
    //Setter Method inventory
    public void setInventory(ArrayList<Order> inventory){
        this.inventory = inventory;
    }
    
    public void setTotalAmountInvested(float totalAmountInvested){
        this.totalAmountInvested = totalAmountInvested;
    }
    public void setTotalQuantity(int totalQuantity){
        this.totalQuantity = totalQuantity;
    }
}
