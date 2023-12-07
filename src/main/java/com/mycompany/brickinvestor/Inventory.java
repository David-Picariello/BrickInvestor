/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brickinvestor;

import java.util.ArrayList;

/**
 *
 * @author davidpicariello
 */
public class Inventory {
    //fields
    private ArrayList<Order> orders;
  
    
    public Inventory(){
        orders = new ArrayList<>();
          
    }
    // Method to add an order to the inventory
    public void addOrder(Order newOrder) {
        boolean orderExists = false;

        for (Order existingOrder : orders) {
            if (existingOrder.getDescription().equals(newOrder.getDescription())) {
                // Combine fields if the orders match
                existingOrder.setQuantity(existingOrder.getQuantity() + newOrder.getQuantity());
                existingOrder.setCostPerItem(newOrder.getInitialCost(), newOrder.getRewardPoints());
                orderExists = true;
                break; // Exit the loop since the order has been processed
            }
        }

        // If the order doesn't exist in the list, add it
        if (!orderExists) {
            orders.add(newOrder);
        }

        }
    

    // Method to get the list of orders in the inventory
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
}
