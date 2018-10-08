/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;
import java.util.Calendar;
import java.util.Scanner;
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
    private boolean isWeekday;
    int time = 0;
    
    AlternatingRateStrategy(State state) {
        this.state = state;
    }
    
    AlternatingRateStrategy() {
        Scanner s = new Scanner(System.in);
        
        int choice;
        System.out.println("You've chosen the Alternating Rate strategy. What day of the week is it?\n" +
                                    "1. Sunday\n" +
                                    "2. Monday\n" +
                                    "3. Tuesday\n" +
                                    "4. Wednesday\n" +
                                    "5. Thursday\n" +
                                    "6. Friday\n" +
                                    "7. Saturday\n");
        choice = s.nextInt();
        switch(choice) {
            case 1:
                isWeekday = false; 
                break;
            case 2:
                isWeekday = true;
                break;
            case 3:
                isWeekday = true;
                break;
            case 4:
                isWeekday = true;
                break;
            case 5:
                isWeekday = true;
                break;
            case 6:
                isWeekday = true;
                break;
            case 7:
                isWeekday = false;
                break;
            default:
                System.out.println("You chose a day that does not exist!\n");
                break;
        }
                            
                            if(isWeekday) {
                                this.state = new WeekdayState();
                            } else {
                                this.state = new WeekendState();
                            }
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
