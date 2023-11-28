/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brickinvestor;

/**
 *
 * @author davidpicariello
 */
public class Order {
     //fields
    private int setID;
    private int initialCost;
    private int quantity;
    private int rewardPoints;
    private String description;
    private String supplier;
    
    public Order(int SetID,int initialCost,int quantity,int rewardPoints,String description,String supplier){
        this.setID = SetID;
        this.initialCost = initialCost;
        this.quantity = quantity;
        this.rewardPoints = rewardPoints;
        this.description = description;
        this.supplier = supplier;
        
        
        
    }
     // get methods
    public int getSetID() {
        return setID;
    }

    public int getInitialCost() {
        return initialCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public String getDescription() {
        return description;
    }

    public String getSupplier() {
        return supplier;
    }
}
