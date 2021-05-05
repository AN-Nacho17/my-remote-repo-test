/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dataStructures.ProductList;
import java.util.Random;
import model.Product;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class ProductListMakingTool {

    private Random random;
    private final String capitalLetters; 
    private final String lowerCaseLetters; 
    private final String digits; 
    private final String allValues; 

    public ProductListMakingTool() {
        capitalLetters = "ABCDEXK";
        lowerCaseLetters = capitalLetters.toLowerCase();
        digits = "012345";
        allValues = capitalLetters + lowerCaseLetters + digits;
    }

    public ProductList generateList() {
        ProductList plist = new ProductList(); 
        for (int x = 0; x < 3; x++) {
            Product product = generateProduct();
            plist.add(product);
        }
        return plist;
    }

    private Product generateProduct() {
        Product product;
        String code = generateCode();
        int amount = generateAmount();
        double weigth = generateWeigth();
        product = new Product(code, amount, weigth);
        return product;
    }

    private String generateCode() {
        int i = 0;
        random = new Random();
        String st = new String();
         st += "" +(capitalLetters.charAt(random.nextInt
        (capitalLetters.length()))); //first insertion will be a capital letter.
        while (i < 3) {
            st += "" + (allValues.charAt(random.nextInt(allValues.length())));
            i++;
        }
        return st;
    }

    private int generateAmount() {
        return (int) (Math.random() * (6 - 1) + 1);
    }

    private double generateWeigth() {
        return (Math.random() * (11 - 1) + 1);
    }

}
