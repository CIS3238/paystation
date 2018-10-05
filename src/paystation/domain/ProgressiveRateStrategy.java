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
public class ProgressiveRateStrategy implements Strategy{
    @Override
    public int calculateTime(int amount) {
        int time;
        if (amount < 150) {
            time = (amount*2)/5;
        }
        
        else if ((150 <= amount) && (amount < 350)) {
            time = (amount-150)*(3/10) + 60;
        }
        
        else {
            time = (amount-350)/5 + 120;
        }
    
        return time;
    }
}