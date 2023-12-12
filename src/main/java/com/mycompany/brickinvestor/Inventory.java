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
  
    
    private Inventory(){
        orders = new ArrayList<>();
        sales = new ArrayList<>();
          
    }
    //Get method to return the only instance of Inventory
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    // Method to add an order to the inventory
    public void addOrder(Order newOrder) {
        boolean orderExists = false;

        for (Order existingOrder : orders) {
            if (existingOrder.getDescription().equals(newOrder.getDescription())) {
                // Combine fields if the orders match
                existingOrder.setQuantity(existingOrder.getQuantity() + newOrder.getQuantity());
                existingOrder.setTotalCost(existingOrder.getTotalCost() + newOrder.getTotalCost());
                orderExists = true;
                break; // Exit the loop order has been added
            }
        }

        // If the order doesn't exist in the list, add it
        if (!orderExists) {
            orders.add(newOrder);
        }

        }
     //Method to add sale to inventory
    public void addSale(Sale newSale) {
        try {
            for (Order existingOrder : orders) {
                // Check if the order matches the setID and has enough quantity

                if (existingOrder.getSetID() == (newSale.getSetID()) && (existingOrder.getQuantity() >= newSale.getQuantity())) {
                    // Adjust the quantity of the existing order
                    existingOrder.setQuantity(existingOrder.getQuantity() - newSale.getQuantity());
                    // Adjust the totalCost of the existing order
                    existingOrder.setTotalCost(existingOrder.getTotalCost()-(newSale.getQuantity()*newSale.getInitialCostPerItem()));

                //quantity becomes zero then remove order
                if (existingOrder.getQuantity() == 0) {
                    orders.remove(existingOrder); // Remove the order from the list
                }
                // Exit the loop since the sale has been processed
                break;
                }
            }
            // Add the sale to the sales list
            sales.add(newSale);
             } catch (Exception e) {
                // Handle the exception by displaying a panel
                JOptionPane.showMessageDialog(null, "Error: Set ID not found or quantity too low", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
     // Method to remove an order based on the selected row index
//    public void removeOrderBySelectedRow(Object setID) {
//        //https://www.w3docs.com/snippets/java/how-to-cast-an-object-to-an-int.html
//       int tmp = ((Integer) setID).intValue();
//       for (Order existingOrder : orders) {
//           if (existingOrder.getSetID() == tmp)
//               
//       }
//       
//    }
    //Method to find existing order 
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
    
    // Method to get the list of orders in the inventory
    public ArrayList<Order> getOrders() {
        return orders;
    }
    // Method to get the list of sales in the inventory
    public ArrayList<Sale> getSales() {
        return sales;
    }
    
}
