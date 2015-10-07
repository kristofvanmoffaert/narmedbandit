/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import core.settings.*;



/**
 *
 * @author kristof
 */
public class greedyAlgorithm extends epsilonGreedyAlgorithm {

    public greedyAlgorithm() {
        super();
        ((epsilonGreedySettings) setting).setEpsilon(0.0);
        
    }    

    public AlgorithmInterface copy() {
        return new greedyAlgorithm();
    }

    public String toString() {
        return "Greedy";
    }

    public String getDescription() {
        return toString() + " ("+ getSettings() + ")";
    }

}
