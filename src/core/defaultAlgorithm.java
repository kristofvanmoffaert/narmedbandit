/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.settings.basicSettings;
import java.util.Random;

/**
 *
 * @author kristof
 */
public abstract class defaultAlgorithm implements AlgorithmInterface{

    protected basicSettings setting;
    protected double VARIANCE = 1.0;
    protected Random r = new Random();
    protected double[] estimates;
    protected double[] avgReward;
    protected double[] percentageOptimalActions;
    protected double[] cummulativeAverageReward;
    protected double[] cummulativePercentageOptimalAction;

    public defaultAlgorithm()  {
        setting = new basicSettings();
        initComponents();

    }

    public AlgorithmInterface copy() {
        return this;
    }

    public void copyBasicSettings(basicSettings s) {
        setting.setIterations(s.getIterations());
        setting.setActions(s.getActions());
        setting.setBandits(s.getBandits());
        initComponents();
    }

    protected void initComponents() {
        avgReward = new double[setting.getIterations()];
        percentageOptimalActions = new double[setting.getIterations()];
        cummulativeAverageReward = new double[setting.getIterations()];
        cummulativePercentageOptimalAction = new double[setting.getIterations()];
    }

    public defaultAlgorithm(basicSettings s) {
        setting = s;

    }

    public double[] getAverageRewards() {
        return avgReward;
    }

    public double[] getPercentageOptimalActions() {
        return percentageOptimalActions;
    }

    public double[] getCummulativeAverageRewards() {
        return cummulativeAverageReward;
    }

    public double[] getCummulativePercentageOptimalAction() {
        return cummulativePercentageOptimalAction;
    }

    protected double getReward(double Qstar) {
        double gauss = r.nextGaussian();
        return (Qstar + gauss * VARIANCE);
    }

    protected int findHighestEstimateIndex() {
        int highestIndex = -1;
        double highestEstimate = Double.MAX_VALUE * -1.0;
        for (int i = 0; i < estimates.length; i++) {

            if (estimates[i] > highestEstimate) {
                highestEstimate = estimates[i];
                highestIndex = i;
            }

        }
        return highestIndex;
    }

    protected int findHighestQstarIndex() {
        int highestIndex = -1;
        double highestEstimate = Double.MAX_VALUE * -1.0;
        for (int i = 0; i < setting.getActions().length; i++) {

            if (setting.getActions()[i].getQStar() > highestEstimate) {
                highestEstimate = setting.getActions()[i].getQStar();
                highestIndex = i;
            }

        }
        return highestIndex;
    }

        protected int findLowestQstarIndex() {
        int lowestIndex = -1;
        double lowestEstimate = Double.MAX_VALUE;
        for (int i = 0; i < setting.getActions().length; i++) {

            if (setting.getActions()[i].getQStar() < lowestEstimate) {
                lowestEstimate = setting.getActions()[i].getQStar();
                lowestIndex = i;
            }

        }
        return lowestIndex;
    }

    public void setEstimates(initializationMode m) {
        estimates = new double[setting.getActions().length];
        double initValue=0.1;

        if (m == initializationMode.OPTIMISTIC)
            initValue = findHighestQstarIndex() + 2;
        else {
            if (m == initializationMode.PESSIMISTIC)
                initValue = findLowestQstarIndex() - 2;
        }

        for (int i=0; i < estimates.length; i++)
            estimates[i] = initValue;
    }



    protected void storeOptimalActions(int index, int it) {
        if (index == findHighestQstarIndex()) {
                    percentageOptimalActions[it]++;
            }
    }

    protected void storeAverageReward(double reward, int i) {
        avgReward[i] += reward;
    }

    protected void calculateAverageReward() {
        for (int i=0; i < avgReward.length; i++)
            avgReward[i]/=setting.getBandits();
    }

   protected void calculatePercentageOptimalAction() {
        for (int i=0; i < percentageOptimalActions.length; i++)
            percentageOptimalActions[i] = 100.0*percentageOptimalActions[i] / setting.getBandits();
    }


    protected void calculateCumSumReward() {
        double cumsum=0.0;
        for (int i=0; i < avgReward.length; i++) {
            cumsum += avgReward[i];
            cummulativeAverageReward[i] = cumsum;
        }
    }

     protected void calculateCumSumPercentageOptimalAction() {
        double cumsum=0.0;
        for (int i=0; i < percentageOptimalActions.length; i++) {
            cumsum += percentageOptimalActions[i];
            cummulativePercentageOptimalAction[i] =  cumsum/setting.getIterations();
        }
    }

    public void run() {
    }


}
