/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

/**
 *
 * @author bennyboyTheBrokenToy
 */
public class RateStrategy {
    private Strategy strategy;
    
    public RateStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    
    public int calculateTime(int amount) {
        return strategy.calculateTime(amount);
    }

    
}
