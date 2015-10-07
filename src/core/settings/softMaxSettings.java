/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.settings;

import core.Action;
import core.initializationMode;

/**
 *
 * @author kristof
 */
public class softMaxSettings extends basicSettings  {

    
    private double tau;
    


    public softMaxSettings() {
        super();
        tau=0.99;
        
    }

    public double getDeltaTau() {
        return tau;
    }

    public void setDeltaTau(double t) {
        tau = t;
    }

    public String toString() {
        return super.toString() + ", tau:" + tau;
    }

    
    public void printSettings() {
        System.out.println("SoftMax Settings:");
        System.out.println("Tau:" + tau);
        
        super.printSettings();
        System.out.println();
    }

}
