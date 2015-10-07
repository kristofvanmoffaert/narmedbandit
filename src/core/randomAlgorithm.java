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
public class randomAlgorithm extends defaultAlgorithm  implements AlgorithmInterface {

    public randomAlgorithm() {
        super(new basicSettings());
    }

    public basicSettings getSettings() {
        return  setting;
    }

    public AlgorithmInterface copy() {
        return new randomAlgorithm();
    }

    // Random according to estimates
    protected int getRandomIndex() {
       double div=0.0;
       

        for (int i=0; i < estimates.length; i++) {
           div += estimates[i];
        }


        double sum=0.0;
        double randomNumber = r.nextDouble();
        int index=0;

        for (int j=0; j < estimates.length; j++) {
            sum += (estimates[j] / div);
            if (randomNumber <= sum) {
                index = j;
                break;
            }

        }
        //System.out.println("  " + index);
        return index;
    }

    public String getDescription() {
        return toString() + " (" + getSettings() + ")";
    }


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
    }

    public String toString() {
        return "Random";
    }


    

}
