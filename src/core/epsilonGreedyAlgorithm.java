/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.settings.basicSettings;
import core.settings.epsilonGreedySettings;
import ui.SettingsFrame;

/**
 *
 * @author kristof
 */
public class epsilonGreedyAlgorithm extends defaultAlgorithm implements AlgorithmInterface {

    
    
    public epsilonGreedyAlgorithm() {
        super(new epsilonGreedySettings());
    }

    public epsilonGreedySettings getSettings() {
        return (epsilonGreedySettings) setting;
    }

    public AlgorithmInterface copy() {
        return new epsilonGreedyAlgorithm();
    }

    public String toString() {
        return "Epsilon Greedy";
    }

    public String getDescription() {
        return toString() + " (" + getSettings() + ")";
    }

    

    public void run() {
        
        epsilonGreedySettings set = (epsilonGreedySettings) setting;
        //System.out.println(set.getEpsilon());
        setEstimates(set.getInitializationMode());
        initComponents();


        for (int l = 0; l < set.getBandits(); l++) {
            
            for (int i = 0; i < set.getIterations(); i++) {

                int index = -1;
                if (r.nextDouble() < set.getEpsilon()) {
                    index = r.nextInt(set.getActions().length);
                } else {
                    index = findHighestEstimateIndex();
                }
    
                double reward = getReward(set.getActions()[index].getQStar());
                double lr = set.getLearningRate();
                estimates[index] += lr * (reward - estimates[index]);
                
                storeAverageReward(reward, i);
                storeOptimalActions(index, i);

            }
            setEstimates(set.getInitializationMode());
        }
        
        calculateAverageReward();

        calculatePercentageOptimalAction();
        calculateCumSumReward();
        calculateCumSumPercentageOptimalAction();
        /*
        for (int j = 0; j < avgReward.length; j++) {
            System.out.println(j + " " + avgReward[j]);
        }
        System.out.println();
        */
    }
}
