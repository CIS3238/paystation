/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;
import java.util.Calendar;
/**
 *
 * 
 */

/*
    The AlternatingRateStrategy looks different than the Linear and Progressive 
    strategies because instead of just detailing an algorithm, the Alternating 
    strategy requires an extra level of abstraction. In this case, a state shifting class.

    When the AlternatingRateStrategy has been assigned a state (WeekdayState or WeekendState),
    The calculateTime() method is called for that state. 
*/
public class AlternatingRateStrategy implements Strategy {
    
    private State state;
    int time = 0;
    
    AlternatingRateStrategy(State state) {
        this.state = state;
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
