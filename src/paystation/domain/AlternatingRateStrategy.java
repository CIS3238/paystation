/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;
import java.util.Calendar;
/**
 *
 * @author bennyboyTheBrokenToy
 */
public class AlternatingRateStrategy implements Strategy {
    
    private State state = new WeekendState();
    int time = 0;
    enum Days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;}
    
    public void AlternatingRateStrategy() {
        
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return this.state;
    }
    
    @Override
    public int calculateTime(int amount) {
        time = this.state.calculateTime(amount);
        return time;
    }
    
}
