/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import core.settings.basicSettings;
import core.settings.epsilonGreedySettings;

/**
 *
 * @author kristof
 */
public class uniformRandomAlgorithm extends randomAlgorithm  implements AlgorithmInterface {

    public uniformRandomAlgorithm() {
        super();
    }

    public basicSettings getSettings() {
        return  setting;
    }

    public AlgorithmInterface copy() {
        return new uniformRandomAlgorithm();
    }

    // Random according to estimates
    protected int getRandomIndex() {

        return r.nextInt(estimates.length);
    }

    public String getDescription() {
        return toString() + " (" + getSettings() + ")";
    }

/*
    public void run() {
        setEstimates(setting.getInitializationMode());
        initComponents();
        
        for (int l = 0; l < setting.getBandits(); l++) {

            for (int i = 0; i < setting.getIterations(); i++) {


                int index = getRandomIndex();

                double reward = getReward(setting.getActions()[index].getQStar());
                estimates[index] += setting.getLearningRate() * (reward - estimates[index]);

                storeAverageReward(reward, i);
                storeOptimalActions(index, i);

            }
            setEstimates(setting.getInitializationMode());
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
  //  }

    public String toString() {
        return "Uniform Random";
    }


    

}
