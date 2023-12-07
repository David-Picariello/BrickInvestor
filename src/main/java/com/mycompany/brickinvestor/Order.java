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
    private float initialCost;
    private int quantity;
    private float rewardPoints;
    private String description;
    private String supplier;
    private float costPerItem;
    private float numPieces;
    private float pricePerPiece;
    
    public Order(int SetID,float initialCost,int quantity,float rewardPoints,String description,String supplier,float numPieces){
        this.setID = SetID;
        this.initialCost = initialCost;
        this.quantity = quantity;
        this.rewardPoints = rewardPoints;
        this.description = description;
        this.supplier = supplier;
        this.numPieces = numPieces;
        this.costPerItem = (initialCost - rewardPoints)/quantity;
        this.pricePerPiece = costPerItem/this.numPieces;
        
        
        
    }
     // get methods
    public int getSetID() {
        return setID;
    }

    public float getInitialCost() {
        return initialCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getRewardPoints() {
        return rewardPoints;
    }

    public String getDescription() {
        return description;
    }

    public String getSupplier() {
        return supplier;
    }
    public float getcostPerItem() {
        return costPerItem;
    }
    public float getpricePerPiece() {
         
        return pricePerPiece;
    }
    //set methods
    public void setQuantity(int newQuanity){
        this.quantity = newQuanity;
        
    }
    public void setCostPerItem(float initialCost,float rewardPoints){
        this.costPerItem = ((this.initialCost+initialCost)-(this.rewardPoints+rewardPoints))/this.quantity;
        setPricePerPiece();
    }
    public void setPricePerPiece(){
        this.pricePerPiece = this.costPerItem/this.numPieces;
    }
}
