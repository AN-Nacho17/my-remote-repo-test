/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dataStructures.ProductList;
import model.enums.Priority;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class Buyout implements Comparable<Buyout> {

    private static int globalConsecutive = 0; 
    private final int consecutive;
    private final Priority priority;
    private BuyoutState state;
    private final ProductList productList;

    public Buyout(ProductList productList, Priority priority) {
        consecutive = ++globalConsecutive;
        this.priority = priority;
        this.productList = productList;
        this.state = new BuyoutState();
    }

    public int getConsecutive() {
        return consecutive;
    }

    public BuyoutState getBoyoutState() {
        return state;
    }

    public void setBoyoutState(BuyoutState state) {
        this.state = state;
    }

    public Priority getPriority() {
        return priority;
    }

    private double getTotalWeigth() {
        return productList.getTotalWeigth();
    }

    @Override
    public int compareTo(Buyout buyout) {
        return buyout.getPriority().compareTo(priority); 
    }
    
    @Override
    public String toString() {
       return "PURCHASE DETAIL: "
                + "\nConsecutive: \t" + consecutive
                + "\nRegistered Priority: \t" + priority
                + "\n" + state.toString()
                + "\n\nProduct list: \n\n" + productList.toString()
                + "\nTotal buyout weigth: \t" + 
                String.format("%.2f", getTotalWeigth()) + " kg"
                + "\n-------------------------------------"; 
    }


}
