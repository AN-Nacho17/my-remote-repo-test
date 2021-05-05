/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import date.DateCrafter;
import model.enums.State;

/**
 *
 * @author Ignacio Orozco & Marcell Elizondo
 */
public class BuyoutState {

    private String date;
    private State state;
    private final DateCrafter dateCrafter; 

    public BuyoutState() {
        state = State.PROCESSING;
        dateCrafter = new DateCrafter();
        date = dateCrafter.craft(); 
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date = dateCrafter.craft(); 
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Date: \t" + date
                + "\nState: \t" + state;
    }

}
