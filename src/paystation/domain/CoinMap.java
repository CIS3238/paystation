/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

/**
 *
 * @author kyle
 */
public class CoinMap {
    
    private int nickles = 0;
    private int dimes = 0;
    private int quarters = 0;
    private int total = 0;
    
    public void CoinMap() {
    
    }
    
    public CoinMap CoinMap(CoinMap oldMap) {
        CoinMap newMap = new CoinMap();
        newMap.nickles = this.nickles;
        newMap.dimes = this.dimes;
        newMap.quarters = this.quarters;
        return newMap;
    }
    
    public void addCoin(int coin) {
        if (coin == 5) 
                nickles++;
        if (coin == 10) 
                dimes++;
        if (coin == 25) 
                quarters++;
    }
    
    public int getTotal() {
        total = nickles + dimes + quarters;
        return total;
    }
    
    public void initialize(CoinMap oldMap) {
        this.nickles = oldMap.nickles;
        this.dimes = oldMap.dimes;
        this.quarters = oldMap.quarters;
        this.total = oldMap.total;
    }
    
    public void clear() {
        this.nickles = 0;
        this.dimes = 0;
        this.quarters = 0;
        this.total = 0;
    }
    
}
