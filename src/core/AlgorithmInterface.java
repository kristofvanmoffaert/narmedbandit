/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import core.settings.basicSettings;

/**
 *
 * @author kristof
 */
public interface AlgorithmInterface {

    public void run();

    public String toString();

    public basicSettings getSettings();

    public void copyBasicSettings(basicSettings s);

    public AlgorithmInterface copy();

    public double[] getAverageRewards();

    public double[] getPercentageOptimalActions();

    public double[] getCummulativeAverageRewards();

    public double[] getCummulativePercentageOptimalAction();

    public String getDescription();

}
