/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

/**
 *
 * @author 
 */
public class WeekdayState implements State {
    @Override
    public int calculateTime(int amount) {
        int time = (amount*2)/5;
        return time;
    }
    
}
