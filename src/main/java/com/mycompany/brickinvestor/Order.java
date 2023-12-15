/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.brickinvestor;

import java.math.BigDecimal;

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
    private float totalCost;
    private String url;
    private String datePurchased;
    private String yearReleased;
    
    public Order(int SetID,float initialCost,int quantity,float rewardPoints,String description,String supplier,float numPieces,String url,String datePurchased,String year){
        this.setID = SetID;
        this.initialCost = initialCost;
        this.quantity = quantity;
        this.rewardPoints = rewardPoints;
        this.description = description;
        this.supplier = supplier;
        this.numPieces = numPieces;
        this.totalCost = this.initialCost - this.rewardPoints;
        //https://www.java67.com/2020/04/4-examples-to-round-floating-point-numbers-in-java.html
        this.costPerItem = BigDecimal.valueOf((float) (this.totalCost)/quantity)
                         .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                         .floatValue();
        this.pricePerPiece = BigDecimal.valueOf((float) (costPerItem/this.numPieces))
                         .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                         .floatValue();
        this.url = url;
        this.datePurchased = datePurchased;
        this.yearReleased = year;
        
        
        
        
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
    public float getCostPerItem() {
        return costPerItem;
    }
    public float getPricePerPiece() {
        return pricePerPiece;
    }
    public float getTotalCost() {
        return totalCost;
    }
    public String getUrl(){
        return url;
    }
    public String getDatePurchased(){
        return datePurchased;
    }
    public float getNumPieces(){
        return numPieces;
    }
    public String getYearReleased(){
        return yearReleased;
    }
    //set methods
    public void setQuantity(int newQuanity){
        this.quantity = newQuanity;
        
    }
    public void setTotalCost(float newTotalCost){
        this.totalCost = newTotalCost;
        setCostPerItem();
        setPricePerPiece();
        
    }
    
   public void setCostPerItem() {
    this.costPerItem = BigDecimal.valueOf((float) (this.totalCost)/this.quantity)
                         .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                         .floatValue();
    
}
    public void setPricePerPiece(){
        this.pricePerPiece = BigDecimal.valueOf((float) (costPerItem/this.numPieces))
                         .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                         .floatValue();
    }
}
