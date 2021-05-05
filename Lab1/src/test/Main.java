/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dataStructures.BuyProcessor;
import dataStructures.ProductList;
import model.enums.Priority;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ProductListMakingTool tool = new ProductListMakingTool();
        BuyProcessor bpu = new BuyProcessor();
        long milliseconds = 200;

        ProductList pList1 = tool.generateList();
        bpu.addBuyout(pList1, Priority.ONE_DAY_DELIVERY);
        Thread.sleep(milliseconds);

        ProductList pList2 = tool.generateList();
        bpu.addBuyout(pList2, Priority.TWO_TO_FIVE);
        Thread.sleep(milliseconds);

        ProductList pList3 = tool.generateList();
        bpu.addBuyout(pList3, Priority.NORMAL_DELIVERY);
        Thread.sleep(milliseconds);

        ProductList pList4 = tool.generateList();
        bpu.addBuyout(pList4, Priority.ONE_DAY_DELIVERY);
        Thread.sleep(milliseconds);

        ProductList pList5 = tool.generateList();
        bpu.addBuyout(pList5, Priority.TWO_TO_FIVE);
        Thread.sleep(milliseconds);

        ProductList pList6 = tool.generateList();
        bpu.addBuyout(pList6, Priority.NORMAL_DELIVERY);
        Thread.sleep(milliseconds);

        ProductList pList7 = tool.generateList();
        bpu.addBuyout(pList7, Priority.ONE_DAY_DELIVERY);

        System.out.printf("SHOWING PROCESSING ELEMENTS: %n%n %s",
                bpu.showProccesingBuyouts());

        //Sending purchases to the transit area according to their priority
        System.out.println("Sending elements to the transit zone....\n\n");

        bpu.toTransit();
        bpu.toTransit();
        bpu.toTransit();
        bpu.toTransit();
        bpu.toTransit();
        bpu.toTransit();
        bpu.toTransit();

        //Proof that all the values were pushed to the transit area.
        System.out.printf("SHOWING PROCESSING ELEMENTS: %n%n %s %n%n",
                bpu.showProccesingBuyouts());

        //Show all elements in the transit area.
        System.out.printf("SHOWING IN TRANSIT ELEMENTS%n%n %s", 
                bpu.showTransitBuyouts());

        //Sending purchases to the delivery area according to their consecutive.
        bpu.toDelivery(1);
        bpu.toDelivery(4);
        bpu.toDelivery(7);
        bpu.toDelivery(2);
        bpu.toDelivery(5);
        bpu.toDelivery(3);
        bpu.toDelivery(6);

        //Proof that all the values were pushed to the transit area.
        System.out.printf("SHOWING IN TRANSIT ELEMENTS: %n%n %s %n%n", 
                bpu.showTransitBuyouts());

        //Show all elements in the delyvery area.
        System.out.printf("SHOWING DELIVERED ELEMENTS: %n%n %s", 
                bpu.showDeliveredBuyouts());

    }

}
