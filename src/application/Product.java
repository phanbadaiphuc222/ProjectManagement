/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Dai Phuc
 */
public class Product {
    
    private String ProductID, ProductName ;
    private int originPrice, price, amount;
    
    private String userName, timeInsert, actionType, ProductIDChange, ProductNameChange;
    private int originPriceChange, priceChange, amountChange;
    
    public Product(){
    }
    
//    public Product (String userName, String timeInsert, 
//            String actionType, String ProductIDChange, String ProductNameChange,
//            int originPriceChange, int priceChange, int amountChange, String ProductID, String ProductName, int originPrice, int price, int amount){
//        this.userName=userName;
//        this.timeInsert=timeInsert;
//        this.actionType=actionType;
//        
//        this.ProductID=ProductID;
//        this.ProductName=ProductName;
//        this.originPrice=originPrice;
//        this.price=price;
//        this.amount=amount;
//    }

    public Product(String ProductID, String ProductName, int originPrice, int price, int amount,
            String userName, String timeInsert, String actionType, String ProductIDChange, 
            String ProductNameChange, int originPriceChange, int priceChange, int amountChange) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.originPrice = originPrice;
        this.price = price;
        this.amount = amount;
        this.userName = userName;
        this.timeInsert = timeInsert;
        this.actionType = actionType;
        this.ProductIDChange = ProductIDChange;
        this.ProductNameChange = ProductNameChange;
        this.originPriceChange = originPriceChange;
        this.priceChange = priceChange;
        this.amountChange = amountChange;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeInsert() {
        return timeInsert;
    }

    public void setTimeInsert(String timeInsert) {
        this.timeInsert = timeInsert;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getProductIDChange() {
        return ProductIDChange;
    }

    public void setProductIDChange(String ProductIDChange) {
        this.ProductIDChange = ProductIDChange;
    }

    public String getProductNameChange() {
        return ProductNameChange;
    }

    public void setProductNameChange(String ProductNameChange) {
        this.ProductNameChange = ProductNameChange;
    }

    public int getOriginPriceChange() {
        return originPriceChange;
    }

    public void setOriginPriceChange(int originPriceChange) {
        this.originPriceChange = originPriceChange;
    }

    public int getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(int priceChange) {
        this.priceChange = priceChange;
    }

    public int getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(int amountChange) {
        this.amountChange = amountChange;
    }
   
}
