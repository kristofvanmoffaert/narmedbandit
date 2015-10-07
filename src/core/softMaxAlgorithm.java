/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.settings.softMaxSettings;

/**
 *
 * @author kristof
 */
public class softMaxAlgorithm extends defaultAlgorithm implements AlgorithmInterface{

    public softMaxAlgorithm() {
        super(new softMaxSettings());
    }

    public softMaxSettings getSettings() {
        return  (softMaxSettings)setting;
    }

    public AlgorithmInterface copy() {
        return new softMaxAlgorithm();
    }

    public String getDescription() {
        return toString() + " (" +getSettings() + ")";
    }


    protected int getSoftMaxProbabilities(double tau) {
        double div=0.0;
        double[] probabilities = new double[estimates.length];
        
        for (int i=0; i < estimates.length; i++) {
            probabilities[i] =  Math.exp(estimates[i]/tau);
            div += probabilities[i];
        }
            
        
        double sum=0.0;
        double randomNumber = r.nextDouble();
        int index=-1;
        
        for (int j=0; j < estimates.length; j++) {
            //System.out.println("  " + sum);
            sum += probabilities[j] / div;
            if (randomNumber <= sum) {
                index = j;
                break;
            }

        }
        return index;

    }

    public void run() {
        softMaxSettings set = (softMaxSettings) setting;
        setEstimates(set.getInitializationMode());
        initComponents();
        double deltaTau = set.getDeltaTau();
        
        for (int l = 0; l < set.getBandits(); l++) {
            
            
            for (int i = 0; i < set.getIterations(); i++) {
                double tau = 1000 * Math.pow(deltaTau, i);
                if (tau < 0.01)
                    tau = 0.01;
                
                int index = getSoftMaxProbabilities(tau);

                double reward = getReward(set.getActions()[index].getQStar());
                estimates[index] += set.getLearningRate() * (reward - estimates[index]);

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

    public String toString() {
        return "SoftMax";
    }
}
