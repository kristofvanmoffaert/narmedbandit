/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.settings;

import core.Action;
import core.initializationMode;
import java.util.Random;



/**
 *
 * @author kristof
 */
public class basicSettings {
    
    protected int iterations;
    protected Action[] actions;
    protected int bandits;
    protected double learningRate;
    protected initializationMode initMode;

    public basicSettings() {
        iterations=1000;
        bandits=2000;
        actions = new Action[6];
        learningRate = 0.1;
        initMode = initializationMode.NORMAL;
        double mean = 1.0;

        Random r = new Random();
        for (int i=0; i< actions.length; i++)
            actions[i] = new Action(i+1, mean + r.nextGaussian());

        /*
        actions[0].setQStar(2.70);
        actions[1].setQStar(2.10);
        actions[2].setQStar(1.50);
        actions[3].setQStar(0.90);
        actions[4].setQStar(-1.50);
        actions[5].setQStar(-2.70);
        */

        //initMode = initializationMode.NORMAL;
    }


    public basicSettings(int it, Action[] acts, int nrbandits) {
        iterations = it;
        actions = acts;
        bandits= nrbandits;
        //initMode= inits;
    }

    public void copyBasicSettings(basicSettings s) {
        this.iterations = s.iterations;
        this.actions = s.actions;
        //this.initMode = s.initMode;
        this.bandits = s.bandits;
        this.learningRate = s.learningRate;
        this.initMode = s.initMode;
    }

        public initializationMode getInitializationMode() {
        return initMode;
    }

    public void setInitilizationMode(initializationMode m) {
        initMode = m;
    }


    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double d) {
        learningRate=d;
    }

    
    public int getIterations() {
        return iterations;
    }

    public void setIterations(int i) {
        iterations = i;
    }

    public Action[] getActions() {
        return actions;
    }

    public int getBandits() {
        return bandits;
    }

    public void setBandits(int b){
        bandits = b;
    }

    public void setActions(Action[] a) {
        actions = a;
    }

    public String toString() {
        return "lr:"+learningRate;
    }

    public void printSettings() {
        System.out.println("# bandits: " + bandits);
        System.out.println("# iterations: " + iterations);
        System.out.println("Learning rate:" + learningRate);
        System.out.println("# actions: " + actions.length);
        for (int i=0; i < actions.length; i++)
            System.out.println("\t Q*"+ actions[i].getId() + " --> " + actions[i].getQStar());
        
    }


}
