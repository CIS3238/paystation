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

/*  
    The State interface is written the same as the Strategy interface. Nevertheless, they should  
    remain as two separate interfaces in order to softcode the functionality they represent.
*/
public interface State {
    public int calculateTime(int amount);
}
