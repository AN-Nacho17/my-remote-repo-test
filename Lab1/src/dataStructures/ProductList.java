/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructures;

import java.util.Iterator;
import java.util.TreeMap;
import model.Product;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class ProductList {

    private final TreeMap<String, Product> productTree;

    public ProductList() {
        productTree = new TreeMap<>(); 
    }
   
    public void add(Product product) {
        productTree.put(product.getCode(), product);
    }

    public void remove(String code) {
        productTree.remove(code);
    }

    public double getTotalWeigth() {
        double totalWeigth = 0;
        Iterator<Product> itr = productTree.values().iterator();
        while (itr.hasNext()) {
            totalWeigth += itr.next().getTotalProductWeigth(); 
        }
        return totalWeigth;
    }

    @Override
    public String toString() {
        String productList = new String();
        Iterator<String> itr = productTree.keySet().iterator(); 
        while (itr.hasNext()) {
            String next = itr.next(); 
            productList += "KEY: \t" + next 
                    + "\nVALUE: "
                    + "\n" + productTree.get(next).toString() + "\n\n";
        }
        return productList;
    }
    

}
