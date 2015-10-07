/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import core.AlgorithmInterface;
import core.defaultAlgorithm;
import core.epsilonGreedyAlgorithm;
import core.settings.basicSettings;
import java.util.Vector;
import javax.swing.JProgressBar;

/**
 *
 * @author kristof
 */
public class algoList extends Thread {
    protected Vector<AlgorithmInterface> lst;
    protected JProgressBar bar;
    protected Output[] statistics;

    public algoList(JProgressBar p) {
        lst = new Vector<AlgorithmInterface>();
        statistics = new Output[4];
        statistics[0] = new Output("Average Reward");
        statistics[1] = new Output("Percentage Optimal Actions");
        statistics[2] = new Output("Cummulative Average Reward");
        statistics[3] = new Output("Cummulative Percentage Optimal Actions");

        bar = p;
    }

    public Output[] getStatistics() {
        return statistics;
    }

    public void addAlgorithm(AlgorithmInterface algo) {
        lst.add(algo);
    }

    public void run() {
        for (int i=0; i < lst.size(); i++) {
            
            int percentage = 100*(i+1)/lst.size();
            AlgorithmInterface a = lst.get(i);
            a.run();
            String desc = a.getDescription();
            
            statistics[0].add(a.getAverageRewards(), desc);
            statistics[1].add(a.getPercentageOptimalActions(), desc);
            statistics[2].add(a.getCummulativeAverageRewards(), desc);
            statistics[3].add(a.getCummulativePercentageOptimalAction(), desc);

            bar.getModel().setValue(percentage);
             //System.out.println("\t" + percentage);
             //bar.getModel().setValue(percentage);
        }

        
            
        plotter p = new plotter(getStatistics());
        p.createPlots();

    }

}
