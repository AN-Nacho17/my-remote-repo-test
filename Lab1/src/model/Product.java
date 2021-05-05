/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class Product implements Comparable<Product> {

    private final String code;
    private int amount;
    private final double weigth;

    public Product(String code, int amount, double weigth) {
        this.code = code;
        this.amount = amount;
        this.weigth = weigth;
    }

    public String getCode() {
        return code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount > 0 ? amount : 0;
    }

    public double getWeigth() {
        return weigth;
    }

    public double getTotalProductWeigth() {
        return weigth * amount;
    }

    @Override
    public int compareTo(Product product) {
        return product.getCode().compareTo(code);
    }
    
    @Override
    public String toString() {
        return "Code: \t" + code 
                + "\nAmount: \t" + amount 
                + "\nWeigth per product: \t" + 
                String.format("%.2f", weigth) + " kg"
                + "\nTotal weigth : \t"
                + String.format("%.2f", getTotalProductWeigth()) + " kg"; 
    }
    
   

}
