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
public class SaveStateLists {
    private ArrayList<Order> ordersSave;
    private ArrayList<Sale> salesSave;
    private ArrayList<Order> inventorySave;
    private float totalAmountInvestedSave;
    private int totalQuantitySave;

    private static SaveStateLists instance; // Singleton instance

    private SaveStateLists() {
        Inventory inventory = Inventory.getInstance();
        ordersSave = inventory.getOrders();
        salesSave = inventory.getSales();
        inventorySave = inventory.getInventory();
        totalAmountInvestedSave = inventory.getTotalAmountInvested();
        totalQuantitySave = inventory.getTotalQuantity();
    }

    public static SaveStateLists getSaveStateLists() {
        if (instance == null) {
            instance = new SaveStateLists();
        }
        return instance;
    }
//    public static setSaveStateLists(setSaveStateLists list){
//        this = list;
//    }
     // Method to get the list of orders in the orderlog
    public ArrayList<Order> getOrders() {
        return ordersSave;
    }
    // Method to get the list of sales in the salelog
    public ArrayList<Sale> getSales() {
        return salesSave;
    }
    // Method to get the list of orders in the inventory
    public ArrayList<Order> getInventory() {
        return inventorySave;
    }
     //Method to get total amount invested
    public float getTotalAmountInvested(){
        return totalAmountInvestedSave;
    }
    //method to get total quanity of inventory
    public int getTotalQuantity(){
        return totalQuantitySave;
    }
    
    
    
}
