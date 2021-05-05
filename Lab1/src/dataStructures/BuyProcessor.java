/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import model.Buyout;
import model.BuyoutState;
import model.enums.Priority;
import model.enums.State;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 * This is somme comments added to see a git status changes
 */
public class BuyProcessor {

    private final PriorityQueue<Buyout> tpProcessing;
    private final HashMap<Integer, Buyout> tpTransit;
    private final LinkedList<Buyout> tpDelivery;

    public BuyProcessor() {
        tpProcessing = new PriorityQueue<>();
        tpTransit = new HashMap<>();
        tpDelivery = new LinkedList<>();
    }

    public void addBuyout(ProductList plist, Priority priority) {
        Buyout boyout = new Buyout(plist, priority);
        tpProcessing.add(boyout);
    }

    public void toTransit() {
        Buyout buyout = tpProcessing.poll();
        BuyoutState boyoutState = buyout.getBoyoutState();
        boyoutState.setDate();
        boyoutState.setState(State.TRANSIT);
        tpTransit.put(buyout.getConsecutive(), buyout);
        //Only for order output purposes, i.e, elements will be displayed
        //in their corresponding priority order.
        System.out.println("Element with " + buyout.getPriority()
                + " priority was transacted"
                + " properly. \nConsecutive: \t"
                + buyout.getConsecutive() + "\n");
    }

    public void toDelivery(int consecutive) {
        Buyout buyout = tpTransit.get(consecutive);
        tpTransit.remove(consecutive);
        BuyoutState boyoutState = buyout.getBoyoutState();
        boyoutState.setDate();
        boyoutState.setState(State.DELIVERED);
        tpDelivery.add(buyout);
    }

    public String showProccesingBuyouts() {
        return tpProcessing.isEmpty() ? "The PROCESSING area is empty"
                : getValues(tpProcessing, "In process purchases");
    }

    public String showTransitBuyouts() {
        return tpTransit.isEmpty() ? "The TRANSIT area is empty"
                : getValues(tpTransit, "In transit purchases");
    }

    public String showDeliveredBuyouts() {
        return getValues(tpDelivery, "Delivered Purchases");
    }

    private <T> String getValues(T t, String name) {
        String content = new String();
        Iterator itr;
        if (t instanceof Map) {
            itr = ((Map) t).keySet().iterator();
            content += "Now in: " + name.toUpperCase() + "\n\n";
            while (itr.hasNext()) {
                int nextKey = (int) itr.next();
                content += "\nKEY : \t" + nextKey
                        + "\nVALUE: \n"
                        + ((Map) t).get(nextKey).toString() + "\n\n";
            }
        } else {
            if (t instanceof Iterable) {
                itr = ((Iterable) t).iterator();
                content += "Now in: " + name.toUpperCase() + "\n\n";
                while (itr.hasNext()) {
                    content += itr.next().toString() + "\n\n";
                }
            }
        }
        return content;
    }

}
