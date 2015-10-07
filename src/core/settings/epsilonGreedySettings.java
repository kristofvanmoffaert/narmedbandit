/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.settings;

import core.Action;
import core.initializationMode;
import ui.SettingsFrame;

/**
 *
 * @author kristof
 */
public class epsilonGreedySettings extends basicSettings{
    private double epsilon;


    public epsilonGreedySettings() {
        super();
        epsilon=0.1;
    }

    public epsilonGreedySettings(basicSettings s, double eps) {
        copyBasicSettings(s);
        //learningRate=lr;
        //initMode = m;
        epsilon = eps;
    }

    public initializationMode getInitializationMode() {
        return initMode;
    }

    public void setInitilizationMode(initializationMode m) {
        initMode = m;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public  void setEpsilon(double e) {
        epsilon = e;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double d) {
        learningRate=d;
    }

    public String toString() {
        return super.toString() + ", epsilon:" + epsilon;
    }

    public void printSettings() {
        System.out.println("Epsilon Greedy Settings:");
        System.out.println("Epsilon:" + epsilon);
        System.out.println("Learning rate:" + learningRate);
        super.printSettings();
        System.out.println();
    }


}
