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
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Method to get the list of orders in the inventory
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
}
