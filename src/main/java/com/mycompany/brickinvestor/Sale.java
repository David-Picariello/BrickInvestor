/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brickinvestor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author davidpicariello
 */
public class Sale {
    //fields
    private String orderNumber;
    private int setID;
    private int quantity;
    private float salePrice;
    private float orderTotal;
    private float sellerFee;
    private float salesTax;
    private float shipping;
    private float initialCostPerItem;
    private String datePurchased;
    private String dateSold;
    private String description;
    private float net;
    private float ROI;
    private static float totalNet;
    private static int totalQuantity;
    
    
    //constructor
    public Sale(String orderNumber,int setID, int quantity, float salePrice,float orderTotal,float shipping,String dateSold){
        this.orderNumber = orderNumber;
        this.setID = setID;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.orderTotal = orderTotal;
        this.shipping = shipping;
        this.dateSold = dateSold;
        //https://www.java67.com/2020/04/4-examples-to-round-floating-point-numbers-in-java.html
        //* 0.1325)+0.3 this is how Ebay calculates its fees
        this.sellerFee = BigDecimal.valueOf((float) ((this.orderTotal * 0.1325)+0.3))
                         .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                         .floatValue();
        this.salesTax = this.orderTotal - this.salePrice;
        this.shipping = shipping;
        this.dateSold = dateSold;
        //need order info
        //needs initial cost
//        this.net = ;
//        this.ROI =
        totalQuantity += this.quantity;
        totalNet += this.net;
              
    }
    
    // Getter methods
    public String getOrderNumber() {
        return orderNumber;
    }

    public int getSetID() {
        return setID;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public float getSellerFee() {
        return sellerFee;
    }

    public float getSalesTax() {
        return salesTax;
    }

    public float getShipping() {
        return shipping;
    }

    public String getDatePurchased() {
        return datePurchased;
    }

    public String getDateSold() {
        return dateSold;
    }

    public float getNet() {
        return net;
    }

    public float getROI() {
        return ROI;
    }
    public float getInitialCostPerItem(){
        return initialCostPerItem;
    }
    public String getDescription(){
        return description;
    }

    // Getter methods for static fields
    public static float getTotalNet() {
        return totalNet;
    }

    public static int getTotalQuantity() {
        return totalQuantity;
    }
    //Setter methods
    public void setNet(){
        this.net = salePrice - ((initialCostPerItem * quantity) - shipping - sellerFee);
    }
    public void setROI() {
        this.ROI = BigDecimal.valueOf((float) ((net / (initialCostPerItem * quantity))))
                    .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                    .floatValue();
}
    
    //description date purchased and cost per item then call set Net and ROI
    public void setDescription(ArrayList<Order> orders){
        try {
        for (Order existingOrder : orders) {
            if (existingOrder.getSetID() == this.setID){
                this.description = existingOrder.getDescription();
                this.datePurchased = existingOrder.getDatePurchased();
                this.initialCostPerItem = existingOrder.getCostPerItem();
                setNet();
                setROI();
            }
        
        }
        } catch (Exception e) {
                // Handle the exception if set id isn't found
                JOptionPane.showMessageDialog(null, "Error: Set ID not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    

  
    
    

