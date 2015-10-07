/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.util.Vector;

/**
 *
 * @author kristof
 */
public class Output {

    private Vector<double[]> outputs;
    private Vector<String> descriptions;
    private String title;

    public Output(String t) {
        outputs = new Vector<double[]>();
        descriptions = new Vector<String>();
        title = t;
    }

    public String getTitle() {
        return title;
    }

    public void add(double[] o, String d) {
        outputs.add(o);
        descriptions.add(d);
    }

    public String getDescription(int i) {
        return descriptions.get(i);
    }

    public double[] getStatistics(int i) {
        return outputs.get(i);
    }

    public int size() {
        return outputs.size();
    }



    




}
