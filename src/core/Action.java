/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 *
 * @author kristof
 */
public class Action {
    private int id;
    private double Qstar;

    public Action(int id, double Q) {
        this.id=id;
        Qstar=Q;
    }

    public int getId() {
        return id;
    }

    public double getQStar() {
        return Qstar;
    }

    public void setQStar(double q) {
        Qstar = q;
    }
    
}
